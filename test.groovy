names = ["Ted", "Fred", "Jed", "Ned"] 
println names
shortNames = names.findAll{ it.size() <= 3 } 
println shortNames.size()
shortNames.each{ println it }

