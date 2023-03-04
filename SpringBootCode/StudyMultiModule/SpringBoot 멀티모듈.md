# 멀티 모듈
## 문제
- 여러 서버에서 공통으로 사용하는 기능이 있을 경우
- 같은 기능이 여러 프로젝트에 있을 경우 코드 관리가 어렵다

## 해결
- 한 곳에서 공통 기능 코드를 작성, 
- 멀티모듈

## 구성법
- build system을 gradle로 새 프로젝트 생성
- src 폴더 제거
- 해당 프로젝트 root 폴더에 moudle 추가
- 프로젝트 settings.gradle 파일에 다음 코드 추가
  - include 모듈명
- 프로젝트 build.gradle 파일 작성
- 각 모듈마다 폴더 생성
    - d
- SpringApplication class 생성