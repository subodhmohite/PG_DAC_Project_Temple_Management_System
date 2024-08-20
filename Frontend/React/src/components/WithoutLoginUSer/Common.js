import NavBar from "./NavBar"
import Header from "./Header"


const Common = () =>{
    return(
       <div>
        <div
            id="div1"
            style={{ backgroundColor: " #fff0e3" }}
            className="text-center"
          >
            <img src="https://www.mahalaxmikolhapur.com/img/logo2_retina3.png" alt="Logo" style={{ width: "400px", height: "auto" }} />
          </div>

        <div id = "div2" className="text-center">
        <h2 style={{ color: 'maroon'}}>SHREE MAHALAXMI MANDIR,KOLHAPUR</h2>
        </div>
        <div>
        <NavBar/>
        </div>
       </div>
    )
}

export default Common;