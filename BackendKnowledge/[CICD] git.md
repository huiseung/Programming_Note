# git
## 해결하려는 문제
- 코드 변경 사항을 관리 하고 싶다
- 여러명이 공동으로 코드를 관리하는 공간이 있었으면 한다
- 과거에 작성한 코드로 복원하고 싶다

# github
- web application
- git이 없어도 코드 업로드가 가능하지만 대부분 git으로 연동해 사용한다
## 해결하려는 문제
- 로컬이 아닌 원격 서버에 코드를 저장
- 코드 리뷰, 이슈 등록 같은 협력에 도움되는 기능 제공

# 명령어
## 계정 등록
- git config --global user.name 이름
- git config --global user.email 이메일
- git config --list

## 파일 관리 상태 변경
- git init
  - 해당 폴더에 있는 파일 관리 시작
- git add 파일이름
  - 특정 파일 staging
- git add .
  - 모든 unchecked file staging
- git reset HEAD 파일이름
  - add 취소, staging에서 unchecked로 바꾸기 
- git commit -m "메세지"
  - commit시 메세지를 남긴다 
  - git commit만 입력하면 메세지 작성용 에디터를 띄운다
- git reset --soft HEAD^
  - commit 취소, 가장 최근 commit 파일을 staging 상태로 변경 
- git reset HEAD^
  - commit 취소, 가장 최근 commit 파일을 unchecked 상태로 변경
- git reset HEAD~2
  - commit 취소, 최근 2개 commit 파일을 unchecked 상태로 변경
- git commit --amend -m "메세지"
  - commit 메세지 재 작성
  - git commit --amend만 입력하면 에디터를 띄운다
- git push [remote name] [branch name]
- push 취소법

## 파일 상태 확인
- git status
- git log --oneline
  - commit 기록 보기

![](./image/git.PNG)

## 내려 받기
- git clone
- git fetch
- git pull

## 병합
- git merge


## 브랜치
- git branch
- git checkout -b [브랜치이름]
- git checkout [브랜치이름]

