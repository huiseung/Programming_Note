# Eureka
- 마이크로 서비스들을 등록하는 서버


```java
// MSA server에 Application


@EnableDiscoveryClient
@SpringBootApplication
public class Application{

}

```

# service간 통신법
## RestTemplate

## @FeignClient 
- 라이브러리
  - org.springframework.cloud:spring-cloud-starter-openfeign


```java
// MSA server에 Application


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Application{

}

```

# Spring Cloud LoadBalancer
## Ribbon
- client side load balancer
- spring boot 2.4에서 maintenance 
- 대체제 Spring Cloud LoadBalancer

# Spring Cloud Gateway
## Zuul
- backend side api gateway(reverse proxy)
- spring boot 2.4에서 maintennace
- 대체제 Spring Cloud Gateway

## Filter


