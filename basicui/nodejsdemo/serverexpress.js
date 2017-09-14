var express = require('express');
var app = express();

app.use(express.static('public'))

app.set('view engine', 'ejs')
app.set('views', './views')

app.get('/test', function (req, res) {
    res.render('test')
  })
app.get('/profile', function (req, res) {
    //GEt name from database
    res.render('profile', {username: 'Punee'})
  })

app.listen(3000, function(){
    console.log('listening on port 3000')
})