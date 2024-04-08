export default function Signup(){
    return(
        <div>
            <header>Elite Events</header>
    <h1>Sign Up</h1>
    <form>
        <label for="fname" >First name : </label>
        <input type="text" id="fname" name="fname" title="alphabets only" required pattern="[A-za-z]{}" /><br/><br/>
        <label for="lname">Last name : </label>
        <input type="text" id="lname" name="lname" title="alphabets only" pattern="[A-Za-z]{}" required /><br/><br/>
        <label for="dob">Date Of Birth : </label>
        <input type="date" id="dob" name="dob" required /><br /><br />
        <label for="mail">Email : </label>
        <input type="email" id="mail" name="mail" required /><br /><br />
        <label for="uname">Username : </label>
        <input type="text" id="uname" name="uname" pattern="[A-Za-z]{}[_]" /><br /><br />
        <label for="passwd">Password : </label>
        <input type="password" id="passwd" name="passwd" pattern="[A-Z]{}[0-9]{}" maxlength="8" /><br /><br />
        <label for="cpasswd">Confirm Password : </label>
        <input type="text" id="cpasswd" name="cpasswd" pattern="[A-Z]{}[0-9]{}" maxlength="8" /><br /><br />
        <label>Gender:</label>
        <input type="radio" id="male" name="gender" />
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" />
        <label for="female">Female</label><br /><br />
        <label for="address">Address : </label>
        <textarea id="address" name="address" rows="5" cols="25" required></textarea><br /><br />
        <label for="phoneno">Phone Number : </label>
        <input type="tel" id="phoneno" name="phoneno" required pattern="[0-9]{10}" /><br /><br />
        <input type="checkbox" id="update" name="update" />
        <label for="update">I am intrested in receiveing updates from <strong>Elite Events</strong></label><br /><br />
        <input type="submit" />
        <input type="reset" />
     </form>
        </div>
    )
}