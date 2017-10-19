var MongoClient = require('mongodb').MongoClient
var mongoose = require('mongoose');
var Schema = mongoose.Schema
var Employee = require('../entities/Employee.js')

// Connection URL 
var url = 'mongodb://localhost:27017/mydb';
// Use connect method to connect to the Server 

mongoose.connect(url);

// var EmployeeSchema = new Schema({
//     name: { type: String},
//     salary: { type: Number, min: 1}
//   });
// var Employee = mongoose.model('Employee', EmployeeSchema)


function addEmployee(employee, callback){
    MongoClient.connect(url, function(err, db) {
        console.log("Connected correctly to server");
         // Get the documents collection
         console.log('In Repo',employee);
         var employeeObj = new Employee(employee);
         employeeObj.save(function(err){
             if(err) callback("failure", null);
             else{
                callback(null, {success:true})
             }
         })
    });
}

function findEmployees(callback){
    MongoClient.connect(url, function(err, db) {
        console.log("Connected correctly to server");
         // Get the documents collection
         Employee.find({}, function(err, docs){
            console.log(docs)
            callback(null, docs)
         })    
    });
}



module.exports = {addEmployee, findEmployees}
