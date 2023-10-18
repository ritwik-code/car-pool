import { Link } from 'react-router-dom';

function Header() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <a className="navbar-brand" href="#">IntelliSensePool</a>
      <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>

      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav mr-auto">
          <li className="nav-item active">
            <a className="nav-link"> <Link  style={{ color: '#000',textDecoration: 'none' }}  to="/car-ride-blog"> IntelliSenseBlog</Link></a>
          </li>
          <li className="nav-item">
            <a className="nav-link"><Link  style={{ color: '#000',textDecoration: 'none' }} to="/">Home</Link></a>
          </li>
          <li className="nav-item">
            <a className="nav-link"><Link  style={{ color: '#000',textDecoration: 'none' }} to="/carbon-footprint">Reduced Carbon Foot Print</Link></a>
          </li>
          <li className="nav-item">
            <a className="nav-link"><Link  style={{ color: '#000',textDecoration: 'none' }} to="/user-details">User Details</Link>    </a>
          </li>
        </ul>
      </div>
    </nav>
  );
}

export default Header;