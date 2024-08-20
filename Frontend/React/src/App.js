import './App.css';
import Home from './components/Home';
import {Routes,Route, BrowserRouter } from 'react-router-dom';
import NotFound from './components/NotFound';
import Copyright from './components/Copyright';
import ContactUs from './components/ContactUs';
import Darshan from './components/Darshan';
import Arti from './components/Arti';
import Pooja from './components/Pooja';
import Accomodation from './components/Accomodation';
import TandC from './components/TandC';
import Feedback from './components/Feedback';
import Faq from './components/Faq';
import SignUp from './components/Signup';
import Admin from './components/AdminComponent/Admin'
import AllPooja from './components/AdminComponent/AllPooja';
import AllAccomodation from './components/AdminComponent/AllAccomodation';
import AllUsers from './components/AdminComponent/AllUsers';
import AllDarshan from './components/AdminComponent/AllDarshan';
import AllArti from './components/AdminComponent/AllArti';
import UserAllPooja from './components/UserComponent/UserAllPooja';
import UserAllAarti from './components/UserComponent/UserAllAarti';
import UserAllAccomodation from './components/UserComponent/UserAllAccommodation'
import UserProfile from './components/UserComponent/UserProfile'
import NormalArti from './components/WithoutLoginUSer/NormalArti'
import UserAllDarshan from './components/UserComponent/UserAllDarshan';
import NormalAccommodation from './components/WithoutLoginUSer/NormalAccommodation';
import NormalPooja from './components/WithoutLoginUSer/NormalPooja';
import NormalDarshan from './components/WithoutLoginUSer/NomalDarshan';
import User from './components/UserComponent/User';



function App() {

  return (
    <BrowserRouter>
    <div>
     
        <Routes>
          <Route exact path="/admin" element={<Admin/>}>
            <Route exact path="all-pooja" element={<AllPooja/>}/>
            <Route exact path="all-aarti" element={<AllArti/>}/>
            <Route exact path="all-dashan" element={<AllDarshan/>}/>
            <Route exact path="all-accommodation" element={<AllAccomodation/>}/>
            <Route exact path="all-users" element={<AllUsers/>}/>
          </Route>
          

          <Route exact path="/" element={<Home/>} />
          <Route exact path="/home" element={<Home/>} /> 
          <Route exact path="/copyright" element={<Copyright/>} />
          <Route exact path="/accomodation" element={<NormalAccommodation/>} /> 
          <Route exact path="/darshan" element={<NormalDarshan/>} /> 
          <Route exact path="/arti" element={<NormalArti/>} /> 
          <Route exact path="/pooja" element={<NormalPooja/>} /> 
          <Route exact path="/contactus" element={<ContactUs/>} /> 
          <Route exact path="/login" element={<Home/>} />  
          <Route exact path ="/signup" element={<SignUp/>}/>
          <Route exact path="/faq" element={<Faq/>} /> 
          <Route exact path="/feedback" element={<Feedback/>} /> 
          <Route exact path="/tandc" element={<TandC/>} /> 
          <Route path="*" element={<NotFound/>} />

            <Route exact path ="accommodation/add" element={<Accomodation/>}/> 
            <Route exact path="darshan/add" element={<Darshan/>}/>
            <Route exact path="aarti/add" element={<Arti/>}/>
            <Route exact path="pooja/add" element={<Pooja/>}/>

          <Route exact path ="/user" element={<User/>}> 
            <Route exact path ="pooja/" element={<UserAllPooja/>}/>
            <Route exact path ="aarti/" element={<UserAllAarti/>}/> 
            <Route exact path ="darshan/" element={<UserAllDarshan/>}/>
            <Route exact path ="accommodation/" element={<UserAllAccomodation/>}/>
            <Route exact path ="my-profile" element={<UserProfile/>}/>


            
            {/* <Route exact path="darshan/add" element={<Darshan/>}/> */}
          </Route>    
        </Routes>
     
    </div>
    </BrowserRouter>
  );
}

export default App;
