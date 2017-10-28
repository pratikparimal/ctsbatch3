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

function findEmployee(empId, callback){
    MongoClient.connect(url, function(err, db) {
        console.log("Connected correctly to server");
         // Get the documents collection
         Employee.findById(empId, function(err, docs){
            console.log(docs)
            callback(null, docs)
         })    
    });
}


function applyIncrement(obj, callback){
    MongoClient.connect(url, function(err, db) {
        console.log("Connected correctly to server");
         // Get the documents collection

        findEmployee(obj.empid, function(err, employee){
            if(err) throw err;
            employee.salary = parseInt(employee.salary) + parseInt(obj.amount);
            employee.increments.push({amount: obj.amount});
            console.log('Updated employee', employee)
            Employee.findOneAndUpdate({_id:obj.empid}, employee, function(err, data){
                if(err) throw err;
                console.log(data);
                callback(null,data);
            })
        }) 
    });
}






module.exports = {addEmployee, findEmployees, findEmployee, applyIncrement}
