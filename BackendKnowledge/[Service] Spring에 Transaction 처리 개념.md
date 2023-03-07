# Transaction
## 문제 
- 비즈니스 로직 실행 중간에 SQL 처리 실패등에 이유로 데이터베이스가 원하는 방향으로 변경이 생기지 않는 경우를 막고 싶다

## 해결
- 하나 이상에 SQL을 하나에 작업으로 묶어 처리하자
  - 이 작업 단위를 트랜잭션이라 부른다
- 데이터베이스는 하나에 SQL을 기본 트랜잭션으로 다룬다. 개발자는 하나 이상에 SQL이 하나에 트랜잭션으로 처리 되게 끔 코드를 작성한다

## 코드
```java
// with jdbc
public class UserService{
    private final UserRepository userRepository;
    private final DataSource dataSource;

    public void transfer(Long fromId, Long toId, Long money) throws SQLException{
        Connection con = this.dataSource.getConnection();
        try{
            con.setAutoCommit(false); // 트랜잭션 시작
            businnesLogic(con, fromId, toId, Money);
            con.commit();
        }catch(SQLException e){

        }finally{
            release(con);
        }
    }
}

```

## 남은 문제
- 하나에 트랜잭션안에 SQL 전달 메서드는 같은 Connection을 사용해야 해서 Connection을 파라미터로 넘겨줘야 한다

# TransactionSychronizationManager
## 문제 
- 하나에 트랜잭션안에 SQL 전달 메서드는 같은 Connection을 사용해야 해서 Connection을 파라미터로 넘겨줘야 한다
  - 트랜잭션 관리 책임이 여러 클래스에 부여된다

## 해결
- 트랜잭션 동기화
- 스레드마다 사용하는 커넥션을 관리해주는 클래스를 만들자

## 코드
```java
public class UserService{
    private final UserRepository userRepository;
    private final DataSource dataSource;

    public void transfer(Long fromId, Long toId, Long money) throws SQLException{
        TransactionSynchronizationManager.initSynchronization();
        Connectionn con = DataSourceUtils.getConnection(dataSource);
        try{
            con.setAutoCommit(false); 
            businnesLogic(fromId, toId, Money); // Connection을 파라미터로 주지 않아도 괜찮다
            con.commit();
        }catch(SQLException e){

        }finally{
            release(con);
        }
    }
}
```

## 남은 문제
- JDBC에 의존한 트랜잭션 처리 코드
  - con.setAutoCommit, con.commit()

# PlatformTransactionManager
## 문제
- JDBC를 감싸 SQL을 처리하는 JPA같은 API를 사용할 경우 트랜잭션을 처리하는 코드가 달라진다

## 해결
- 트랜잭션 추상화
- 트랜잭션을 관리하는 인터페이스를 만들자
  - 인터페이스
    - PlatformTransactionManager
  - 구현체
    - DataSourceTransactionManager
    - JpaTransactionManager
  - Spring Boot는 application 설정 파일을 보고 실행 시점에 적절한 구현체를 Bean으로 등록한다

## 코드
```java
package org.springframework.transaction;

public interface PlatformTransactionManager{
    TransactioNStatus getTransaction(TransactioNDefinition var1) thrwos TransactionException;
    void commit(transactionStatus var1) throws TransactionException;
    void rollback(transactionStatus var1) throws TransactioNException;
}

```

```java
public class UserService{
    private final UserRepository userRepository;
    private final PlatformTransactionManager transactionManaager;

    public void transfer(Long fromId, Long toId, Long money) throws SQLException{
        TransactionStatus status = trnsactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            businnesLogic(fromId, toId, Money); 
            transactionManager.commit();
        }catch(SQLException e){
            transctionManager.rollback();
        }
    }
}
```

## 남은 문제
- 반복되는 트랜잭션 처리 코드

# @Declarative Transaction Management
## 문제
- 트랜잭션 처리 코드를 매서드마다 작성해야한다

## 해결
- AOP를 활용
- @Transactional 어노테이션을 붙은 메서드는 트랜잭션 처리 코드가 추가 되게끔 하자

## 코드
```java
public class UserService{
    private final UserRepository userRepository;

    @Transactional
    public void transfer(Long fromId, Long toId, Long money) throws SQLException{
        businnesLogic(fromId, toId, Money); 
    }
}
```


# 정리
- 스프링은 3가지 아이디어를 활용해 트랜잭션을 처리한다
  - Problem: 