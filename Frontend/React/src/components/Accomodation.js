import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Common from './Common';
import Payment from "./Payment";
import FooterNav from './FooterNav';
import { toast } from 'react-toastify';

const Accommodation = () => {
  const jwt = sessionStorage.getItem('jwtToken');

  useEffect(() => {
    document.title = 'Accommodation';
  }, []);

  const [numberOfRooms, setNumberOfRooms] = useState(1);
  const [numberOfDays, setNumberOfDays] = useState(1);
  const [amount, setAmount] = useState(500); // Assuming charge for each room is 500

  const handleNumberOfRoomsChange = (e) => {
    const rooms = parseInt(e.target.value);
    setNumberOfRooms(rooms);
    calculateAmount(rooms, numberOfDays);
  };

  const handleNumberOfDaysChange = (e) => {
    const days = parseInt(e.target.value);
    setNumberOfDays(days);
    calculateAmount(numberOfRooms, days);
  };

  const calculateAmount = (rooms, days) => {
    const totalAmount = rooms * 500 * days; // Assuming charge for each room is 500
    setAmount(totalAmount);
  };

  const handleSubmit = () => {
    const checkInDate = document.getElementById('checkInDate').value;
    const checkInTime = document.getElementById('checkInTime').value;

    // Send data to the backend
    axios
      .post(
        'http://localhost:8443/user/accommodation/add',
        {
          numberOfRooms: numberOfRooms,
          numberOfDays: numberOfDays,
          checkInDate: checkInDate,
          checkInTime: checkInTime,
        },
        {
          headers: {
            Authorization: 'Bearer ' + jwt,
          },
        }
      )
      .then((response) => {
        console.log('Response:', response.data);
        // Handle response
        toast.success(" Accommodation Successfully Done");
      })
      .catch((error) => {
        console.error('Error:', error);
        toast.error("Error Occurred In Accommodation");
      });
  };

  return (
    <div style={{ margin: 'auto' }}>
      <div>
        <Common />
      </div>

      <div id="accommodation">
        <h4 style={{ color: 'red', marginLeft: 10, marginTop: 10 }}>Book Accommodation</h4>
        <hr />

        <div id="accommodationDetailsEntry" className="row">
          <div className="textf col-sm-2" style={{ marginLeft: 10 }}>
            <label htmlFor="checkInDate" className="textf ng-binding">
              Check-in-Date<sup className="text-danger"> *</sup>
            </label>
            <input
              type="date"
              id="checkInDate"
              className="form-control ng-binding ng-untouched ng-valid"
              name="date"
            />
          </div>

          <div className="textf col-sm-2" style={{ marginLeft: 10 }}>
            <label htmlFor="checkInTime" className="textf ng-binding">
              Check-in-Time<sup className="text-danger"> *</sup>
            </label>
            <input
              type="time"
              id="checkInTime"
              className="form-control ng-binding ng-untouched ng-valid"
              name="time"
            />
          </div>

          <div className="textf col-sm-2" style={{ marginTop: 5, marginLeft: 10 }}>
            <label htmlFor="noOfRooms" className="textf ng-binding">
              No of Rooms<sup className="text-danger"> *</sup>
            </label>
            <select
              className="form-select"
              id="noOfRooms"
              name="noOfRooms"
              value={numberOfRooms}
              onChange={handleNumberOfRoomsChange}
            >
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
            </select>
          </div>

          <div className="textf col-sm-2" style={{ marginLeft: 10 }}>
            <label htmlFor="noOfDays" className="textf ng-binding">
              No of Days<sup className="text-danger"> *</sup>
            </label>
            <select
              className="form-select"
              id="noOfDays"
              name="noOfDays"
              value={numberOfDays}
              onChange={handleNumberOfDaysChange}
            >
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
            </select>
          </div>

          <div className="textf col-sm-2" style={{ marginLeft: 10 }}>
            <label htmlFor="amount" className="textf ng-binding">
              Amount<sup className="text-danger"> *</sup>
            </label>
            <input
              type="number"
              className="form-control ng-binding ng-untouched ng-valid"
              id="amount"
              name="amount"
              value={amount}
              disabled
            />
          </div>

          <div>
            <Payment/>
          </div>
          

          <div id="submitButton" style={{ marginLeft: 10, marginTop: 20 }}>
            <button type="button" className="btn btn-primary" onClick={()=>{handleSubmit()}}>
              Book
            </button>
          </div>
        </div>
      </div>

      

      <div id="footerNote" style={{ marginLeft: 5 }}>{/* Note section */}</div>

      <div>
        <FooterNav />
      </div>
    </div>
  );
};

export default Accommodation;
