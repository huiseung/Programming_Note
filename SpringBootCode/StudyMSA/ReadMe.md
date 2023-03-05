# Architecture
![](./image/architecture.PNG)

# 요구사항
- 상품 조회
```
GET /catalog-service/catalogs
```
```
{
    
}
```


- 상품 주문
```
POST /order-service/users/{userId}/orders

{
    "name": "",
    "identifier": "",
    "password": ""
}
```
- 주문한 상품 확인
```
GET /order-service/users/{userId}/orders
```

```
{
    "userId": "",
    "name": "",
    "orders": []
}
```

- 회원가입
```
POST /user-service/users
```


- 사용자 정보 확인
```
GET /user-service/users/{userId}
```


- 상품 수량 업데이트



# 패키지 구성
- discovery-service
  - 라이브러리
    - Eureka Server
- api-gateway-service
  - 라이브러리
    - Eureka Discovery Client
    - Gateway
    - Lombock
- user-service, order-service, order-service
  - 라이브러리
    - Eureka Discovery Client
    - Spring Web
    - Lombok
    - valid
    - jpa
    - mysql



