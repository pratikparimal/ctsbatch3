
var employeeRepo = require('../repos/EmployeeRepo')
function addEmployee(employee, callback){
    employeeRepo.addEmployee(employee, function(err, data){
        if(err) callback("failure", null);
        else{
           callback(null, data)
        }
    })
}

module.exports = {addEmployee:addEmployee}