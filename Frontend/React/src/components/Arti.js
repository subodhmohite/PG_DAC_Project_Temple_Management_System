import React, { useState, useEffect } from "react";
import Common from "./Common";
import ArtiRunningLine from "./ArtiRunningLine";
import FooterNav from "./FooterNav";
import Payment from "./Payment";
import axios from "axios";
import { toast } from "react-toastify";

const Arti = () => {
  const jwt = sessionStorage.getItem("jwtToken");

  const [formData, setFormData] = useState({
    aartiBookingDate: "",
    aartiBookingType: "",
    noOfPerson: "",
    amount: "1000",
    //idNo: "",
  });
  const [responseMessage, setResponseMessage] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("http://localhost:8443/user/aarti/add", formData, {
      headers: {
        "Authorization":"Bearer "+jwt
      },
    })
      .then((response) => {
        setResponseMessage("Data submitted successfully");
        console.log("Response:", response.data);
        toast.success("Arti Booked Successfully Done");
      })
      .catch((error) => {
        setResponseMessage("Error submitting data");
        console.error("Error:", error);
        toast.error("Arti, Try Again Something Went Wrong");
      });
  };

  const handleInputChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    document.title = "Arti";
  }, []);

  return (
    <div style={{ margin: "auto" }}>
      <div>
        <Common />
        <ArtiRunningLine />
      </div>

      <div id="arti">
        <h4 style={{ color: "red", marginLeft: 10, marginTop: 10 }}>Book Aarti</h4>
        <hr />

        <div id="darshandetailsentry" className="row">
          {/* Form fields */}
          <div id="datebutton" className="textf col-sm-2" style={{ marginLeft: 10 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">Date<sup className="text-danger"> *</sup></label>
            <input type="date" className="form-control ng-binding ng-untouched ng-valid" name="aartiBookingDate" value={formData.aartiBookingDate} onChange={handleInputChange} />
          </div>

          <div id="tepooja" className="textf col-sm-3" style={{ marginLeft: 2 }}>
            <label className="dropdf ng-binding" htmlFor="inputLarge"><sup className="text-danger"> *</sup></label>
            <div className="col-md-6 mb-3" style={{ marginTop: -23 }}>
              <select className="form-select" id="aartiBookingType" name="aartiBookingType" value={formData.aartiBookingType} onChange={handleInputChange}>
                <option value="">Select Type</option>
                <option value="KAKADARTI">KAKAD AARTI of 5:30AM</option>
                <option value="DHUPARTI">DHUP AARTI of 8:00PM</option>
              </select>
            </div>
          </div>

          <div id="darshandetailsentry2" className="row" style={{ marginTop: 5 }}>
            <div id="datebutton" className="textf col-sm-2" style={{ marginLeft: 10 }}>
              <label className="textf ng-binding" htmlFor="inputLarge">No of Person<sup className="text-danger"> *</sup></label>
              <input type="number" className="form-control ng-binding ng-untouched ng-valid" name="noOfPerson" value={formData.noOfPerson} onChange={handleInputChange} min={1} max={2} />
            </div>

            <div id="amountbutton" className="textf col-sm-2" style={{ marginLeft: 10 }}>
              <label className="textf ng-binding" htmlFor="inputLarge">Amount<sup className="text-danger"> *</sup></label>
              <input type="number" className="form-control ng-binding ng-untouched ng-valid" name="amount" value={formData.amount} readOnly />
            </div>
          </div>
        </div>
      </div>
      <div>
        <Payment/>
      </div>

      
          <div id="loginButton" style={{ marginLeft: 10, marginTop: 15 }}>
            <button type="button" className="btn btn-danger" onClick={handleSubmit}>
              Book
            </button>
          </div>
        

      <div id="footerNote" style={{ marginLeft: 5 }}>
        <b>Note:-</b> <br />- Fields marked
        <sup className="text-danger"> *</sup>
        are Mandatory <br />
        <b>
          {" "}
          - At the time of verification, all the devotees should produce the
          same original Photo IDs furnished at the time of Registration.{" "}
        </b>{" "}
        <br />
        <b>
          {" "}
          - Devotees will not be allowed to avail the service in case of any
          mismatch.
        </b>
        <br />
        <b>
          {" "}
          - Quota for the 'Unavailable dates' may be available in future, in
          case of any cancellations from other devotees.
        </b>
      </div>

      <div>
        <FooterNav />
      </div>
    </div>
  );
};

export default Arti;
