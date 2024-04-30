import React, { useState, useEffect } from 'react';
import axios from 'axios';

const App = () => {
  const [events, setEvents] = useState([]);
  const [newEvent, setNewEvent] = useState({
    event: '',
    name: '',
    place: '',
    attendees: 0
  });

  useEffect(() => {
    fetchEvents();
  }, []);

  const fetchEvents = () => {
    axios.get('http://localhost:5555/events')
      .then(response => {
        setEvents(response.data.data);
      })
      .catch(error => {
        console.error('Error fetching events:', error);
      });
  };

  const handleInputChange = e => {
    const { name, value } = e.target;
    setNewEvent(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = e => {
    e.preventDefault();
    axios.post('http://localhost:5555/events', newEvent)
      .then(response => {
        fetchEvents();
        setNewEvent({
          event: '',
          name: '',
          place: '',
          attendees: 0
        });
      })
      .catch(error => {
        console.error('Error creating event:', error);
      });
  };

  return (
    <div>
      <h1>Events</h1>
      <form onSubmit={handleSubmit}>
        <input type="text" name="event" value={newEvent.event} onChange={handleInputChange} placeholder="Event" />
        <input type="text" name="name" value={newEvent.name} onChange={handleInputChange} placeholder="Name" />
        <input type="text" name="place" value={newEvent.place} onChange={handleInputChange} placeholder="Place" />
        <input type="number" name="attendees" value={newEvent.attendees} onChange={handleInputChange} placeholder="Attendees" />
        <button type="submit">Add Event</button>
      </form>
      <ul>
        {events.map(event => (
          <li key={event._id}>
            <strong>{event.event}</strong> - {event.name} ({event.place}) - {event.attendees} attendees
          </li>
        ))}
      </ul>
    </div>
  );
};

export default App;
