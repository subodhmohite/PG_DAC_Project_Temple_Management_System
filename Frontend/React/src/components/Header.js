import React from "react"
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function Header()
{
    

    return(
        <div>
            <div id = "div2" className="text-center"  style={{backgroundImage:"https://www.mahalaxmikolhapur.com/img/logo2_retina3.png"}}>
            <h2 style={{ color: 'red'}}>SHREE MAHALAXMI MANDIR,KOLHAPUR </h2> 
            </div>

           
        </div>

        
    )
}


export default Header;