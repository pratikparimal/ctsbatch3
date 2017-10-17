var employeeService = require('../services/EmployeeService')

module.exports = function(app, logger){

    app.post('/employee', function(req, res){
        logger.debug(req.body);
        var employee = req.body;
        employeeService.addEmployee(employee, function(err, data){
            if(err) throw err;
            // res.json(data);
            res.render('success', {name: employee.name})
        })
    })

}

