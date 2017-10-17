var express = require('express')
var app = express();
var bodyParser = require('body-parser')

var employeeService = require('./services/EmployeeService')

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))

// parse application/json
app.use(bodyParser.json())


app.get('/', function (req, res) {
    res.send('Hello World!')
  })

app.post('/employee', function(req, res){
    console.log(req.body);
    var employee = req.body;
    employeeService.addEmployee(employee, function(err, data){
        if(err) throw err;
        res.json(data);
    })
})


  app.listen(3000, function(){
      console.log('listening on port: 3000')
  })