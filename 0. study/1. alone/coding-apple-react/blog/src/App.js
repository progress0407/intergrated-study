import logo from './logo.svg';
import './App.css';

function App() {

  let posts = '강남 고기 맛집';

  let blackHeader = { color : 'white', fontSize : '30px' }

  function fn() {
    return 100;
  }

  return (
    <div className="App">
      <div className="black-nav">
        <div style= { blackHeader } >개발 Blog</div>
      </div>
      <h4> { posts } </h4>
      <img src={logo} />
      <h4> { fn() } </h4>
    </div>
  );
}

export default App;
