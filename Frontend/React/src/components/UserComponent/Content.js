import React from "react";
import { ListGroup } from "reactstrap";
import { Link, Outlet } from "react-router-dom";

const Content = () => {
  return (

    <div  className="row">
      <div className="col-3">
        <ListGroup>
         <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/user/my-profile"
            action
          >
            My Profile
          </Link>
      

          {/* <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/user/my-profile/update-user"
            action
          >
            UPDATE MY PROFILE
          </Link> */}

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/user/change-password"
            action
          >
            Change Password
          </Link>

          


          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/user/pooja/"
            action
          >
            All Pooja Bookings
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/user/darshan/"
            action
          >
            All Darshan Bookings
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/user/accommodation/"
            action
          >
            All Accomodation Bookings
          </Link>
          
          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/user/aarti/"
            action
          >
            All Aarti Bookings
          </Link>

        </ListGroup>
      </div>
      <div className="col-9">
        <Outlet />
      </div>
    </div>
  );
};

export default Content;
