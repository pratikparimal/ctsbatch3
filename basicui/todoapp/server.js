var express = require('express');
var app = express();

var bodyParser = require('body-parser');

// parse application/json
app.use(bodyParser.json())

app.use(express.static('public'))

var todos = [{text:'Item1'}, {text:'Item2'}];

app.get('/todos', function(req, res){
    res.json(todos);
})
app.post('/todos', function(req, res){
    var newtodos = req.body
    // todos.push(todo);
    console.log(newtodos)
    todos = newtodos
    res.json({"success": true})
    // res.json(todos);
})

app.listen(3000, function(){
    console.log('Listening on port 3000')
})

