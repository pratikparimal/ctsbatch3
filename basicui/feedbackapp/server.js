var express = require('express');
var bodyParser = require('body-parser')
var repo = require('./feedbackrepo')
var app = express();
var port = 4000

app.use(express.static('public'))

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))

// parse application/json
app.use(bodyParser.json())

app.set('view engine', 'ejs')
app.set('views', './public')

// var feedbacks = [
//     {email: 'test@gmail.com', rating: 9, description:'You guys were amzing with the service'},
//     {email: 'test1@gmail.com', rating: 10, description:'You guys were amzing with the service'}
// ]

//Server side template
app.post('/insertfeedback', function(req,res){
    console.log(req.body);
    var feedback = req.body
    // x
        repo.insertFeedback(feedback, function(err, result){
            if(result =="success"){
                res.render('success', {email: feedback.email})
            }
        })
    // }
    // else{
    //     res.render('error', {email: feedback.email})
    // }
      
})

//AJAX
app.post('/feedback', function(req, res){
    var feedback = req.body
    // feedbacks.push(feedback);
    repo.insertFeedback(feedback, function(err, result){
        if(result =="success"){
            res.json({"success":true});
        }
        else{
            res.json({"success":false});
        }
    })
    
    //consume json and insert into db
})

app.get('/feedbacks', function(req, res){
    //return all feedbacks
    // res.json(feedbacks);

    repo.fetchFeedbacks(function(err, feedbacks){
        if(feedbacks){
            res.json(feedbacks);
        }
    })
})



app.listen(port, function(){
    console.log('listening on port', port)
})