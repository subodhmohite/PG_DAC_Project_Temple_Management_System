import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useEffect, useState} from "react";

const UserAllDarshan = () => {
  
    const [darshan, setDarshan] = useState([]);
  
  const jwt = sessionStorage.getItem("jwtToken")  

  const getUserAllDarshan=()=>{
    axios.get("http://localhost:8443/user/darshan/",{
      headers:{
        "Authorization":"Bearer "+jwt
      }
    }).then(
        (response) => {
          console.log("Successfull");
          toast.success("All Aarti Bookings");
          setDarshan(response.data);
        }).catch(
        (error) => {
          //For Failure
          console.log("Error!!!!!");
          toast.error("Something went wrong  :(");
        }
    );
    } 


    const deleteDarshanById=(darshanId)=>{
        console.log(darshanId);
        axios.delete(` http://localhost:8443/user/darshan/${darshanId}`,{
          headers:{
            "Authorization":"Bearer "+jwt 
          }
        }).then((response)=>{
          console.log(response.data);
          toast.success(response.data.message);
          
          setDarshan(darshan.filter((a) => a.id !== darshanId));
        }).catch(
            (error)=>{
          console.log("Error");
          toast.error(error.message);
        }
        );
      }

  useEffect(()=>{   
    getUserAllDarshan();
},[]) //For Success
         


  

  return (
    <div>
      <div style={{ color: "red", fontStyle: "italic" }}>
        <h4>My All Darshan Bookings</h4>
      </div>
      <hr />

      <div className="text-center" style={{ margin: "auto" }}>
        <table className="table table-striped table-hover">
          <thead>
            <tr>
              <th scope="col">Date</th>
              <th scope="col">Time Slot</th>
              <th scope="col">No Of Person</th>
              <th scope="col">Amount</th>
              <th scope="col">Primary Devotee Name</th>
              <th scope="col">AadharNo</th>
              {/* <th scope="col">Id</th> */}
               <th> Action</th>
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
                {/* <td>{a.id}</td> */}
                <td>
                <button

                    onClick={()=>deleteDarshanById(d.id)}
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

export default UserAllDarshan;
