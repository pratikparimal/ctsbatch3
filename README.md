# ctsbatch3

    Day 1

    To get http-server working on your machines
    1. NodeJS installation
    2. npm install -g http-server

    JavaScript
        - Basics 
            Doesn't have strong data typing
            Basis content the data is derived
            Overloading can be avoided
            typeof() 
            Cross Compatible JS 
            JS is not a pure object oriented language   
        - Functional style of programming
            Treat functions as first class objects, assign functions to variables
            Pass functions as arguments
            Return functions from functions
            Scopes
            Every function will have its own scope
        - Debug

    Day 2

        - Callbacks, Promises, Ajax
            Function callbacks
            Callback expose your functionality, Callback hell
            Replace to callbacks is Promises (latest version of JS)
            Modern Ajax API's support promises (axios, fetch(native))
        - DOM Manipulation
            Document as an object (tree like structure)
            Write to DOM, page re-render
        - JQuery
            Library of reusable JavaScript functions
            Make our JS code smaller in size
            Majorly about DOM manipulation (read & write to DOM)
        - AngularJS
            Data binding feature - Not doing a great deal of DOM manipulation, framework takes of it.
            Your code is really short and crisp, dont write much JS
            Opinionated framework, takes care of most UI concerns
    Day 3
    
    Javascript vs JQuery vs AngularJS

    

    AngularJS
        - Basics
            Module: angular.module
            MVC: module.controller('')
        - Advanced Stuff
            Factory: A way to share data
            Filters: Filtering and Formatting Data
                - formatters: uppercase, lowercase, date, number, currency, orderBy
                - filter: limitTo, filter
                - custom filter: capitalize
            Ng-Repeat: way to iterate over in markup
    Day 4
            Directives: Custom tags, tags not used in HTML
                - ng-app, ng-controller, ng-repeat (Core tags from Angular library)
                - Cusom tags
                - link(scope, element,attrs)
                    - element: JQLite wrapped element
                    - scope vs $scope(Controller DI)
                    - attrs    
                - isolation with scopes
                - make use of existing third-party directives
            Ajax with Angular, Consume information from server on client side
    Day 5        
            Ticket Management System
                - View Tickets screen
                    - Display tickets as directives
                    - Add search and sort facility
                    - Use severity to color up directive.
                        5: red
                        3: yellow
                        1: light greeen
                - Add Tickets screen (Server side code, Single Page)
                - Single Page Applications
    Day 6

    NodeJS
        - Node JS is a library of JavaScript functions that run on Chrome's V8 browser
        - Core libraries ('fs', 'events')
        - Asynch mode (youtube link)
        - NPM is library repository for more libraries other than core.
        - Create a package.json (npm init)
        - Browse to directory -> nodejsdemo -> npm install -> node server.js
        - Integrate Angular into NodeJS

        - Modules in NodeJS: relies third party library CommonJS (brings in the module system to ES5)
        - Server side template in NodeJS
        
        - MongoDB to persist
        - MEAN: MongoDB, Express, AngularJS, NodeJS
        - NodeJS application    
        
