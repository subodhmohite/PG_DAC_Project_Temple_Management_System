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
            to="/admin/all-users"
            action
          >
            All Users
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/all-dashan"
            action
          >
            All Darshan
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/all-pooja"
            action
          >
            All Pooja
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/all-aarti"
            action
          >
            All Aarti
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/all-accommodation"
            action
          >
            All Accomodation
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
