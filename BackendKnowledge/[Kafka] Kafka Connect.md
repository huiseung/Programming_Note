# Kafka Connect
- 외부 시스템과 카프카 클러스터 사이를 연결하는 소프트웨어
## 설치
- mysql connector java
  - https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.29
    - jar 파일 다운로드해서 kafka 홈폴더/share/java/kafka에 넣어 놓기 
## Source Connect
- push system 연결
- 
## Sink Connect
- conume system 연결

## 명령어
### Connect 실행
- 카프카 클러스터가 켜져 있어야 한다
- %KAFKA_CONNECT_HOME%/bin/windows/connect-distributed.bat %KAFKA_CONNECT_HOME%/etc/kafka/connect-distributed.properties


## 모든 커넥터 조회
```
GET localhost:8083/connectors
```

## 커넥터 상세 조회
```
GET localhost:8083/connectors/{connectorName}/status
```

## Source Connect 추가
```
POST localhost:8083/connectors

// request body
{
    "name" : "my-source-connect",
    "config" : {
        "connector.class" : "io.confluent.connect.jdbc.JdbcSourceConnector",
        "connection.url":"jdbc:mysql://localhost:3306/testdb",
        "connection.user":"root",
        "connection.password":"1234",
        "mode": "incrementing",
        "incrementing.column.name" : "id",
        "table.whitelist":"users",
        "topic.prefix" : "my_topic_",
        "tasks.max" : "1"
    }
}

//header
Content-Type: application/json
```

- incrementing.column.name: 메세지를 생성 시점 기준이 되는 데이터베이스 테이블 컬럼 이름
- topic.prefix + table.whitelist 이름으로 토픽이 만들어 진다

```
// cosumer 쪽에 다음 형태에 메세지가 전달된다
{
    "schema":{
        "type":"struct",
        "fields":[
            {"type":"int64","optional":false,"field":"id"},
            {"type":"string","optional":false,"field":"identifier"},
            {"type":"string","optional":false,"field":"name"},
            {"type":"string","optional":false,"field":"password"},
            {"type":"string","optional":true,"field":"user_id"}
        ],
        "optional":false,"name":"users"
    },
    "payload":{
        "id":1,"identifier":"tId","name":"tName","password":"tPw","user_id":"tUserId"
    }
}
```

## Sink Connector 추가
```
POST localhost:8083/connectors

// request body
{
    "name":"my-sink-connect",
    "config":{
        "connector.class":"io.confluent.connect.jdbc.JdbcSinkConnector",
        "connection.url":"jdbc:mysql://localhost:3306/testdb",
        "connection.user":"root",
        "connection.password":"1234",
        "auto.create":"true",
        "auto.evolve":"true",
        "delete.enabled":"false",
        "tasks.max":"1",
        "topics":"my_topic_users" 
    }
}

//header
Content-Type: application/json
```

- topics에 이름대로 테이블이 만들어 진다

## 삭제
```
DELETE http://localhost:8083/connectors/{connectorName}
```

%KAFKA_HOME%/bin/windows/kafka-console-producer.bat --broker-list localhost:9092 --topic my_topic_users {"schema":{"type":"struct","fields":[{"type":"int64","optional":false,"field":"pk"},{"type":"string","optional":false,"field":"identifier"},{"type":"string","optional":false,"field":"name"},{"type":"string","optional":false,"field":"password"},{"type":"string","optional":true,"field":"user_id"}],"optional":false,"name":"users"},"payload":{"pk":1,"identifier":"tId","name":"tName","password":"tPw","user_id":"tUserId"}}