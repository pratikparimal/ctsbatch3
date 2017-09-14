var http = require('http')
var fs = require('fs')

var server = http.createServer(function(req,res){
    console.log(req.url)
    
    if(req.url.endsWith('.html')){
        fs.readFile('public'+req.url, function(err,data){
            res.setHeader('Content-Type', 'text/html')
            res.end(''+data);
        })
    }
    
});

server.listen(3000, function(){
    console.log('Listening on port 3000')
})