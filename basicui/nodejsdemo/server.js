var express = require('express')
var app = express()
var bodyParser = require('body-parser')
var cors = require('cors')
var repo = require('./connect')
 
app.use(cors());
// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))

// parse application/json
app.use(bodyParser.json())

app.get('/', function (req, res) {
  res.send('Hello World')
})


app.get('/tickets', function (req, res) {
    // res.send('Tickets Data')
    repo.fetchTickets(function(err, tickets){
        res.json(tickets)
    })
    
})

app.post('/tickets', function(req, res){
    console.log(req.body)
    var ticket = req.body;
    //Add to db

    repo.insertTicket(ticket, function(err, result){
        console.log(result);
        // tickets.push(ticket)
        repo.fetchTickets(function(err, tickets){
            res.json(tickets)
        })

    })

    
})
 
app.listen(3000)