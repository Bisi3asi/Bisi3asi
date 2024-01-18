import "./App.css";

// 매개변수로 props를 던져준다.
function Header(props) {
  return (
    <header>
      <h1>
        {/* props 는 객체, title은 프로퍼티, title의 값을 사용한다. */}
        <a href="/">{props.title}</a>
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
  const lis = []

  // react는 key라는 약속된 prop을 부여함으로써 데이터를 바인딩하는데 최적화함
  for(let i=0; i<props.topics.length; i++){
    let t = props.topics[i];
    lis.push(<li key={t.id}><a href={'/read/'+t.id}>{t.title}</a></li>)
  }

  return (
    <nav>
      <ol>
        {lis}
      </ol>
    </nav>
  );
}

function App() {
  const topics = [
    {id: 1, title:'html', body:'html is ...'},
    {id: 2, title:'css', body:'css is ...'},
    {id: 3, title:'javascript', body:'javascript is ...'},
  ]

  return ( 
    <div>
      {/* props의 title이라는 프로퍼티를 정의한다. 함수 매개변수 처럼 이용 */}
      <Header title="REACT"></Header>
      <Article title="WELCOME!" description="Web is Stronger than me"></Article>
      {/* topics는 함수에서 정의해놓은 그대로를 전달 */}
      <Nav topics={topics}></Nav>
    </div>
  );
}

export default App;
