# 빌드후 jar 실행
- ./gradlew clean build
  - 성공시 build/libs에 *-SNAPSHOT.jar 파일 생긴다
- java -jar ./build/libs/userService-0.0.1-SNAPSHOT.jar --server.port=9004


# 실행
- ./gradlew clean bootRun --args='server.port=8080'

# 인텔리제이 설정 실행 법
- 같은 코드에 서버 여러대 띄우기
  - run configurations에서 설정 복사후, Modify Options에 VM Option 추가후 -Dserver.port=9002 설정