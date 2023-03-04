# Kafka
## 설치
- http://kafka.apache.org/downloads
  - source file이 아니라 binary 파일을 다운 받자

## 폴더 구성
### config
- zookeeper.properties
### bin/windows


## 명령어
- powershell이 아닌 cmd에서 실행
### 서버 실행
- zookeeper
  - %KAFKA_HOME%/bin/windows/zookeeper-server.start.bat %KAFKA_HOME%/config/zookeeper.properties
- kafka
  - %KAFKA_HOME%/bin/windows/kafka-server-start.bat %KAFKA_HOME%/config/server.properties

### 토픽 생성
- %KAFKA_HOME%/bin/windows/kafka-topics.bat --bootstrap-server localhost:9092 --create --topic TestTopic --partitions 1

### 만들어진 토픽 목록 확인
- %KAFKA_HOME%/bin/windows/kafka-topics.bat --bootstrap-server localhost:9092 --list

### 만든 토픽 정보 확인
- %KAFKA_HOME%/bin/windows/kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic TestTopic

### 토픽 삭제
- %KAFKA_HOME%/bin/windows/kafka-topics.bat --bootstrap-server localhost:9092 --delete --topic TestTopic

### 메세지 push
- %KAFKA_HOME%/bin/windows/kafka-console-producer.bat --broker-list localhost:9092 --topic TestTopic

### 메세지 conume
- %KAFKA_HOME%/bin/windows/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic TestTopic --from-beginning


