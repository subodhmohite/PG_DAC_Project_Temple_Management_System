import React, { useState, useEffect } from "react";
import Common from "./Common";
import Payment from "./Payment";
import FooterNav from "./FooterNav";
import axios from "axios";
import { toast } from "react-toastify";

const Pooja = () => {

  const jwt = sessionStorage.getItem("jwtToken");

  useEffect(() => {
    document.title = "Pooja";
  }, []);

  const [pooja, setPooja] = useState("");
  const [date, setDate] = useState("");
  const [noOfPerson, setNoOfPerson] = useState(1);
  const [amount, setAmount] = useState(0);

  const handleNoOfPersonsChange = (event) => {
    setNoOfPerson(Number(event.target.value));
    const newAmount = event.target.value === "1" ? 500 : 1000; // Example calculation
    setAmount(newAmount);
  };

  const handleSubmit = () => {
    const dataToSend = {
      pooja: pooja,
      date: date,
      noOfPerson: noOfPerson,
      amount: amount
    };
  
    axios.post("http://localhost:8443/user/pooja/add", dataToSend, {
        headers: {
          "Authorization": "Bearer " + jwt
        },
      })
      .then((response) => {
        console.log("Response:", response.data);
        toast.success("Pooja Booked Successfully");
      })
      .catch((error) => {
        console.error("Error:", error);
        toast.error("SomeThing Went Wrong In Pooja")
      });
  };
  

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
                <select className="form-select" id="pooja" name="pooja" value={pooja} onChange={(e) => setPooja(e.target.value)}>
                  <option value="">Select Pooja</option>
                  <option value="MAHAPOOJA">MAHAPOOJA At 8:00AM</option>
                  <option value="ALANKARPOOJA">ALANKARPOOJA At 1:30PM</option>
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
                <input type="date" className="form-control ng-binding ng-untouched ng-valid" value={date} onChange={(e)=>setDate(e.target.value)} />
              </label>
            </div>
          </div>

          <div style={{ display: "flex", alignItems: "center", marginLeft: 10, fontSize: 18 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">
              No Of Person
              <sup className="text-danger"> *</sup>
            </label>

            <div className="col-md-2 mb-2" style={{ marginLeft: 130, marginTop: 10 }}>
              <input type="radio" id="single" name="noOfPerson" className="form-check-input" value="1" style={{ marginLeft: 10 }} onChange={handleNoOfPersonsChange} />
              <label htmlFor="single" className="form-check-label" style={{ marginLeft: 10 }}>Single</label>

              <input type="radio" id="couple" name="noOfPerson" className="form-check-input" value="2" style={{ marginLeft: 10 }} onChange={handleNoOfPersonsChange} />
              <label htmlFor="couple" className="form-check-label" style={{ marginLeft: 10 }}>Couple</label>
            </div>
          </div>

          <div style={{ display: "flex", alignItems: "center", marginLeft: 10, fontSize: 18 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">
              Total Amount(₹)
              <sup className="text-danger"> *</sup>
            </label>

            <div className="col-md-2 mb-2" style={{ marginLeft: 115, marginTop: -10 }}>
              <input type="number" className="form-control ng-binding ng-untouched ng-valid" name="amount" value={amount} onChange={(e)=>setAmount(e.target.value)}  readOnly />
            </div>
          </div>
        </div>
      </div>
      <div>
        <Payment/>
      </div>

      
          {/* Submit button */}
          <div style={{ marginLeft: 10, marginTop: 15, display: "flex" }}>
            <button type="button" className="btn btn-danger" onClick={handleSubmit}>
              Book
            </button>
          </div>
        
      

      <div id="footerNote" style={{ marginLeft: 5 }}>
        <b>Note:-</b> <br />- Fields marked
        <sup className="text-danger"> *</sup>
        are Mandatory <br />
        - Person on whose name service is booked should be present with his/her Photo Id and Acknowledgment in Kolhapur while availing the Pooja <br />
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

export default Pooja;
