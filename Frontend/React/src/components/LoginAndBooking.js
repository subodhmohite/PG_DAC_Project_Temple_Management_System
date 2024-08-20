import React from "react";




const LoginAndBooking =()=>
{
    return(

        <div class="row" style={{margin:'auto'}}>
            <div className="col-sm-6">
                <div className="card" style={{padding:6,color:"white", backgroundColor:"purple"}}><b>Login And Booking Process</b></div>
                <div className="container2">

                <div>
                        <a href="/signup" className="footer-links" tabIndex={"6"}
                            >  Click here to Register</a> .
                    </div>

                    

                    <div>
                        <div>
                            Details of the Photo IDs - Aadhar Card to be entered which will be verified at Kolhapur
                            while availing services.
                        </div>
                    </div>

                    

                    

                    

                    

                </div>
            </div>

            <div className="col-sm-6 heading-1">
                <div className="card" style={{padding:6,color:"white", backgroundColor:"purple"}}><b>Latest Updates</b></div>

                <div className="container2">
                    <div>
                        <div className="log-bul-cont-here" style={{marginLeft:-5}}>
                            Relaxed registration process and Introduced Simplified Login Process
                            

                            
                        </div>
                    </div>

                    <div style={{textAlignLast:"start"}}>
                        <ul style={{listStyle:"none",paddingLeft:10,float:"left"}}>
                            

                            <li style={{marginLeft:-20, textAlign:"justify"}} className="bul ng-scope">
                                <div className="log-bul-cont-here ng-binding">
                                 Quota for Paid Darshan, Aarti, Pooja and Accomodation will be released prior 30 days.
                                </div>
                            </li>


                            <li style={{marginLeft:-20, textAlign:"justify"}} className="bul ng-scope">
                                <div className="log-bul-cont-here ng-binding">
                                 Shree Ambabai devotees can book Aarti for maximum of 2 persons per booking.
                                </div>
                            </li>


                            <li style={{marginLeft:-20, textAlign:"justify"}} className="bul ng-scope">
                                <div className="log-bul-cont-here ng-binding">
                                Devasthan Management Committee does not authorize any agents for online bookings of 
                                 Darshan / Aarti / Accommodation / Donations / Pooja / Publications.
                                </div>
                            </li>


                            

                        
                        </ul>
                    </div>

                </div>
            </div>

        </div>
    )
}

export default LoginAndBooking;