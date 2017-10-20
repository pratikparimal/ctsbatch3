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

    app.post('/increment', function(req, res){
        logger.debug(req.body);
        var obj = req.body;
        logger.debug(obj);


        employeeService.applyIncrement(obj, function(err, data){
            if(err) throw err;
            res.json({success: true});
            // res.j('success', {name: employee.name})
        })
    })

    app.get('/employees', function(req, res){
        employeeService.findEmployees(function(err, data){
            if(err) throw err;
            res.json(data);
            // res.j('success', {name: employee.name})
        })
    })

    app.get('/employee/:empid', function(req, res){
        logger.debug(req.params.empid)
        var empId = req.params.empid;
        employeeService.findEmployee(empId, function(err, data){
            if(err) throw err;
            // res.json(data);
            res.render('increment', {empid: data._id})
        })
    })

}

