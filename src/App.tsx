// import './App.css';
import Login from './Login/Login';
import { Route, Routes } from 'react-router-dom';
import Carbon from './CarbonFootprint/Carbon';
import Blog from './CarBlog/Blog';
import UserDetails from './UserDetails/UserDetails';
// Bootstrap CSS
import "bootstrap/dist/css/bootstrap.min.css";
// Bootstrap Bundle JS
import "bootstrap/dist/js/bootstrap.bundle.min";
function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Login/>}></Route>
        <Route path="/carbon-footprint" element={<Carbon/>}/>
        <Route path='/car-ride-blog' element={<Blog/>}/>
        <Route path='/user-details' element={<UserDetails/>}/>
      </Routes>  
    </div>
  );
}

export default App;
