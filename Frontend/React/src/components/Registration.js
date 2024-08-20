import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import Common from './Common';

const Registration = () => {

  const url = 'http://localhost:8443/users/signup';
  
  const [formData, setFormData] = useState({
    fname: '',
    lname: '',
    email: '',
    password: '',
    cpassword: ''
  })

  const [errors, setErrors] = useState({})

  const [valid, setValid] = useState(true)

  const navigate = useNavigate()

  const handleSubmit = (e) => {
    e.preventDefault();
    // console.log(formData)

    let isValid = true;
    let validationErrors = {};
    if (formData.fname === "" || formData.fname === null) {
      isValid = false;
      validationErrors.fname = "First Name Required"
    }

    if (formData.lname === "" || formData.lname === null) {
      isValid = false;
      validationErrors.lname = "Last Name Required"
    }

    if (formData.email === "" || formData.email === null) {
      isValid = false;
      validationErrors.email = "Email Required"
    }
    else if (!/\S+@\S+\.\S+/.test(formData.email)) {
      isValid = false;
      validationErrors.email = "Email is not valid"
    }

    if (formData.password === "" || formData.password === null) {
      isValid = false;
      validationErrors.password = "Password Required"
    }
    else if (formData.password.length < 8) {
      isValid = false;
      validationErrors.email = "Password length at least 8 char"
    }

    if (formData.cpassword === "" || formData.cpassword === null) {
      isValid = false;
      validationErrors.cpassword = "Confirm Password Required"
    }
    else if (formData.cpassword !== formData.password) {
      isValid = false;
      validationErrors.cpassword = "Confirm password does not match with password"
    }

    setErrors(validationErrors);
    setValid(isValid);

 

    if (Object.keys(validationErrors).length === 0) {
      axios.post(url, formData)
        .then(result => {
          // console.log(result)
          alert("Registered Successfully");
          navigate('/login')
        })
        .catch(err => console.log(err));
    }

  };
  return (
    <div class="container" >
            <div>
              <Common/>
            </div>
      <div class="row">
        <div class="col-md-6 offset-md-3">
          <div class="signup-form">
            <form class="mt-5 border p-4 bg-light shadow" onSubmit={handleSubmit} >
              <h4 class="mb-5 text-secondary">Create Your Account</h4>
              <div class="row">
                <div class="mb-3 col-md-6">

                  <label>First Name<span class="text-danger">*</span></label>
                  <input type="text" name="fname" class="form-control" placeholder="Enter First Name" onChange={(event) => setFormData({ ...formData, fname: event.target.value })} />
                  {
                    valid ? <></> :
                      <span className="text-danger">
                        {errors.fname}
                      </span>
                  }
                </div>

                <div class="mb-3 col-md-6">

                  <label>Last Name<span class="text-danger">*</span></label>
                  <input type="text" name="Lname" class="form-control" placeholder="Enter Last Name" onChange={(event) => setFormData({ ...formData, lname: event.target.value })} />
                  {
                    valid ? <></> :
                      <span className="text-danger">
                        {errors.lname}
                      </span>
                  }
                </div>

                <div class="mb-3 col-md-12">

                  <label>Email<span class="text-danger">*</span></label>
                  <input type="email" name="email" class="form-control" placeholder="Enter Email" onChange={(event) => setFormData({ ...formData, email: event.target.value })} />
                  {
                    valid ? <></> :
                      <span className="text-danger">
                        {errors.email}
                      </span>
                  }
                </div>

                <div class="mb-3 col-md-12">

                  <label>Password<span class="text-danger">*</span></label>
                  <input type="password" name="password" class="form-control" placeholder="Enter Password" onChange={(event) => setFormData({ ...formData, password: event.target.value })} />
                  {
                    valid ? <></> :
                      <span className="text-danger">
                        {errors.password}
                      </span>
                  }
                </div>
                <div class="mb-3 col-md-12">

                  <label>Confirm Password<span class="text-danger">*</span></label>
                  <input type="password" name="confirmpassword" class="form-control" placeholder="Confirm Password" onChange={(event) => setFormData({ ...formData, cpassword: event.target.value })} />
                  {
                    valid ? <></> :
                      <span className="text-danger">
                        {errors.cpassword}
                      </span>
                  }

                </div>
                <div class="col-md-12">
                  <button type="submit" class="btn btn-primary float-end ">Signup Now</button>
                  {/* <button class="btn btn-primary float-end" style={{ backgroundColor: 'orange', borderColor: 'orange' }}>Signup Now</button> */}


                </div>
              </div>
            </form>
            <p class="text-center mt-3 text-secondary">If you have account, Please <Link to="/login">Login Now</Link></p>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Registration
