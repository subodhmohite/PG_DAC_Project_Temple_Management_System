import React, { useState, useEffect } from "react";
import Common from "./Common";
import FooterNav from "./FooterNav";
import axios from "axios";
import { toast } from "react-toastify";

const NormalPooja = () => {

//   const jwt = sessionStorage.getItem("jwtToken");

//   useEffect(() => {
//     document.title = "Pooja";
//   }, []);

//   const [pooja, setPooja] = useState("");
//   const [date, setDate] = useState("");
//   const [noOfPerson, setNoOfPerson] = useState(1);
//   const [amount, setAmount] = useState(0);

//   const handleNoOfPersonsChange = (event) => {
//     setNoOfPerson(Number(event.target.value));
//     const newAmount = event.target.value === "1" ? 200 : 400; // Example calculation
//     setAmount(newAmount);
//   };

//   const handleSubmit = () => {
//     const dataToSend = {
//       pooja: pooja,
//       date: date,
//       noOfPerson: noOfPerson,
//       amount: amount
//     };
  
//     axios.post("http://localhost:8443/user/pooja/add", dataToSend, {
//         headers: {
//           "Authorization": "Bearer " + jwt
//         },
//       })
//       .then((response) => {
//         console.log("Response:", response.data);
//         toast.success("Pooja Booked Successfully");
//       })
//       .catch((error) => {
//         console.error("Error:", error);
//         toast.error("SomeThing Went Wrong In Pooja")
//       });
//   };
  

  return (
    <div style={{ margin: "auto" }}>
      <div>
        <Common />
      </div>

      <div id="pooja" className>
        <h4 style={{ color: "red", marginLeft: 10, marginTop: 10 }}>Pooja</h4>
        <hr />

        <div id="poojadetailsentry" className="row">
          <div style={{ display: "flex", alignItems: "center", marginLeft: 10, fontSize: 18 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">
              Pooja
              <sup className="text-danger"> *</sup>
            </label>

            <div className="col-md-2 mb-2" style={{ marginLeft: 200, marginTop: -10 }}>
              <label htmlFor="pooja" className="form-label">
                <select className="form-select" id="pooja" name="pooja" >
                  <option value="">Select Pooja</option>
                  <option value="ABHISHEK_POOJA_5_AM">ABHISHEK POOJA</option>
                  <option value="SAI_SATYAVRAT_POOJA_12_PM">SAI SATYAVRAT POOJA</option>
                </select>
              </label>
            </div>
          </div>

          <div style={{ display: "flex", alignItems: "center", marginLeft: 10, fontSize: 18 }}>
            <label className="textf ng-binding" htmlFor="inputLarge" >
              Date
              <sup className="text-danger"> *</sup>
            </label>

            <div className="col-md-2 mb-2" style={{ marginLeft: 205, marginTop: -10 }}>
              <label htmlFor="date" className="form-label">
                <input type="date" className="form-control ng-binding ng-untouched ng-valid" />
              </label>
            </div>
          </div>

          <div style={{ display: "flex", alignItems: "center", marginLeft: 10, fontSize: 18 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">
              No Of Person
              <sup className="text-danger"> *</sup>
            </label>

            <div className="col-md-2 mb-2" style={{ marginLeft: 130, marginTop: 10 }}>
              <input type="radio" id="single" name="noOfPerson" className="form-check-input" value="1" style={{ marginLeft: 10 }} />
              <label htmlFor="single" className="form-check-label" style={{ marginLeft: 10 }}>Single</label>

              <input type="radio" id="couple" name="noOfPerson" className="form-check-input" value="2" style={{ marginLeft: 10 }}  />
              <label htmlFor="couple" className="form-check-label" style={{ marginLeft: 10 }}>Couple</label>
            </div>
          </div>

          <div style={{ display: "flex", alignItems: "center", marginLeft: 10, fontSize: 18 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">
              Total Amount(₹)
              <sup className="text-danger"> *</sup>
            </label>

            <div className="col-md-2 mb-2" style={{ marginLeft: 115, marginTop: -10 }}>
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
        <b>Note:-</b> <br />- Fields marked
        <sup className="text-danger"> *</sup>
        are Mandatory <br />
        - Person on whose name service is booked should be present with his/her Photo Id and Acknowledgment in Shirdi while availing the <br />
        - Devotee can book one Pooja of each type in a single transaction. <br />
        <b>
          {" "}
          - Quota for the 'Unavailable dates' may be available in future, in case of any cancellations from other devotees.
        </b>
        <br />
        <b>
          {" "}
          - Only single person or married couple (husband and wife) is allowed for each Pooja Coupon.
        </b>
      </div>

      <div>
        <FooterNav />
      </div>
    </div>
  );
};

export default NormalPooja;
