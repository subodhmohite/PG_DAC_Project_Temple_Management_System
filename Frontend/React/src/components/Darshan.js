import React, { useEffect, useState } from "react";
import Common from "./Common";
import { toast } from "react-toastify";
import DarshanRunningLine from "./DarshanRunningLine";
import FooterNav from "./FooterNav";
import Payment from "./Payment";
import axios from "axios";

const Darshan = () => {

  const jwt = sessionStorage.getItem("jwtToken");

  // State variables for form data and response message
  const [formData, setFormData] = useState({
    bookingDate: "",
    timeSlot: "",
    persons: "",
    amount: "200",
    //fullName: "",
    //age: "",
    //gender: "",
    //idNo: "",
    //idProof: "",
  });
  const [responseMessage, setResponseMessage] = useState("");

  // Function to handle form submission
  const handleSubmit = (e) => {
   
    axios.post("http://localhost:8443/user/darshan/add", formData ,{
      headers:{
        "Authorization":"Bearer "+jwt
      }
    })
      .then((response) => {
        setResponseMessage("Data submitted successfully");
        console.log("Response:", response.data);
        toast.success("Successfully Booked  Darshan");
      })
      .catch((error) => {
        setResponseMessage("Error submitting data");
        console.error("Error:", error);
        toast.error("Something Went Wrong In Darshan!!");
      });
  };

  // Function to handle input change
  const handleInputChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    document.title = "Darshan";
  }, []);

  return (
    <div>
      <div>
        <Common />
        <DarshanRunningLine />
      </div>

      <div id="darshan">
        <h4 style={{ color: "red", marginLeft: 10, marginTop: 10 }}>Book Darshan</h4>
        <hr />

        <div id="darshandetailsentry" className="row">
          {/* Form fields */}
          {/* Date */}
          <div id="datebutton" className="textf col-sm-2" style={{ marginLeft: 10 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">Date<sup className="text-danger"> *</sup></label>
            <input type="date" className="form-control ng-binding ng-untouched ng-valid" name="bookingDate" value={formData.bookingDate} onChange={handleInputChange} />
          </div>
          {/* Time Slot */}
          {/* <div id="timeslotbutton" className="textf col-sm-2" style={{ marginLeft: 10 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">Time Slot<sup className="text-danger"> *</sup></label>
            <input type="date" className="form-control ng-binding ng-untouched ng-valid" name="timeSlot" value={formData.timeSlot} onChange={handleInputChange} />
          </div> */}
                      {/* Select Time Slot */}
                      <div className="row">
                        <select class="form-select" aria-label="Default select example" id="timeSlot" name="timeSlot" value={formData.timeSlot}  onChange={handleInputChange}  style={{width:200, height:35,marginLeft:300,marginTop:-35}}>
                          <option selected>Select Time Slot</option>
                          <option value="SIX_AM" >6:00</option>
                          <option value="EIGHT_AM" >8:00</option>
                          <option value="TEN_AM" >10:00</option>
                          <option value="TWO_PM" >14:00</option>
                          <option value="FOUR_PM" >16:00</option>
                          <option value="SIX_PM" >18:00</option>
                          <option value="EIGHT_PM" >20:00</option>
                        </select>
                      </div>
          {/* No of Person */}
          <div id="darshandetailsentry2" className="row" style={{ marginTop: 5 }}>
            <div id="datebutton" className="textf col-sm-2" style={{ marginLeft: 10 }}>
              <label className="textf ng-binding" htmlFor="inputLarge">No of Person<sup className="text-danger"> *</sup></label>
              <input type="number" className="form-control ng-binding ng-untouched ng-valid" name="persons" value={formData.persons} onChange={handleInputChange} min={1} max={4} />
            </div>
            {/* Amount */}
            <div id="amountbutton" className="textf col-sm-2" style={{ marginLeft: 10 }}>
              <label className="textf ng-binding" htmlFor="inputLarge">Amount<sup className="text-danger"> *</sup></label>
              <input type="number" className="form-control ng-binding ng-untouched ng-valid" name="amount" value={formData.amount} readOnly/>
            </div>
          </div>
        </div>
      </div>
      <div>
        <Payment/>
      </div>

      
          {/* Login button */}
        
            <div id="loginButton" style={{ marginLeft: 10, marginTop: 15 }}>
              <button type="button" className="btn btn-danger" onClick={()=>{handleSubmit()}}>Book</button>
            </div>
          
        

      <div id="footerNote" style={{ marginLeft: 5 }}>
        <b>Note:-</b><br />- Fields marked<sup className="text-danger"> *</sup> are Mandatory<br />
        <b>- At the time of verification, all the devotees should produce the same original Photo IDs furnished at the time of Registration.</b><br />
        <b>- Devotees will not be allowed to avail the service in case of any mismatch.</b><br />
        <b>- Quota for the 'Unavailable dates' may be available in future, in case of any cancellations from other devotees.</b>
      </div>

      <div>
        <FooterNav />
      </div>
    </div>
  );
};

export default Darshan;
