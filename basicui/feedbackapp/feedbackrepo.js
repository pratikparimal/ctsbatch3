var MongoClient = require('mongodb').MongoClient


// Connection URL 
var url = 'mongodb://localhost:27017/mydb';
// Use connect method to connect to the Server 


function insertFeedback(feedback, callback){
    MongoClient.connect(url, function(err, db) {
        console.log("Connected correctly to server");
         // Get the documents collection 
        var collection = db.collection('feedbacks');
        collection.insertOne(feedback, function(err, result){
            // console.log(result);
            console.log('Inserted into DB!!');
            db.close();
            callback(null, "success")
        })
    });

}

function fetchFeedbacks(callback){
    MongoClient.connect(url, function(err, db) {
        console.log("Connected correctly to server");
         // Get the documents collection 
        var collection = db.collection('feedbacks');
        collection.find({}).toArray(function(err, docs) {
            console.log(docs)
            callback(null, docs)
        });
    });

}
module.exports = {insertFeedback:insertFeedback, fetchFeedbacks:fetchFeedbacks}