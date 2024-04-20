import React, {useState} from 'react';
import Events from "../components/Events";
export function Event(){
    const [showEvents, setShowEvents] = useState(false);
    return(
        <>
            <form>
                <input type="button" value="Show Events" onClick={() =>setShowEvents(true)}/>
            </form>
            {showEvents && <Events />}
        </>
    )
}