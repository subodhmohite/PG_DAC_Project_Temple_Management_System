import React from "react";
import { NavLink} from "react-router-dom";
import {  toast } from "react-toastify";
import 'bootstrap/dist/css/bootstrap.min.css';
import "react-toastify/dist/ReactToastify.css";
import { useNavigate} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';




const LoginNavbar = () => {



  const handleOnCick =()=>{
    toast.success("Routing To Profile", {
      position: "top-center",
      autoClose: 3000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
    });

    setTimeout(() => {
      navigate("/user"); // Navigate to the "/next-page" route
    }, 3500);

  }


  const navigate = useNavigate();

    const handleLogout = () => {
        sessionStorage.removeItem("jwtToken");
        toast.success("Come Back Agin!!!", {
          position: "top-center",
          autoClose: 3000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
        });
    
        // Navigate to another page after a delay
        setTimeout(() => {
          navigate("/home"); // Navigate to the "/next-page" route
        }, 3500); // Wait for 2 seconds before navigating
      };



  

  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light justify-content-center   ">
      <div className="container-fluid">
        <div className="collapse navbar-collapse justify-content-center" id="navbarNav"  >
          <ul className="navbar-nav">

          <div>
          <button
            className={"btn"}
            style={{ backgroundColor: "green", marginLeft: "400" }}
            onClick={handleOnCick}
          >
            MyProfile
          </button>
          </div>


          
            
            <li className="nav-drashan">
              <NavLink className="nav-link items" to={"/home"}><b>Home</b></NavLink>
            </li>


            <li className="nav-drashan">
              <NavLink className="nav-link items" to={"/darshan/add"}><b>Darshan</b></NavLink>
            </li>
            
            <li className="nav-arti">
              <NavLink className="nav-link items" to={"/aarti/add"}><b>Aarti</b></NavLink>
            </li>

            <li className="nav-pooja">
            <NavLink className="nav-link items" to={"/pooja/add"}><b>Pooja</b></NavLink>
            </li>

            <li className="nav-accomodation">
            <NavLink className="nav-link items" to={"/accommodation/add"}><b>Accomodation</b></NavLink>
            </li>    
          </ul>

          <div>
          <button
            className={"btn"}
            style={{ backgroundColor: "orange", marginLeft: "400" }}
            onClick={handleLogout}
          >
            Log Out
          </button>
          </div>
          
         
        </div>
      </div>
     
    </nav>
  );
};

export default LoginNavbar;
