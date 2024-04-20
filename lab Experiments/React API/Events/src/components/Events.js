export default function Events(){
    const events=['Wedding','Birthday','Conference','Workshop','Party','Custom'];
    return(
        <>
            <h1>Events</h1>
            <ul>
                {events.map((eve)=><li>{eve}</li>) }
            </ul>

        </>
    );
}