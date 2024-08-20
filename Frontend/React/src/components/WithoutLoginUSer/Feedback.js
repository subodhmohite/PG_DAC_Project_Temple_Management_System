import Common from "./Common";
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

const Feedback = () =>{

    const navigate = useNavigate();

  const handleSubmit = () => {
    // Show a toast notification
    toast.success("Thank you For Your Feedback We Will Work on it And Make it Better", {
        position: "top-center",
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
      });

    // Navigate to another page after a delay
    setTimeout(() => {
      navigate('/home'); // Navigate to the "/next-page" route
    }, 6000); // Wait for 2 seconds before navigating
  };
    return(
        <div id="Feedbackmaindiv">
            <div>
                <Common/>
            </div>

            <div>
                <h3 style={{color:"red", marginLeft:10}}>Devotee Feedback</h3><hr/>
            </div>


            <div className="row">
                <div id="fullNamebutton" class="textf col-sm-3" style={{marginLeft:10}}>
                    <label class="textf ng-binding" for="inputLarge">
                        Name
                    </label>
                    <input type="text" className="form-control ng-binding ng-untouched ng-valid"
                    name="name" ng-model="pdqc.pageDeatils.userDetails.userFullName" />
                </div>

                <div id="fullNamebutton" class="textf col-sm-3" style={{marginLeft:10}}>
                    <label class="textf ng-binding" for="inputLarge">
                        Mobile No.
                    </label>
                    <input type="number" className="form-control ng-binding ng-untouched ng-valid"
                    name="mobileno" ng-model="pdqc.pageDeatils.userDetails.userFullName" />
                </div>
            </div>

            <div className="row">
                <div id="fullNamebutton" class="textf col-sm-3" style={{marginLeft:10, marginTop:10}}>
                    <label class="textf ng-binding" for="inputLarge">
                       Email
                    </label>
                    <input type="email" className="form-control ng-binding ng-untouched ng-valid"
                    name="name" ng-model="pdqc.pageDeatils.userDetails.userFullName" />
                </div>
            </div>

            <div className="col-sm-10 row" style={{marginLeft:10, marginTop:30}} >

            <h2>Rate your experience</h2>
                <div>
                    <button style={{margin:2}} className="isClicked ? 'dark-button' : 'normal-button'"> Bad😡</button>
                    <button style={{margin:2}}> Satisfactory 😐</button>
                    <button style={{margin:2}}> Good 😊</button>
                    <button style={{margin:2}}> Very Good 😄</button>
                </div>  


                <textarea style={{width:900,height:200,marginTop:20}} placeholder="Enter Your Review/Suggestion">

                </textarea>

                           
            </div>

            <div>
            <button type="button" class="btn btn-danger" style={{marginLeft:835,marginTop:8}}
            
            onClick={handleSubmit}

            >Submit</button>
            </div>
            <ToastContainer style={{width:800, height:1000}} />
        </div>
    )
}



export default Feedback;