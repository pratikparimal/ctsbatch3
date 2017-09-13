var fs = require('fs')
// import java.io.*

console.log('starting to read...')

// Synch version of file read
// var contents = fs.readFileSync('files/node.txt')
// console.log(''+ contents);

// Asynch version of file read
fs.readFile('files/node.txt', function(err, data){
    console.log(''+ data);
})

console.log('finished reading file...')