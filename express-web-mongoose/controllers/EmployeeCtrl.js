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

    app.get('/employees', function(req, res){
        employeeService.findEmployees(function(err, data){
            if(err) throw err;
            res.json(data);
            // res.j('success', {name: employee.name})
        })
    })

    app.get('/increment', function(req, res){
        console.log(req.body)
        var empId = '59e8342fe9e444044a74ae94'
        employeeService.findEmployee(empid, function(err, data){
            if(err) throw err;
            res.json(data);
            res.render('increment', {data: data})
        })
    })

}

