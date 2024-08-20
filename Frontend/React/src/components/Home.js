import React from "react";
import Header from "./Header";
import FooterNav from "./FooterNav";
import LoginAndBooking from "./LoginAndBooking";
import Navbar from "./NavBar";
import WelcomeNote from "./WelcomeNote";


const Home = () =>
{
    return(

        <div>
            <div id="div1"
            style={{ backgroundColor: " #fff0e3" }}
            className="text-center">
            <img src="https://www.mahalaxmikolhapur.com/img/logo2_retina3.png" alt="Logo" style={{ width: "400px", height: "auto" }} />
          </div>



            <div>
            <Header/>
            </div>
            
            <div>
            <Navbar/>
            </div>

            <div>
            <WelcomeNote/>
            </div>

            <div>
            <LoginAndBooking/>
            </div>


            <div>
            <FooterNav/>
            </div>

    </div>

    )
}

export default Home;