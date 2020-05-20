![picture 3](./images/8b4222ba633481a1af19af7256eaff5e9b09ecd7068e8684fe765edbcb0adc1f.png)  



* **Definition**:
It's Humongous and Schemaless! 

* **Terminology**:
>DB -> Collection -> Document

![picture 5](./images/a6f55cfebdbc31a047a5cd2d3bbfc6c6b812925cc65c88cdfd7a3c07e20e911e.png)  

* **Data Format**:
JSON which DB engine eventually translates to BSON before storing.
```json
{
    "name" : "bamzy",
    "age" : 31,
    "locked" : false,
    "address" : "123 Ave",
    "roles" : {"primary" : "admin", "secondary" : "author"},
    "hobbies" : [
        {"name" : "walking"},
        {"name" : "sleeping"}
    ]
}
```

## MongoDB Co. Ecosystem

* Graphic User Interface called Compass
* Mongo Mobile: to run MongoDB on phones
* Atlas: MongoDB on cloud
* BI Connectors
* MongoDB Charts
* Stitch: Serverless query API, Serverless Functions, Database Triggers
* Real-Time Sync

## Useful MongoDB Shell Commands
MongoDB shell allows you to interact with MongoDB Server and is quiet flexible.
```javascript
show dbs                            //Show all existing databases
db                                  //Shows current database
show collections                    //Show all collections in a database
db.dropDatabase()                   // Removes current DB
use [db_name]                       // Set working DB
db.createCollection(name,options)   //name is the collection name and options is an optional field that we can use to specify certain parameters such as size, max number of documents etc. in the collection.
db.[collection_name].[command_name] //General format of mongoDB commands
```

![picture 4](./images/cb740c71eff6dab1c5645530868e7895cf6e4699e58b6d50f9b3d4b931a5bdd3.png)  

## Example
```js

db.createCollection('products')
db.products.insertOne(
    {
        name: "bamdad",
        age: 10
    }
)
// You can provide your own ID as long as its unique
db.products.insertOne(
    {
        name: "bamdad",
        age: 10,
        _id: 1
    }
)
// Insert multipel documents at once
db.products.insertMany(
    [{
        name: "Ali",
        age: 10,
        _id: 2
    },
    {
        name: "Mo",
        age: 20,
        _id: 3
    }]
)
db.products.find()              // returns all documents
db.products.findOne()           // returns one documents
db.products.find().pretty()     // returns all douments while prettified

db.products.find({price: {$gte: 100}}) //find greater than or equal
db.products.deleteOne({_id: 123456})    //Remove the first document with given ID
db.products.deleteMany({_id: 123456})    //Remove all document with given ID

//Don't forget $set when updating
db.products.updateOne({age: 10}, { $set:{{lastname: "kordi" }})

db.products.updateMany({}, { $set:{{locked: false }})
```