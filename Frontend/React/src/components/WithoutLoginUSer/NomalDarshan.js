import React, { useEffect, useState } from "react";
import Common from "./Common";
import { toast } from "react-toastify";
import DarshanRunningLine from "./DarshanRunningLine";
import FooterNav from "./FooterNav";
import axios from "axios";

const NormalDarshan = () => {

//   const jwt = sessionStorage.getItem("jwtToken");

//   // State variables for form data and response message
//   const [formData, setFormData] = useState({
//     bookingDate: "",
//     timeSlot: "",
//     persons: "",
//     amount: "",
//     //fullName: "",
//     //age: "",
//     //gender: "",
//     idNo: "",
//     //idProof: "",
//   });
//   const [responseMessage, setResponseMessage] = useState("");

//   // Function to handle form submission
//   const handleSubmit = (e) => {
   
//     axios.post("http://localhost:8443/user/darshan/add", formData ,{
//       headers:{
//         "Authorization":"Bearer "+jwt
//       }
//     })
//       .then((response) => {
//         setResponseMessage("Data submitted successfully");
//         console.log("Response:", response.data);
//         toast.success("Successfully Done In Darshan");
//       })
//       .catch((error) => {
//         setResponseMessage("Error submitting data");
//         console.error("Error:", error);
//         toast.error("Something Went Wrong In Darshan!!");
//       });
//   };

//   // Function to handle input change
//   const handleInputChange = (e) => {
//     setFormData({ ...formData, [e.target.name]: e.target.value });
//   };

//   useEffect(() => {
//     document.title = "Darshan";
//   }, []);

  return (
    <div>
      <div>
        <Common />
        <DarshanRunningLine />
      </div>

      <div id="darshan">
        <h4 style={{ color: "red", marginLeft: 10, marginTop: 10 }}>Darshan</h4>
        <hr />

        <div id="darshandetailsentry" className="row">
          {/* Form fields */}
          {/* Date */}
          <div id="datebutton" className="textf col-sm-2" style={{ marginLeft: 10 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">Date<sup className="text-danger"> *</sup></label>
            <input type="date" className="form-control ng-binding ng-untouched ng-valid" name="bookingDate" />
          </div>
          {/* Time Slot */}
          {/* <div id="timeslotbutton" className="textf col-sm-2" style={{ marginLeft: 10 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">Time Slot<sup className="text-danger"> *</sup></label>
            <input type="date" className="form-control ng-binding ng-untouched ng-valid" name="timeSlot" value={formData.timeSlot} onChange={handleInputChange} />
          </div> */}
                      {/* Select Time Slot */}
                      <div className="row">
                        <select class="form-select" aria-label="Default select example" id="timeSlot" name="timeSlot"  style={{width:200, height:35,marginLeft:300,marginTop:-35}}>
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
              <input type="number" className="form-control ng-binding ng-untouched ng-valid" name="persons" />
            </div>
            {/* Amount */}
            <div id="amountbutton" className="textf col-sm-2" style={{ marginLeft: 10 }}>
              <label className="textf ng-binding" htmlFor="inputLarge">Amount<sup className="text-danger"> *</sup></label>
              <input type="number" className="form-control ng-binding ng-untouched ng-valid" name="amount"  />
            </div>
          </div>
        </div>
      </div>

      <div id="primarydetails">
        <h4 style={{ color: "red", marginLeft: 10, marginTop: 10 }}>Payment Details</h4>
        <hr />

        <div id="primarydetailsentry" className="row">
          {/* Payment details */}
          {/*CardHolder Name */}
          <div id="fullNamebutton" className="textf col-sm-2" style={{ marginLeft: 7 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">CardHolder Name<sup className="text-danger"> *</sup></label>
            <input type="text" className="form-control ng-binding ng-untouched ng-valid" name="fullName"/>
          </div>

          {/* Card number */}
          <div id="cardNumberButton" className="textf col-sm-1" style={{ marginLeft: 2 }}>
          <label className="textf ng-binding" htmlFor="cardNumber">Card Number<sup className="text-danger"> *</sup></label>
          <input type="text" className="form-control ng-binding ng-untouched ng-valid" name="cardNumber" placeholder="XXXX XXXX XXXX XXXX" pattern="\d{4} \d{4} \d{4} \d{4}" maxlength="19" style={{ width: '100px' }} required/>
          </div>
          {/* CVV*/}
          <div id="cvvButton" className="textf col-sm-1" style={{ marginLeft: 2 }}>
          <label className="textf ng-binding" htmlFor="cvv">CVV<sup className="text-danger"> *</sup></label>
          <input type="number" className="form-control ng-binding ng-untouched ng-valid" name="cvv" placeholder="Enter CVV" minLength="3" maxLength="3" required onInput={(e) => e.target.value = e.target.value.slice(0, 3)} /> 
          </div>
          {/* ExpDATe */}
          <div id="expiryDateButton" className="textf col-sm-1" style={{ marginLeft: 0 }}>
          <label className="textf ng-binding" htmlFor="expiryDate">Expiry Date<sup className="text-danger"> *</sup></label>
          <input type="text" className="form-control ng-binding ng-untouched ng-valid" name="expiryDate" placeholder="MM/YY" maxlength="5" pattern="^(0[1-9]|1[0-2])\/?([0-9]{2})$"  required />
          </div>
          
          {/* Card Type */}
          <div id="cardTypeButton" className="textf col-sm-3" style={{ marginLeft: 2 }}>
            <label className="dropdf ng-binding" htmlFor="cardType">Select Card Type<sup className="text-danger"> *</sup></label><br />
             <div className="textf col-sm-3">
             <select name="cardType" className="form-control ng-binding ng-untouched ng-valid" required>
             <option value="MasterCard">MasterCard</option>
             <option value="Visa">Visa</option>
            <option value="AmericanExpress">Rupay</option>
            </select>
            </div>
          </div>
          {/* Login button */}
        
            {/* <div id="loginButton" style={{ marginLeft: 10, marginTop: 15 }}>
              <button type="button" className="btn btn-danger" onClick={()=>{handleSubmit()}}>Submit</button>
            </div> */}
          
        </div>
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

export default NormalDarshan;
