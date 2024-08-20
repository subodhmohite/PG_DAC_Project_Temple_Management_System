import React from 'react';

const Payment = () => {
  return (
    <div id="primarydetails">
        <h4 style={{ color: "red", marginLeft: 10, marginTop: 10 }}>Payment Details</h4>
        <hr />

        <div id="primarydetailsentry" className="row">
          {/* Payment details */}
          {/*CardHolder Name */}
          <div id="fullNamebutton" className="textf col-sm-2" style={{ marginLeft: 7 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">CardHolder Name<sup className="text-danger"> *</sup></label>
            <input type="text" className="form-control ng-binding ng-untouched ng-valid" name="fullName"/>
          </div>

          {/* Card number */}
          <div id="cardNumberButton" className="textf col-sm-1" style={{ marginLeft: 2 }}>
          <label className="textf ng-binding" htmlFor="cardNumber">Card Number<sup className="text-danger"> *</sup></label>
          <input type="text" className="form-control ng-binding ng-untouched ng-valid" name="cardNumber" placeholder="XXXX XXXX XXXX XXXX" pattern="\d{4} \d{4} \d{4} \d{4}" maxlength="19" style={{ width: '100px' }} required/>
          </div>
          {/* CVV*/}
          <div id="cvvButton" className="textf col-sm-1" style={{ marginLeft: 2 }}>
          <label className="textf ng-binding" htmlFor="cvv">CVV<sup className="text-danger"> *</sup></label>
          <input type="number" className="form-control ng-binding ng-untouched ng-valid" name="cvv" placeholder="Enter CVV" minLength="3" maxLength="3" required onInput={(e) => e.target.value = e.target.value.slice(0, 3)} /> 
          </div>
          {/* ExpDATe */}
          <div id="expiryDateButton" className="textf col-sm-1" style={{ marginLeft: 0 }}>
          <label className="textf ng-binding" htmlFor="expiryDate">Expiry Date<sup className="text-danger"> *</sup></label>
          <input type="text" className="form-control ng-binding ng-untouched ng-valid" name="expiryDate" placeholder="MM/YY" maxlength="5" pattern="^(0[1-9]|1[0-2])\/?([0-9]{2})$"  required />
          </div>
          
          {/* Card Type */}
          <div id="cardTypeButton" className="textf col-sm-3" style={{ marginLeft: 2 }}>
            <label className="dropdf ng-binding" htmlFor="cardType">Select Card Type<sup className="text-danger"> *</sup></label><br />
             <div className="textf col-sm-3">
             <select name="cardType" className="form-control ng-binding ng-untouched ng-valid" required>
             <option value="MasterCard">MasterCard</option>
             <option value="Visa">Visa</option>
            <option value="AmericanExpress">Rupay</option>
            </select>
            </div>
          </div>

          </div>
          </div>


    );
};

export default Payment;