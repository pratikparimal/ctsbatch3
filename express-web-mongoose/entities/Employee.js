var mongoose = require('mongoose');
var Schema = mongoose.Schema

var EmployeeSchema = new Schema({
    name: { type: String},
    salary: { type: Number, min: 1}
  });
var Employee = mongoose.model('Employee', EmployeeSchema)
module.exports =  Employee