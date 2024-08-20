import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useEffect, useState} from "react";

const UserAllAccomodation = () => {
    const [accomodation, setAccomodation] = useState([]);
    const jwt = sessionStorage.getItem("jwtToken")

    const getUserAllAccomodation=()=>{
        axios.get("http://localhost:8443/user/accommodation/",{
          headers:{
            "Authorization":"Bearer "+jwt
          }
        }).then(
            (response) => {
              console.log("Successfull");
              toast.success("All Accommodation");
              setAccomodation(response.data);
            }).catch(
            (error) => {
              //For Failure
              console.log("Error!!!!!");
              toast.error();
            }
        );
        } 

        const deleteAccomodationById=(accommodationId)=>{
            console.log(accommodationId);
            axios.delete(` http://localhost:8443/user/accommodation/${accommodationId}`,{
              headers:{
                "Authorization":"Bearer "+jwt 
              }
            }).then((response)=>{
              console.log(response.data);
              toast.success(response.data.message);
              
              //setAccommodation(accommodation.filter((a) => a.id !== accommodationId));
            }).catch(
                (error)=>{
              console.log("Error");
              toast.error(error.message);
            }
            );
          }

          useEffect(()=>{
            getUserAllAccomodation();
        },[]) //For Success
               
        return (
            <div>
              <div style={{ color: "red", fontStyle: "italic" }}>
                <h4>My All Accommodation</h4>
              </div>
              <hr />
        
              <div className="text-center" style={{ margin: "auto" }}>
                <table className="table table-striped table-hover">
                  <thead>
                    <tr>
                      <th scope="col">No Of days</th>
                      <th scope="col">Check In Date</th>
                      <th scope="col">Check In Time</th>
                      <th scope="col">Number Of Rooms</th>
                      <th scope="col">Amount</th>
                      <th scope="col">Primary Devotee Name</th>
                      <th scope="col">AadharNo</th>
                      
                      {/* <th scope="col" hidden>Id</th> */}
                       <th> Action</th>
                    </tr>
                  </thead>
        
                  <tbody>
                    {accomodation.map((a) => (
                      <tr key={a.id}>
                        <td>{a.numberOfDays}</td>
                        <td>{a.checkInDate}</td>
                        <td>{a.checkInTime}</td>
                        <td>{a.numberOfRooms}</td>
                        <td>{a.amount}</td>
                        <td>{a.primaryDevoteeName}</td>
                        <td>{a.adharNo}</td>
                        {/* <td>{a.id}</td> */}
                        <td>
                        <button
        
                            onClick={()=>deleteAccomodationById(a.id)}
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
          );
        
    };
    export default UserAllAccomodation;