import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useEffect, useState } from "react";

const UserAllAarti = () => {

    const [aarti, setAarti] = useState([]);

    const jwt = sessionStorage.getItem("jwtToken")

    const getUserAllAarti = () => {
        axios.get("http://localhost:8443/user/aarti/", {
            headers: {
                "Authorization": "Bearer " + jwt
            }
        }).then(
            (response) => {
                console.log("Successfull");
                toast.success("All Aarti Bookings");
                setAarti(response.data);
            }).catch(
                (error) => {
                    //For Failure
                    console.log("Error!!!!!");
                    toast.error("Something went wrong  :(");
                }
            );
    }


    const deleteAartiById = (aartiId) => {
        console.log(aartiId);
        axios.delete(` http://localhost:8443/user/aarti/${aartiId}`, {
            headers: {
                "Authorization": "Bearer " + jwt
            }
        }).then((response) => {
            console.log(response.data);
            toast.success(response.data.message);

            //setAarti(aarti.filter((a) => a.id !== aartiId));
        }).catch(
            (error) => {
                console.log("Error");
                toast.error(error.message);
            }
        );
    }

    useEffect(() => {
        getUserAllAarti();
    }, []) //For Success





    return (
        <div>
            <div style={{ color: "red", fontStyle: "italic" }}>
                <h4>My All Aarti Bookings</h4>
            </div>
            <hr />

            <div className="text-center" style={{ margin: "auto" }}>
                <table className="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Date</th>
                            <th scope="col">Aarti</th>
                            <th scope="col">No Of Person</th>
                            <th scope="col">Amount</th>
                            <th scope="col">Primary Devotee Name</th>
                            <th scope="col">AadharNo</th>
                            {/* <th scope="col">Id</th> */}
                            <th> Action</th>
                        </tr>
                    </thead>

                    <tbody>
                        {aarti.map((a) => (
                            <tr key={a.id}>
                                <td>{a.aartiBookingDate}</td>
                                <td>{a.aartiBookingType}</td>
                                <td>{a.noOfPerson}</td>
                                <td>{a.amount}</td>
                                <td>{a.primaryDevoteeName}</td>
                                <td>{a.adharNo}</td>
                                {/* <td>{a.id}</td> */}
                                <td>
                                    <button

                                        onClick={() => deleteAartiById(a.id)}
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

export default UserAllAarti;
