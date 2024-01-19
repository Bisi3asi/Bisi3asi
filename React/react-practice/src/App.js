import "./App.css";
import { useState } from "react"; // 상태 작성을 위한 import

// 매개변수로 props를 던져준다.
function Header(props) {
  return (
    <header>
      <h1>
        {/* function(event) 는 (event) => 로 유사 람다 지원 */}
        <a
          href="/"
          onClick={(event) => {
            event.preventDefault(); // 클릭해도 이벤트가 일어나지 않게 설정
            props.onChangeMode(); // props의 이벤트도 프로퍼티로 줘서 사용
          }}
        >
          {props.title}
        </a>
      </h1>
    </header>
  );
}

function Article(props) {
  return (
    <article>
      <h2>{props.title}</h2>
      <h3>{props.description}</h3>
    </article>
  );
}

function Nav(props) {
  const lis = [];

  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(
      <li key={t.id}>
        <a
          id={t.id}
          href={"/read/" + t.id}
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode(Number(event.target.id)); // event.target : 특정 이벤트를 유발시킨 태그
          }}
        >
          {t.title}
        </a>
      </li>
    );
  }

  return (
    <nav>
      <ol>{lis}</ol>
    </nav>
  );
}

function App() {
  // mode(data, function) data : 상태 정의 데이터, function : 상태 변경을 위한 함수
  const [mode, setMode] = useState("WELCOME");

  const [id, setId] = useState(null);
  const topics = [
    { id: 1, title: "html", body: "html is ..." },
    { id: 2, title: "css", body: "css is ..." },
    { id: 3, title: "javascript", body: "javascript is ..." },
  ];

  let content = null;
  if (mode === "WELCOME") {
    content = (
      <Article title="WELCOME!" description="Web is Stronger than me"></Article>
    );
  } else if (mode === "READ") {
    let title, body = null;
    for (let i = 0; i < topics.length; i++) {
      if (topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }
    content = <Article title={title} description={body}></Article>;
  }

  return (
    <div>
      <Header
        title="REACT"
        onChangeMode={() => {
          setMode("WELCOME");
        }}
      ></Header>
      <Nav
        topics={topics}
        onChangeMode={(_id) => {
          setMode("READ");
          setId(_id);
        }}
      ></Nav>
      {content}
    </div>
  );
}

export default App;
