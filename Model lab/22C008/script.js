document.addEventListener('DOMContentLoaded', function() {
    const bookBtn = document.getElementById('bookBtn');
    const resetBtn = document.getElementById('resetBtn');
    const messageDiv = document.getElementById('message');

    bookBtn.addEventListener('click', function() {
        if (!auditorium.bookingInProgress) {
            const eventName = document.getElementById('eventName').value.trim();
            const eventDate = document.getElementById('eventDate').value;

            if (eventName === '' || eventDate === '') {
                showMessage('Please fill in all fields.');
            } else {
                auditorium.startBookingProcess(eventName, eventDate);
            }
        }
    });

    resetBtn.addEventListener('click', function() {
        document.getElementById('eventName').value = '';
        document.getElementById('eventDate').value = '';
        messageDiv.textContent = '';
    });

    bookBtn.addEventListener('mouseover', function() {
        messageDiv.textContent = "Click to book the entire auditorium.";
    });

    bookBtn.addEventListener('mouseout', function() {
        messageDiv.textContent = "";
    });
});

const auditorium = {
    totalSeats: 50,
    bookingStartTime: null,
    bookingEndTime: null,
    bookingInProgress: false,

    startBookingProcess: function(eventName, eventDate) {

        this.bookingStartTime = new Date();
        this.bookingEndTime = new Date(this.bookingStartTime);
        this.bookingEndTime.setHours(this.bookingEndTime.getHours() + 2); 

        this.bookingInProgress = true;
        this.showMessage(`Auditorium booked for "${eventName}" on ${eventDate} from ${this.formatTime(this.bookingStartTime)} to ${this.formatTime(this.bookingEndTime)}.`);
    },

    formatTime: function(date) {
        return date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
    },

    showMessage: function(message) {
        const messageDiv = document.getElementById('message');
        messageDiv.textContent = message;
    }
};
