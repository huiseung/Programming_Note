# Connection Pool
## 문제
- 서버와 데이터베이스 통신과정에 필요한 Connection 생성 소요 시간이 크다

## 해결
- 서버 최초 실행시 Connection을 여러개 만들어 두고, 필요시 가져다 쓰고 다 쓰면 반납하는 시스템을 만들자

## 코드

```java
package javax.sql;


```