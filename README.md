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

    Day 7

        - Modules in NodeJS: relies third party library CommonJS (brings in the module system to ES5)
        - Server side template in NodeJS
        - MongoDB to persist
        - NodeJS and MongoDB integration
        - NodeJS and Angular integration

    Day 8    
       
        - MEAN: MongoDB, Express, AngularJS, NodeJS (Single Stack developement)
        - NodeJS application
        - $watch: explicit way to watch for model($scope) changes
        - localstorage: on the client itself, persist data (5MB), duration -> infinite
        - sessionstorage: close your tab, clear the data
        - $http: to communicate to the server

    Practice: 
        - Poll Application
        - Ticket Mgmnt app, add some features - Modify/Update ticket, delete ticket
        - Todo App: add server side persistence
        - SST (Jade, Pug, EJS)  
        - Pagination  

    Refs: MongoDB Commands : https://docs.mongodb.com/manual/reference/mongo-shell/

    Day 9

        - Factory vs Service vs Provider($routeProvider)
            Subtle difference b/w Factories and Services
            Factories are more for data
            Service are more for service functions
            Providers, also gives a single object, but it is configurable at module configuration level. You can change it one time.
        - Form validations
        - AnglarJS leftover (adv directive)
            Transclude: including the content inside
            Already built in directives

    Day 10
        - Practice day

    Day 11
        - MEAN stack
        - Mongoose ODM - Object to document mapping
        - Angular 2

    Day 12        
        - Java based developement (Spring & Hibernate) 
        - Simple Java programs
        - Junit test cases - Test driven development
        - JDBC programs
        - Hibernate program for DB operation
            Step
                a. Entity (Java class that can mapped to columns in a table)
                b. Entity to Table mapping - Employee.hbm.xml
                c. DB configuration - hibernate.cfg.xml
                d. Get the libraries for hiberate 4.2.21
                e. EmployeeRepo- reponsible for all DB operation for employee entity
                f. SessionFactory, Session, session methods(save/get)
                

    Day 13
        - Maven
            Dependency Management Tool
            Scaffoliding tool -> Initial structures
            Build tool - JAR, WAR, EAR    
        - Setup Maven
            Eclipse plugin
            Modify settings.xml to setup proxy details
            Delete the jars directory from repository folder Users->YourUser->.m2
            https://mvnrepository.com


    Day 14
        JPA Basics
        Entities, EntityManager, EntityManagerFactory
        CRUD method (persist, find, remove)
        Queries with Parameters

    Day 15
        JPA Mappings
            OneToOne
            OneToMany
            Lazy fetching of composed entities
            Two way bindings

        JPA leftovers
            EntityManagerFactory: this is per database
            EntityManager: represents a physical connection to db
            Transction: begin, commit, rollback
            Merge: Attaches a detached object back into managed state
            NamedQueries: Give a logical name to your query and then you can reuse the query.
            @Id: Primary Key - Combination of some fields (bankid, companyid)
                - Compound Key by using @Embeddable and using @Id for UserDefined class
            Criteria Queries: Dynamic queries
                Examples: 
                    Search App (product id, product desc, product name, product category)
                    Stocks: Monthly/Weekly table, SEP_Stocks, OCT_Stocks
            Preference  
                - CRUD (persist, find, remove, merge)
                - NamedQueries ('selectfromEmpGrSal')
                - CriteriaQueries: Very specific and meant for dynamic queries
                - NativeQueries: SQL in DB specific format
            Inheritance JPA
                Object world vs Relational DB
                    strategies:
                    one single table
                    table per class
                    joined table
            First level cache vs second level cache
        
 
    Day 16
        Spring 
            Depedency Injection
            XML, Annotations
    Day 17
        Spring-Test
            @RunsWith - directly load AC
    Day 18
        Spring-JPA
            Dependency Inject Entity Manager using @PersistenceContext
    Day 19
        Implicit requirements
            Application Logging using Log4j
        Spring-AOP
            pre & post processing
            logging method parameters as pre-processing
    Day 20
        Servlets: Server side Java programs -- HTML with Java
        JSP: Server side template : Java within HTML - Nodejs compare to Jade, EJS
        Spring-Web
            Controllers in our application
            Model
            View
    Day 21
        Spring-REST
            @RequestMapping
            @ResponseBody, @RequestBody
            @ResposeStatus(HttpStatus.CREATED/NOT_FOUND/...)
            @PathVariables (user/12) vs @RequestParams (user?name=Ravi&age=34)
            Exception Scenarios
            @JsonIgnore
            Employee -> Increment -> Employee -> Increment
        AngularJS as a consumer of JSON content from Spring-REST
    Day 22
        ALP
            Logging (log4j)
            Validation: Client side and server side validations
            Transactions
            CMT: @Transactional
            Propogation level: tweek to create new transactions, possibilities to manipulate
            Transaction rollback happens when you throw a RuntimeException or any subclass of it(Unchecked Exception)
            Transaction rollback will not happen when you throw a Exception or any subclass of it(Checked Exception)
            Internationalization -- Locale specific messages
            Maven Build - Test case automation

            Spring AOP
            
            Static Code Analysis   
    Up Next:
        Similar project, convert into MEAN stack
        Cloud
        Microservices
        Spring Boot
        Angular 4 / React 
    
        
