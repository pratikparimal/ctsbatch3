var MongoClient = require('mongodb').MongoClient
var mongoose = require('mongoose');
var Schema = mongoose.Schema

// Connection URL 
var url = 'mongodb://localhost:27017/mydb';
// Use connect method to connect to the Server 

mongoose.connect(url);

var Cat = mongoose.model('Cat', { name: String });


var FeedbackSchema = new Schema({
    email: { type: String},
    rating: { type: Number, min: 1, max: 10},
    description: { type: String},
    date: { type: Date, default: Date.now }
  });
var FeedBack = mongoose.model('Feedback', FeedbackSchema)

function insertFeedback(feedback, callback){
    MongoClient.connect(url, function(err, db) {
        console.log("Connected correctly to server");
         // Get the documents collection
         console.log('In Repo',feedback);
         var feedbackObj = new FeedBack(feedback);
         feedbackObj.save(function(err){
             if(err) callback("failure", null);
             else{
                callback(null, "success")
             }
         })
         
        // var collection = db.collection('feedbacks');
        // collection.insertOne(feedback, function(err, result){
        //     // console.log(result);
        //     console.log('Inserted into DB!!');
        //     db.close();
        //     callback(null, "success")
        // })
    });

}

function fetchFeedbacks(callback){
    MongoClient.connect(url, function(err, db) {
        console.log("Connected correctly to server");
         // Get the documents collection 
         FeedBack.find({}, function(err, docs){
            console.log(docs)
            callback(null, docs)
         })    

        // var collection = db.collection('feedbacks');
        // collection.find({}).toArray(function(err, docs) {
        //     console.log(docs)
        //     callback(null, docs)
        // });
    });

}
module.exports = {insertFeedback:insertFeedback, fetchFeedbacks:fetchFeedbacks}