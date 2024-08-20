import React from "react";
import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useState,useEffect } from "react";

const AllDarshan = () => {

  const jwt = sessionStorage.getItem("jwtToken")

  const getAllDarshan=()=>{
    axios.get("http://localhost:8443/admin/all-dashan",{
      headers:{
        "Authorization":"Bearer "+jwt
      }
    }).then(
        (response) => {
          console.log("Successfull");
          toast.success("All Darshan");
          setDarshan(response.data);
        },
        (error) => {
          //For Failure
          console.log("Error!!!!!");
          toast.error("Something Went Wrong In Darshan");
        }
      );
  }

  useEffect(()=>{
    getAllDarshan();
  },[]) //For Success

  const [darshan, setDarshan] = useState([]);


  return (
    <div>
      <div style={{ color: "red", fontStyle: "italic" }}>
        <h4>All Darshan</h4>
      </div>
      <hr />

      <div className="text-center" style={{ margin: "auto" }}>
        <table className="table table-striped table-hover">
          <thead>
            <tr>
              <th scope="col">Date</th> 
              <th scope="col">Time Slot</th>
              <th scope="col">Persons</th>
              <th scope="col">Amount</th>
              <th scope="col">Primary Devotee Name</th>
              <th scope="col">Aadhaar No.</th>
              {/* <th>Action</th> */}
            </tr>
          </thead>

          <tbody>
            {darshan.map((d) => (
              <tr key={d.id}>
                <td>{d.bookingDate}</td>
                <td>{d.timeSlot}</td>
                <td>{d.persons}</td>
                <td>{d.amount}</td>
                <td>{d.primaryDevoteeName}</td>
                <td>{d.adharNo}</td>
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

export default AllDarshan;
