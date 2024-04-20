import React from 'react';

class Signin extends React.Component{
    render(){
        return(
        <>
        <header>Elite Events</header>
        <h1>Sign in</h1>
        <form>
            <label for="uname">Username : </label>
            <input type="text" id="uname" name="uname"  required /><br/><br/>
            <label for="passwd">Password : </label>
            <input type="password" id="passwd" name="password" required /><br/><br/>
            <input type="button" value="Countinue" onClick={()=> alert('Signed in')}/>
        </form>
        </>
        )
    }

}
export default Signin;