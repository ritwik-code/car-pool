import Map from '../resources/Map.jpeg'
import Header from '../Header';
import GoogleMapReact from 'google-map-react';
import { useState } from 'react';
// AIzaSyA4QzmTxPCPew__PgmRatiHvV3m5n82_Xk
function Login() {
  const [locationX, setLocationX] = useState("");
  const [locationY, setLocationY] = useState("");
  const [driver, setDriver] = useState(false);
  const [rider, setRider] = useState(false);
  const [message,setMessage] = useState("")
  // const AnyReactComponent = ({ text }) => <div>{text}</div>;


  function SimpleMap(){
    const defaultProps = {
      center: {
        lat: 10.99835602,
        lng: 77.01502627
      },
      zoom: 11
    };
  }
//todo display cluster
  let handleSubmit = async (e: { preventDefault: () => void; }) => {
    e.preventDefault();
    try {
      let res = await fetch("http://localhost:8080/saveUser", {
        method: "POST",
        credentials:'same-origin',
        body: JSON.stringify({
          locationX  : locationX,
          locationY  : locationY,
          driver     : driver,
          rider      : rider,
          message    : message
        }),
      });
      let resJson = await res.json();
      if (res.status === 200) {
        setMessage("User created successfully");
      } else {
        setMessage("Some error occured");
      }
    } catch (err) {
      console.log(err);
    }
  };




  return (
    <div className='container'>
      <Header></Header>
      <div className='row'>
        <label className='form-check-label'>Select Location:</label>
        
        {/* <div style={{ height: '100vh', width: '100%' }}>
      <GoogleMapReact
        bootstrapURLKeys={{ key: "AIzaSyA4QzmTxPCPew__PgmRatiHvV3m5n82_Xk" }}
        defaultCenter={defaultProps.center}
        defaultZoom={defaultProps.zoom}
      >
        <AnyReactComponent
          lat={59.955413}
          lng={30.337844}
          text="My Marker"
        />
      </GoogleMapReact>
      </div> */}



        <div className='col'>

        <label className="form-text-label" htmlFor='X'>X:</label>
        <input className="form-text-input" type="text" value={locationX} id="X" onChange={e=>setLocationX(e.target.value)}></input>
        <label className="form-text-label" htmlFor='X'>Y:</label>
        <input className="form-text-input" type="text" value={locationY} id="X" onChange={e=>setLocationY(e.target.value)}></input>
        </div>
      </div>

      
      <div className='row'>
        <label className='col'> Have a Car?</label>
        <input className='col' type='radio' onChange={e=>setDriver(true)}></input>
        <input className='col' type='radio' onChange={e=>setRider(true)}></input>
      </div>

      <div>
        <button type="submit" className="btn btn-primary" onClick={handleSubmit}>Submit</button>
      </div>
    </div>
  );
}

export default Login;
