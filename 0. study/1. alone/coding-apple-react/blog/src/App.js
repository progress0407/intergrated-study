/* eslint-disable */

// import React from 'react';
import { useState } from 'react';
import logo from './logo.svg';
import './App.css';

function App() {

  let blackHeader = { color: 'white', fontSize: '30px' }

  let [글제목, 글제목_변경] = useState(['남자코트 추천', '강남 우동 맛집', '필즈의 개발 사랑 이야기']);
  let [따봉, 따봉_변경] = useState(0);
  let 따봉_변경_이벤트 = () => { 따봉_변경(따봉 + 1) };

  function 제목_바꾸기() {
    var newArray = [...글제목];
    debugger;
    newArray[0] = '여자코트 추천'
    글제목_변경(newArray);
  }

  return (
    <div className="App">

      <div className="black-nav">
        <div style={blackHeader} >개발 Blog</div>
      </div>

      <img src={logo} />

      <button onClick={제목_바꾸기}>코튼 성별 변경</button>

      <div className="list">
        <h3> {글제목[2]} <span onClick={따봉_변경_이벤트}>👍</span> {따봉} </h3>
        <p>4월 15일 발행</p>
        <hr />
        <h3> {글제목[1]} </h3>
        <p>3월 16일 발행</p>
        <hr />
        <h3> {글제목[0]} </h3>
        <p>2월 17일 발행</p>
        <hr />
      </div>

      <Modal />

    </div>
  );
}

function Modal() {
  return (
    <> {/* 만일 최외각을 한번더 감싸고 싶으면 이걸 이용하면 된다 */}
      <div className='modal'>
        <h2>제목 {글제목[0]}</h2>
        <p>날짜</p>
        <p>상세내용</p>
      </div>
      <div></div>
    </>
  )
}


export default App;
