# 코딩애플 리액트 강의 클론코딩

## 0 ~ 2 강

### 리액트 사용 이유

웹앱으로 전환이 아주 쉬움.

웹도, 앱도 가능

### blog 샘플 프로젝트 생성

`npx create-react-app blog`

### npm 실행

`cd blog; npm start`

`localhost:3000` 에 동작하는 화면 확인 가능

- nopdejs를 설치하면 npm이라는 툴이 같이 설치됨

- package.json: 설치한 라이브러리 목록

- 리액트가 좋은 이유: 데이터 바인딩이 쉽다
`document.getElementsById().innerHTML = '';` -> `{데이터}` 

- 중괄호 내에 함수가 들어갈 수 있음

```js
let posts = '강남 고기 맛집';
<h4> {posts} </h4>
```

```js
{ 함수() }
```

## 3강

### State

ES6 Destructing (코틀린의 구조분해 문법인 듯)

```js
let [글제목, 글제목_변경] = useState('남자 코트 추천');

let [글제목, 글제목_변경] = useState(['남자 코트 추천', '강남 우동 맛집']);
```

그냥 변수는 변경되어도 자동 재렌더링이 안되고 새로고침이 된다고 한다

이런 이유로 state를 사용한다고 한다

자주 바뀌는 중요한 데이터는 변수가 아닌 state로 저장해서 사용하는게 좋다고 한다

## 4강 이벤트 넣기

### ES Lint 없애기

- JS의 예약어는 사용 못한다
  - 예를들어
    - `class`대신에 `className` 을 사용해야 한다
    - `font-size` -> `fontSize`

- 터미널에 뜨는 warning을 (eslint) 보기 싫으면

최상단에

```text
/* eslint-disable */
```

### 이벤트 넣기

기존 방식

EventListener, onClick

```js
addEventListener('click', function() {
    console.log('b');
  })
```

리액트

```js
<span onClick={1 + 1}>
<span onClick={ 함수() }>
<span onClick={ () => {} }>
```

### 숙제

버튼을 누르면 `남자코트 추천` -> `여자코트 추천`

내 코드

```js
글제목_변경(['여자 코트 추천', 글제목[1], 글제목[2]])
```

쌤 코드는 5강에서!

### 5강

### copy

shallow copy

값 공유

```js
var newArray = 글제목;
```

deep copy

```js
var newArray = [...글제목];
```

`...`이라는 spread operator를 사용해야 한다

리액트 대 원칙: immutable data
state는 직접 변경하지 않는다!

### 최종 코드

```js
<button onClick={ 제목_바꾸기 }>코튼 성별 변경</button>

function 제목_바꾸기() {
    var newArray = [...글제목];
    debugger;
    newArray[0] = '여자코트 추천'
    글제목_변경(newArray);
  }
```

### 기타 등등

- 페이지 나누고 이런건 라우터를 사용해야 한다고 한다

### 글 상세페이지 UI 만들기
