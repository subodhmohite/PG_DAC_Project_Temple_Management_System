import React from "react";
import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useState,useEffect } from "react";

const AllUsers =()=>{
   
  
  const jwt = sessionStorage.getItem("jwtToken");

  const deleteUserById=(id)=>{
    console.log(id);
    axios.delete(` http://localhost:8443/admin/all-users/${id}`,{
      headers:{
        "Authorization":"Bearer "+jwt 
      }
    }).then((response)=>{
      console.log(response.data)
      toast.success("User Deleted")
    },error=>{
      console.log("Error");
      toast.error("Something Went Wrong");
    });
  }



  const getAllUsers=()=>{
    axios.get(" http://localhost:8443/admin/all-users",{
      headers:{
        "Authorization":"Bearer "+jwt
      }
    }).then(
        (response) => {
          console.log("Successfull");
          toast.success("All Users");
          setUsers(response.data);
        },
        (error) => {
          //For Failure
          console.log("Error!!!!!");
          toast.error("Something Went Wrong In Users");
        }
      );
  }

  useEffect(()=>{
    getAllUsers();
  },[]) //For Success

  const [users, setUsers] = useState([]);



  return(
      <div>
        <div style={{color:"red" , fontStyle:"italic"}}><h4>All Users</h4></div><hr/>
        <div className="text-center" style={{ margin: "auto" }}>
        <table className="table table-striped table-hover">
          <thead>
            <tr>
              <th scope="col">Id</th> 
              <th scope="col">First Name</th>
              <th scope="col">Last Name</th>
              <th scope="col">Email</th>
              <th scope="col">Mobile No.</th>
              <th scope="col">Role</th>
              <th scope="col">DOB</th> 
              <th scope="col">Gender</th> 
              <th scope="col">Aadhaar No</th> 
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {users.map((u) => (
              <tr key={u.id}>
                <td>{u.id}</td>
                <td>{u.firstName}</td>
                <td>{u.lastName}</td>
                <td>{u.email}</td>
                <td>{u.mobileNo}</td>
                <td>{u.role}</td>
                <td>{u.dob}</td>
                <td>{u.gender}</td>
                <td>{u.adharNumber}</td>
                <td>
                  <button

                    onClick={()=>deleteUserById(u.id)}
                    type="button"
                    className={"btn btn-danger"}
                    style={{ backgroundColor: "" }}
                  >
                    DELETE
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      </div>
  )
}

export default AllUsers;