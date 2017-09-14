var express = require('express');
var app = express()

app.use(express.static('webcontent'))

app.get('/', function(request, response){
    response.send('<h2>On some URL</h2>')
})

var list = ['AngularJS', 'ReactJs', 'EmberJS', 'NodeJS']
app.get('/list', function(request, response){
    response.json(list);
})

app.listen(3100);