import Leaf from '../resources/CarbonLeaves.avif' 
import Header from '../Header';

function Carbon() {
  return (
    <div className='container'>
        <Header></Header>
      <div><img src={Leaf}></img></div>
    </div>
  );
}

export default Carbon;
