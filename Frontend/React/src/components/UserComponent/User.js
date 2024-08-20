import Content from "./Content";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import NavBar from "../NavBar";

const User = () => {
  const navigate = useNavigate();

  const handleLogout = () => {

    sessionStorage.removeItem("jwtToken");
    toast.success("Come Back Agin!!!", {
      position: "top-center",
      autoClose: 3000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
    });

    // Navigate to another page after a delay
    setTimeout(() => {
      navigate("/home"); // Navigate to the "/next-page" route
    }, 3500); // Wait for 2 seconds before navigating
  };

  return (
    <div id="user">
      <div>
        <div>
          <div
            id="div1"
            style={{ backgroundColor: "#fff0e3" ,
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            height: "100px",}}
            className="text-center">
            <img
              src="https://www.mahalaxmikolhapur.com/img/logo2_retina3.png"
              alt=""
              style={{ width: "500px", height: "auto" }} // Adjust width to control size
            />
          </div>
        </div>

        <div id="div2" className="text-center">
          <h2 style={{ color: "maroon" }}>
            SHREE MAHALAXMI MANDIR,KOLHAPUR
          </h2>

          <button
            className={"btn"}
            style={{ backgroundColor: "red", marginLeft: 1400 }}
            onClick={handleLogout}
          >
            Log Out
          </button>
        </div>

        <div>
        <NavBar/>
        </div>

        <div>
          <div className="row">
            <Content />
          </div>
        </div>
        <ToastContainer style={{ width: 800, height: 1000 }} />
      </div>
    </div>
  );
};

export default User;
