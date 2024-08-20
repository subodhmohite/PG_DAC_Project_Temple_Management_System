import React from 'react';

const FooterNav = () => {
  return (
   
    <div >
        <hr/>
         <nav className="footer navbar navbar-expand-lg navbar-light bg-light  justify-content-center">
      <div className="container-fluid">
        <div className="collapse navbar-collapse  justify-content-center" id="navbarNav">

          <ul className="navbar-nav"  style={{textAlign:'center'}}>

          <li className="nav-item">
              <a className="nav-link" href="/contactus"><b>ContactUs</b></a>
            </li>

            <li className="nav-item">
              <a className="nav-link" href="/copyright"><b>Copyright&Disclaimer</b></a>
            </li>

            <li className="nav-item">
              <a className="nav-link" href="/faq"><b>FAQ</b></a>
            </li>

            <li className="nav-item">
              <a className="nav-link" href="/tandc"><b>Term&Condition</b></a>
            </li>

            <li className="nav-item">
              <a className="nav-link" href="/feedback"><b>Feedback</b></a>
            </li>

            <li className="nav-item">
              <a className="nav-link" href="https://x.com/">
                <img src='https://icons.iconarchive.com/icons/limav/flat-gradient-social/256/Twitter-icon.png' width={30}/>
              </a>
            </li>


            <li className="nav-item">
              <a className="nav-link" href="https://www.youtube.com/">
                <img src='https://icons.iconarchive.com/icons/paomedia/small-n-flat/256/social-youtube-icon.png' width={30}/>
              </a>
            </li>

            <li className="nav-item">
              <a className="nav-link" href="https://www.facebook.com/">
                <img src='https://upload.wikimedia.org/wikipedia/commons/6/6c/Facebook_Logo_2023.png' width={30}/>
              </a>
            </li>

            <li className="nav-item">
              <a className="nav-link" href="https://www.instagram.com/_.subodh._3424/">
                <img src='https://logowik.com/content/uploads/images/543_instagram_circle.jpg' width={50}/>
              </a>
            </li>
            
          </ul>
        </div>
      </div>
    </nav>
    <hr/>
    <div style={{textAlign:'center',color:'white', backgroundColor:'#532c49'}}>
    <p>&copy; 2024, Devasthan Management Committee, Western Maharashtra, Kolhapur.</p>


    </div>
    </div>
  );
};

export default FooterNav;
