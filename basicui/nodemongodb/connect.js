var MongoClient = require('mongodb').MongoClient


// Connection URL 
var url = 'mongodb://localhost:27017/mydb';
// Use connect method to connect to the Server 
MongoClient.connect(url, function(err, db) {
    console.log("Connected correctly to server");
     // Get the documents collection 
    var collection = db.collection('users');
    collection.insertOne({name: 'Priya', role: 'Developer', addresses: [{houseNumber: 22, locality:'Pune'}, {houseNumber: 23, locality:'Chennai'}]}, function(err, result){
        // console.log(result);
        console.log('Inserted into DB!!');
        db.close();
    })
});