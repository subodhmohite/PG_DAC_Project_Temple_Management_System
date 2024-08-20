import React from "react";
import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useState,useEffect } from "react";

const AllAccomodation = () => {

  const jwt = sessionStorage.getItem("jwtToken")
  const getAllAccomodation=()=>{
    axios.get("http://localhost:8443/admin/all-accommodation",{
      headers:{
        "Authorization":"Bearer "+jwt
      }
    }).then(
        (response) => {
          console.log("Successfull");
          toast.success("All Accommodation");
          setAccomodation(response.data);
        },
        (error) => {
          //For Failure
          console.log("Error!!!!!");
          toast.error("Something Went Wrong In Accomodation");
        }
      );
  }

  useEffect(()=>{
    getAllAccomodation();
  },[]) //For Success

  const [accomodation, setAccomodation] = useState([]);

  return (
    <div>
      <div style={{ color: "red", fontStyle: "italic" }}>
        <h4>All Accomodation</h4>
      </div>
      <hr />
      <div className="text-center" style={{ margin: "auto" }}>
        <table className="table table-striped table-hover">
          <thead>
            <tr>
              <th scope="col">No Of Days</th>
              <th scope="col">Check In Date</th>
              <th scope="col">Check In Time</th>
              <th scope="col">No of Rooms</th>
              <th scope="col">Primary Devotee Name</th>
              <th scope="col">AadhaarNo</th>
              {/* <th>Action</th> */}
            </tr>
          </thead>

          <tbody>
            {accomodation.map((ac) => (
              <tr key={ac.id}>
                <td>{ac.numberOfDays}</td>
                <td>{ac.checkInDate}</td>
                <td>{ac.checkInTime}</td>
                <td>{ac.numberOfRooms}</td>
                <td>{ac.primaryDevoteeName}</td>
                <td>{ac.adharNo}</td>
                <td>
                {/* <button
                    type="button"
                    className={"btn btn-danger"}
                    style={{ backgroundColor: "" }}
                  >
                    DELETE
                  </button> */}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default AllAccomodation;
