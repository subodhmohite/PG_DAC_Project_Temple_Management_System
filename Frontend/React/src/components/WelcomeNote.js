import React from "react";
import Login from "./Login";
import RunningLine from "./RunningLine";

const WelcomeNote =()=>
{


    return(
<div  /*style={{backgroundImage:"https://artworkbird.co.in/sai-baba-marathi-png/"}} */>
              <div className="ng-binding text-center" style={{color:"maroon"}}>
                <h2>Welcome To Shree Mahalaxmi Darshan Booking Portal</h2>
               </div>

             <div id="welcomenote" className="text-center">		
                Devasthan Management Committee, Western Maharashtra, Kolhapur is pleased to launch of next generation 
                portal for availing Darshan, Aarti,Pooja and  Donation
                services.
                <br/>
                <RunningLine/>

             </div> 
             <div id="mainImage" /*style={{backgroundImage:"https://artworkbird.co.in/sai-baba-marathi-png/"}}*/>
                <table /*style={{backgroundImage:"https://artworkbird.co.in/sai-baba-marathi-png/"}}*/>
                    <tr>
                        <td>
                        <img src="https://mahalaxmikolhapur.com/gallery/photos/13.jpeg" width={230} height={360} style={{marginLeft:10}}/>
                
                        </td>
                        <td>
                        <div style={{marginLeft:300}} >
                         <Login/>
                        </div>
                        </td>
                    </tr>
                </table>
                
             </div>

           

                <br/><br/>
        </div>
    )
}

export default WelcomeNote;