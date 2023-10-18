import { Link } from 'react-router-dom';
import logoRed from './resources/UBS_WHITE.png'
function Header() {
  return (
    <nav  className="navbar navbar-expand-xl fixed-top navbar-dark bg-dark">
      <a style={{paddingLeft: "10px"}} className="navbar-brand" href="#">IntelliSensePool</a>
      <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>

      <div  className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav mr-auto">
          <li className="nav-item active">
            <a className="nav-link"> <Link  style={{ color: '#fff',textDecoration: 'none' }}  to="/car-ride-blog"> IntelliSenseBlog</Link></a>
          </li>
          <li className="nav-item">
            <a className="nav-link"><Link  style={{ color: '#fff',textDecoration: 'none' }} to="/">Home</Link></a>
          </li>
          <li className="nav-item">
            <a className="nav-link"><Link  style={{ color: '#fff',textDecoration: 'none' }} to="/carbon-footprint">Reduced Carbon Foot Print</Link></a>
          </li>
        </ul>
      </div>

       <img className="navbar-brand" src={logoRed} width="fit-content" height="50px"/>

    </nav>
  );
}

export default Header;