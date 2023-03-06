# JDBC
## 배경 지식
- 서버와 데이터 베이스 통신 과정

1) connection 생성(TCP 3 way hand shake)
2) SQL 전달
3) SQL 실행
4) SQL 결과 응답
5) connection 종료(TCP 4 way hand shake)

## 문제
- 한 가지 코드 방식으로 다양한 종류에 데이터 베이스를 다루고 싶다

## 해결
- 표준 API를 만들어 데이터베이스 제공사들이 구현체를 제공하자
- 개발자는 해당 인터페이스를 이용해 데이터베이스와 무관한 코드 작성 가능
- 이 표준 API를 JDBC라 부른다
  - Java DataBase Connection
  - 패키지 구성
      - java.sql, javax.sql
- JDBC를 편하게 사용하는 툴
  - SQL Mapper 기술 
    - JdbcTemplate, MyBatis
  - ORM 기술
    - JPA(Hibernate)
  - 어떤 기술을 이용하든 데이터베이스 접근에는 JDBC가 기반으로 사용된다


## 코드
- DriverManager로 Connection을 만들고
- Connection으로 Statement를 만들고
- Statement에 SQL을 담아 보내면
- SQL결과를 ResultSet에 담아 온다

```java
package java.sql;

public class DriverManager{
    public static Connection getConnection(String url, String user, String password) throws SQLException;
}
```

```java
package java.sql;

public interface Connection extends Wrapper, AutoCloseable{
    Statement createStatement() throws SQLException;
    PreparedStatement prepareStatement(String sql) throws SQLException;
    
    // 트랜잭션 처리와 관련있는 3가지 메서드
    void setAutoCommit(boolean autoCommit) throws SQLException;
    void commit() throws SQLException;
    void rollback() throws SQLException;
}
```

```java
package java.sql;

public interface Statement extends Wrapper, AutoClosable{
    ResultSet executeQuery(String sql) throws SQLException;
    int executeUpdate(String sql) throws SQLException;
    void close() throws SQLException;
}
```


```java
package java.sql;

public interface ResultSet extends Wrapper, AutoCloseable{
    boolean next() throws SQLException;
    void close() throws SQLException;
    String getString(int columnIndex) throws SQLException;
}
```

```java
pakcage java.sql;

public class SQLException extends Exception implements Iterable<Throwable>{}
```

