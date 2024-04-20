const http = require('http');
const fs = require('fs');
const path = require('path');

const server = http.createServer((req, res) => {
  // Set CORS headers
  res.setHeader('Access-Control-Allow-Origin', '*'); // Allow requests from any origin
  res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, PATCH'); // Allow specified HTTP methods
  res.setHeader('Access-Control-Allow-Headers', 'Content-Type'); // Allow specified headers

  // Set the content type to JSON
  res.setHeader('Content-Type', 'application/json');

  // Read the JSON file
  fs.readFile(path.join(__dirname, 'api.json'), 'utf8', (err, data) => {
    if (err) {
      // Handle errors
      res.writeHead(500);
      res.end('Error reading the file');
      return;
    }

    // Serve the JSON data
    res.writeHead(200);
    res.end(data);
  });
});

const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
