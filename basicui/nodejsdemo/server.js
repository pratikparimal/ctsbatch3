var express = require('express')
var app = express()
var bodyParser = require('body-parser')
var cors = require('cors')
 
app.use(cors());
// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))

// parse application/json
app.use(bodyParser.json())

app.get('/', function (req, res) {
  res.send('Hello World')
})

var tickets = [
    {"summary": "Internet not working!!", "severity": 3, "description": "Interet not working boz of bla bla bla!!"},
    {"summary": "Monitor not working!!", "severity": 2, "description": "Interet not working boz of bla bla bla!!"},
    {"summary": "Phone faulty!!", "severity": 2, "description": "Interet not working boz of bla bla bla!!"},
    {"summary": "System not starting!", "severity": 5, "description": "Interet not working boz of bla bla bla!!"}
]

app.get('/tickets', function (req, res) {
    // res.send('Tickets Data')
    res.json(tickets)
})

app.post('/tickets', function(req, res){
    console.log(req.body)
    var ticket = req.body;
    tickets.push(ticket)
    res.json(tickets)
})
 
app.listen(3000)