import React from "react";
import { NavLink} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";


const Navbar = () => {

  

  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light justify-content-center   ">
      <div className="container-fluid">
        <div className="collapse navbar-collapse justify-content-center" id="navbarNav"  >
          <ul className="navbar-nav">


          <li className="nav-drashan">
              <NavLink className="nav-link items" to={"/home"}><b>Home</b></NavLink>
            </li>


            <li className="nav-drashan">
              <NavLink className="nav-link items" to={"/darshan"}><b>Darshan</b></NavLink>
            </li>
            
            <li className="nav-arti">
              <NavLink className="nav-link items" to={"/arti"}><b>Aarti</b></NavLink>
            </li>

            <li className="nav-pooja">
            <NavLink className="nav-link items" to={"/pooja"}><b>Pooja</b></NavLink>
            </li>

            <li className="nav-accomodation">
            <NavLink className="nav-link items" to={"/accomodation"}><b>Accomodation</b></NavLink>
            </li>    
          </ul>
          
         
        </div>
      </div>
     
    </nav>
  );
};

export default Navbar;
