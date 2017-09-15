var express = require('express');
var app = express();

var bodyParser = require('body-parser');
app.use(express.static('public'))

var todos = [];

app.get('/todos', function(req, res){
    res.json(todos);
})
app.post('/todos', function(req, res){
    var todo = req.body
    todos.push(todo);
    res.json(todos);
})

app.listen(3000, function(){
    console.log('Listening on port 3000')
})

