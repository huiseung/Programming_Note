# 실행
- 환경설정에 bin 폴더 등록해 두면
  - 커맨드에서 jmeter 로 실행

# 테스트 플랜 생성
- file > new 

# Thread Group
- 테스트 플랜 > Add > Threads (Users) > Thread Group
  - Thread Properties
    - Number of Threads(users): 10  
    - Ramp-up period(second): 1
    - Loop Count: 2  
    - Ramp-up period 기간안에 Number of Threads * Loop Count 만큼 요청을 보낸다 

# Sampler
- Thread Group > Add > Sampler > HTTP Request
  - protocol
    - http
  - Server Name or IP: 접속 아이피 주소
    - localhost
  - Port: 접속 포트
    - 8080
  - Http Request: 메서드와 패스
    - GET /api/uesrs
  - Body Data
    - csv파일에서 쓰는 varaible names를 $를 이용해 접근
```
{
  "name": "${name}"
}
```
- Thread Group > Add > Config Element > CSV
  - Filename: csv
  - Variable Names: request body filed들을 , 로 구분해 넣기
  - Ignore first line: 첫 row에 제목을 넣을 경우 true
  - Recycle on EOF: csv파일 데이터 끝에 도달 했을때 thread 요청이 남아 있으면 다시 처음부터 이용
  - Stop Thread on EOF: 
- Thread Group > Add > Config Element > Http Header Manager


# Listener
- Http Request > Add > Listenner > View Result Tree, Summary Report, View Results in Table

- View Result Tree
  - 각 요청별 응답 결과 보기
- View Results in Table
  - View Result Tree를 테이블로 보기
- Summary Report
  - #Samples: Number of Threads * Ramp-up period
  - Average: 요청 처리 평균 시간(ms)
  - Min: 요청 처리 최소 시간(ms)
  - Max: 요청 처리 최대 시간(ms)
  - Std.Dev: 요청 처리 표준 편차
  - Error %: 오류 요청 수 / 전체 요청수 
  - Throughput: 초당 응답 요청 수
  - Received KB/sec: 초당 응답 받은 데이터 크기
  - Sent KB/sec: 초당 전송한 데이터 크기
  - Avg. Bytes: 전송 받은 데이터 크기 평균


# 실행과 초기화
- 재생 버튼을 누르면 전송 요청을 보내 응답 보고서가 작성된다
- 클린 올 버튼을 누르면 진행한 보고서가 초기화 된다