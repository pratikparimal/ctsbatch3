var MongoClient = require('mongodb').MongoClient


// Connection URL 
var url = 'mongodb://localhost:27017/mydb';
// Use connect method to connect to the Server 


function insertTicket(ticket, callback){
    MongoClient.connect(url, function(err, db) {
        console.log("Connected correctly to server");
         // Get the documents collection 
        var collection = db.collection('tickets');
        collection.insertOne(ticket, function(err, result){
            // console.log(result);
            console.log('Inserted into DB!!');
            db.close();
            callback(null, "success")
        })
    });

}

function fetchTickets(callback){
    MongoClient.connect(url, function(err, db) {
        console.log("Connected correctly to server");
         // Get the documents collection 
        var collection = db.collection('tickets');
        collection.find({}).toArray(function(err, docs) {
            console.log(docs)
            callback(null, docs)
        });
    });

}
module.exports = {insertTicket:insertTicket, fetchTickets:fetchTickets}