import './Header.css';
function Header(){
    return(
    <div>
    <span id="title" >Elite Events</span>
    <span><a href="/signin" id="signin">Sign in</a></span>
    <span><a href="/Signup" id="signup">Sign up</a></span>
    <span><a href="/Events" id="events">Events</a></span> 
    </div>
    )
}
export default Header;