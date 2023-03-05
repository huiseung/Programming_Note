# Architecture
![](./image/architecture.PNG)

# 요구사항

## 상품 등록
![](./image/post-product-service-%EC%83%81%ED%92%88%EB%93%B1%EB%A1%9D.PNG)
```
POST /product-service/

// reuqest body
{
  "productName": "testBook",
  "stock": 10,
  "price": 1000
}
```

## 상품 조회
![](./image/get-product-service-%EB%AA%A8%EB%93%A0%EC%83%81%ED%92%88%EC%A1%B0%ED%9A%8C.PNG)
```
GET /product-service/products
```

## 상품 주문
![](./image/post-order-service-%EC%83%81%ED%92%88%EC%A3%BC%EB%AC%B8.PNG)
```
POST /order-service/users/{userId}/orders

// request body
{
    "productId": "b8ba3e44-890c-4c16-9eae-219996d0f72a",
    "quantity": "2",
    "unitPrice": "1000"
}
```


## 주문한 상품 확인
  - 직접 요청도 되지만, FeignClient로 user-service에서 호출 가능하게 구현

```
GET /order-service/users/{userId}/orders
```


## 회원가입
![](./image/post-user-service-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85.PNG)
```
POST /user-service/users

{
  "name": "testName",
  "identifier": "testId",
  "password": "testPassword"
}
```

## 사용자 정보 확인
![](./image/get-user-service-%EC%82%AC%EC%9A%A9%EC%9E%90%EC%A0%95%EB%B3%B4%EC%A1%B0%ED%9A%8C.PNG)
```
GET /user-service/users/{userId}
```


## 상품 수량 업데이트
  - order-service에서 product-service로 message 전송



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
    - kafka



