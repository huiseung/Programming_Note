## Example - User
```java
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Table(name="users")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column
    private String userId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String identifier;
    @Column(nullable = false)
    private String password;

}

```

```java


```

# @Id, @GeneratedValue(strategy=GenerationType.)
- @Id가 붙은 속성은 기본키(PK)다
- @GeneratedValue
  - 게빌지기 PK를 생성하지 않고 프레임워크가 알아서 만들어 준다
- PK 생성 전략
  - AUTO
    - 기본값, 아래 세가지 중 하나를 사용하는 SQL 방언에 맞춰 자동 섫정
  - IDENTITY
    - 데이터베이스가 AUTO_INCREMENT 해주길 바란다
      - H2, MySQL, PostgreSQL 제공  
  - SEQUENCE
  - TABLE
    - 키를 관리하는 테이브를 만든다
    - 모든 데이터 베이스에 사용 가능
  

# Entity별로 테이블 생성 데이터베이스 다르게 설정하기
## 문제 
- MSA 환경에서 각 마이크로 서비스별로 데이터베이스를 다르게 사용
- Entity 코드는 같은 폴더에서 관리

## 해결



# @Index