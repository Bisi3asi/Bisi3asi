import "./App.css";

// 컴포넌트들
function Header() {
  return (
    <header>
      <h1>
        <a href="/">React</a>
      </h1>
    </header>
  );
}

function Article() {
  return (
    <article>
      <h2>Welcome</h2>
      Hello, WEB!
    </article>
  );
}

function Navbar(){
  <nav>
        <ol>
          <li>
            <a href="/read/1">html</a>
          </li>
          <li>
            <a href="/read/2">css</a>
          </li>
          <li>
            <a href="/read/3">js</a>
          </li>
        </ol>
      </nav>
}

function App() {
  return (
    <div>
      <Header></Header>
      <Article></Article>
      <Navbar></Navbar>
    </div>
  );
}

export default App;
