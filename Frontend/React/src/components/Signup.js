import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import FooterNav from "./FooterNav";
import Common from "./Common";

const SignUp = () => {
  const navigate = useNavigate();

  //const restaurant = JSON.parse(sessionStorage.getItem("active-restaurant"));

  const [user, setUser] = useState({
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    confirmPassword:"",
    mobileNo: "",
    adharNumber: "",
    dob: "",
    gender: "",
  });

  const handleUserInput = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const saveUser = (e) => {
    console.log(user);
    fetch("http://localhost:8443/users/signup", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    })
      .then((result) => {
        console.log("result", result);
        result.json().then((res) => {
          console.log(res.mesg);
         
          if (res.id != null) {
            console.log("we got the registration here ");

            toast.success("User Registered Successfully!", {
              position: "top-right",
              autoClose: 1500,
              hideProgressBar: false,
              closeOnClick: true,
              pauseOnHover: true,
              draggable: true,
              progress: undefined,
            });
            setTimeout(() => {
              window.location.href = "/home";
            }, 1000);
          } else {
            toast.error("Something Went Wrong!", {
              position: "top-right",
              autoClose: 1000,
              hideProgressBar: false,
              closeOnClick: true,
              pauseOnHover: true,
              draggable: true,
              progress: undefined,
            });
          }
        });
      })
      .catch((error) => {
        console.error(error);
        toast.error("Sry! server is down...", {
          position: "top-right",
          autoClose: 3000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
        });
      });
    e.preventDefault();
  };

  return (
    <div>
      <div>
        <Common />
      </div>
      <div className="mt-2 d-flex aligns-items-center justify-content-center ms-2 me-2 mb-2">
        <div
          className="form-card border-color text-color"
          style={{ width: "50rem" }}
        >
          <div className="container-fluid">
            <div
              className="card-header bg-color custom-bg-text mt-2 d-flex justify-content-center align-items-center"
              style={{
                borderRadius: "0em",
                height: "45px",
              }}
            >
              <h5 className="card-title">Register Here!!!</h5>
            </div>
            <div className="card-body mt-3">
              <form className="row g-3" onSubmit={saveUser}>
                <div className="col-md-6 mb-3 text-color">
                  <label htmlFor="title" className="form-label">
                    <b>First Name</b>
                  </label>
                  <input
                    placeholder="Enter FirstName"
                    type="text"
                    className="form-control"
                    id="firstName"
                    name="firstName"
                    onChange={handleUserInput}
                    value={user.firstName}
                  />
                </div>

                <div className="col-md-6 mb-3 text-color">
                  <label htmlFor="title" className="form-label">
                    <b>Last Name</b>
                  </label>
                  <input
                    placeholder="Enter LastName"
                    type="text"
                    className="form-control"
                    id="lastName"
                    name="lastName"
                    onChange={handleUserInput}
                    value={user.lastName}
                  />
                </div>

                <div className="col-md-6 mb-3 text-color">
                  <b>
                    <label className="form-label">Email Id</label>
                  </b>
                  <input
                    placeholder="Enter Email"
                    type="email"
                    className="form-control"
                    id="email"
                    name="email"
                    onChange={handleUserInput}
                    value={user.email}
                  />
                </div>
                <div className="col-md-6 mb-3">
                  <label htmlFor="quantity" className="form-label">
                    <b>Password</b>
                  </label>
                  <input
                    placeholder="Enter Password"
                    type="password"
                    className="form-control"
                    id="password"
                    name="password"
                    onChange={handleUserInput}
                    value={user.password}
                  />
                </div>

                <div className="col-md-6 mb-3">
                  <label htmlFor="quantity" className="form-label">
                    <b>Confirm Password</b>
                  </label>
                  <input
                    placeholder="Enter Password"
                    type="password"
                    className="form-control"
                    id="confirmPassword"
                    name="confirmPassword"
                    onChange={handleUserInput}
                    value={user.confirmPassword}
                  />
                </div>

                <div className="col-md-6 mb-3">
                  <label htmlFor="contact" className="form-label">
                    <b>Contact No</b>
                  </label>
                  <input
                    placeholder="Enter Contact Number"
                    type="number"
                    className="form-control"
                    id="mobileNo"
                    name="mobileNo"
                    onChange={handleUserInput}
                    value={user.mobileNo}
                  />
                </div>

                <div className="col-md-6 mb-3">
                  <label htmlFor="aadharNo" className="form-label">
                    <b>Aadhar No</b>
                  </label>
                  <input
                    placeholder="Enter AadharNumber"
                    type="text"
                    className="form-control"
                    id="adharNumber"
                    name="adharNumber"
                    onChange={handleUserInput}
                    value={user.adharNumber}
                  />
                </div>

                <div className="col-md-6 mb-3">
                  <label htmlFor="dob" className="form-label">
                    <b>D.O.B</b>
                  </label>
                  <input
                    type="date"
                    className="form-control"
                    id="dob"
                    name="dob"
                    onChange={handleUserInput}
                    value={user.dob}
                  />
                </div>

                {/* <div className="col-md-6 mb-3">
                <label htmlFor="dob" className="form-label">
                  <b>Gender</b>
                </label>
                <input
                  placeholder='Enter Valid Gender!!'
                  type="select"
                  className="form-control"
                  id="gender"
                  name="gender"
                  onChange={handleUserInput}
                  value={user.gender}
                />
                
              </div> */}

                <div className="col-md-6 mb-3">
                  <label htmlFor="gender" className="form-label">
                    <b>Gender</b>
                  </label>
                  <select
                    className="form-select"
                    id="gender"
                    name="gender"
                    onChange={handleUserInput}
                    value={user.gender}
                  >
                    <option value="">Select Gender</option>
                    <option value="MALE">Male</option>
                    <option value="FEMALE">Female</option>
                    <option value="OTHER">Other</option>
                  </select>
                </div>

                <div className="d-flex aligns-items-center justify-content-center">
                  <button
                    class="btn btn-danger"
                    type="button"
                    onClick={saveUser}
                  >
                    Register User
                  </button>
                </div>
                <ToastContainer />
              </form>
            </div>
          </div>
        </div>
      </div>
      <FooterNav />
    </div>
  );
};

export default SignUp;
