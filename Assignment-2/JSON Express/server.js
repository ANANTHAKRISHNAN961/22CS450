const express = require('express');
const cors = require('cors'); // Import the cors package
const jsonData = require('./data.json'); // Import the JSON data

const app = express();

// Use cors middleware to enable CORS
app.use(cors());

// Endpoint to serve JSON data
app.get('/data', (req, res) => {
  res.json(jsonData);
});

// Start the server
const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
