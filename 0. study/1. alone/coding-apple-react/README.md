# 코딩애플 리액트 강의 클론코딩

- 리액트 사용 이유

웹앱으로 전환이 아주 쉬움.

웹도, 앱도 가능

- blog 샘플 프로젝트 생성

`npx create-react-app blog`

- npm 실행

`cd blog; npm start`

`localhost:3000` 에 동작하는 화면 확인 가능

- nopdejs를 설치하면 npm이라는 툴이 같이 설치됨

- package.json: 설치한 라이브러리 목록

- 리액트가 좋은 이유: 데이터 바인딩이 쉽다
`document.getElementsById().innerHTML = '';` -> `{데이터}` 

- JS의 예약어는 사용 못한다
  - 예를들어
    - `class`대신에 `className` 을 사용해야 한다
    - `font-size` -> `fontSize`

- 터미널에 뜨는 warning을 (eslint) 보기 싫으면

최상단에

```text
/* eslint-disable */
```
