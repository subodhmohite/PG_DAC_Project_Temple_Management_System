import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useEffect, useState} from "react";

const AllPooja = () => {
  

  const jwt = sessionStorage.getItem("jwtToken")  

  const getAllPooja=()=>{
    axios.get("http://localhost:8443/admin/all-pooja",{
      headers:{
        "Authorization":"Bearer "+jwt
      }
    }).then(
        (response) => {
          console.log("Successfull");
          toast.success("All Pooja");
          setPooja(response.data);
        },
        (error) => {
          //For Failure
          console.log("Error!!!!!");
          toast.error("Something Went Wrong In Pooja");
        }
      );
  }
  useEffect(()=>{
    getAllPooja();
  },[]) //For Success
         


  const [pooja, setPooja] = useState([]);

  return (
    <div className="">
      <div style={{ color: "red", fontStyle: "italic" }}>
        <h4>AllPooja</h4>
      </div>
      <hr />

      <div className="text-center" style={{ margin: "auto" }}>
        <table className="table table-striped table-hover">
          <thead>
            <tr>
              <th scope="col">Pooja</th>
              <th scope="col">Date</th>
              <th scope="col">No Of Person</th>
              <th scope="col">Amount</th>
              <th scope="col">Primary Devotee Name</th>
              <th scope="col">AadhaarNo</th>
              {/* <th scope="col">Id</th> */}
              {/* <th> Action</th> */}
            </tr>
          </thead>

          <tbody>
            {pooja.map((p) => (
              <tr key={p.id}>
                <td>{p.pooja}</td>
                <td>{p.date}</td>
                <td>{p.noOfPerson}</td>
                <td>{p.amount}</td>
                <td>{p.primaryDevoteeName}</td>
                <td>{p.adharNo}</td>
                {/*<td>{p.id}</td>*/}
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

export default AllPooja;
