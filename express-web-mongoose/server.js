var express = require('express')
var app = express();
var bodyParser = require('body-parser')

var log4js = require('log4js');
var employeeCtrl = require('./controllers/EmployeeCtrl')



  log4js.configure({
    appenders: {
      out: { type: 'stdout' },
      app: { type: 'file', filename: 'application.log' }
    },
    categories: {
      default: { appenders: [ 'out', 'app' ], level: 'debug' }
    }
  });

var logger = log4js.getLogger('file');
// logger.level = 'debug';




// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))
// parse application/json
app.use(bodyParser.json())
//static pages redirection
app.use(express.static('public'))

app.set('view engine', 'ejs')
app.set('views', './views')

employeeCtrl(app,logger);
// app.post('/employee', function(req, res){
//     console.log(req.body);
//     var employee = req.body;
//     employeeService.addEmployee(employee, function(err, data){
//         if(err) throw err;
//         // res.json(data);
//         res.render('success', {name: employee.name})
//     })
// })


  app.listen(3000, function(){
    logger.debug("listening on port: 3000");
    logger.trace('Entering cheese testing');
    logger.debug('Got cheese.');
    logger.info('Cheese is Gouda.');
    logger.warn('Cheese is quite smelly.');
    logger.error('Cheese is too ripe!');
    logger.fatal('Cheese was breeding ground for listeria.');
      console.log('listening on port: 3000')

  })