// -- Callbacks

function abc(callback){
	console.log('abc')
    setTimeout(function(){
      console.log('Doing something asynchronously') 
      console.log('after some time')
      callback("SUCCESS")
    }
   , 5000)
}
abc(function(result){console.log(result)})

//  -- Promises
function abc(){
	console.log('abc')
	return new Promise(function(resolve, reject){
		setTimeout(function(){
          console.log('Doing something asynchronously') 
          console.log('after some time')
          resolve("SUCCESS")
        }
   		, 5000)	
    })
}
abc().then(function(result) { console.log(result)} );





// Scopes

var abc = function(){
    console.log('abc ---')
    var x = 2 
    var xyz = function(){
      console.log('xyz ---')
      console.log(x+2)   
    }
    return xyz;
  }