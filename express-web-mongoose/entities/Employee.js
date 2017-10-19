var mongoose = require('mongoose');
var Schema = mongoose.Schema

var IncrementSchema = new Schema({
    amount: {type: Number, required: true, min: 1},
    date: {type: Date, default: Date.now}
})

var EmployeeSchema = new Schema({
    name: { type: String},
    salary: { type: Number, min: 1},
    increments: [IncrementSchema]
  });
var Employee = mongoose.model('Employee', EmployeeSchema)
module.exports =  Employee

