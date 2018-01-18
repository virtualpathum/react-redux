//const setTimeout = require('timers');

const express = require('express');
const mongodb = require('mongodb');
const bodyParser = require('body-parser');

const app = express();
app.use(bodyParser.json());
const dbUrl = 'mongodb://localhost/crudwithredux';

function validate(data){
 let errors = {};
 if(data.firstName === '') errors.firstName = "Cannot be empty";
 if(data.lastName === '') errors.lastName = "Cannot be empty";
 const isValid = Object.keys(errors).length === 0
 return {errors,isValid};
}

mongodb.MongoClient.connect(dbUrl,function(err,db){

    app.get('/api/employees',(req,res)=>{
        //Enable timer to simulate the delay when fetching data
       // setTimeout(()=>{
            db.collection('employees').find({}).toArray((err,employees)=>{
                res.json({employees});
            });
       // },2000);
          
    });

    app.post('/api/employees',(req,res)=>{
        console.log(req.body);
       const {errors, isValid} = validate(req.body);

       if(isValid){
           const{firstName,lastName,age} = req.body;
           db.collection("employees").insert({firstName,lastName,age},(err,result) =>{
                if(err){
                    res.status(500).json({errors:{global:"Something went wrong!"}});
                }else{
                    res.json({employee:result.ops[0]})
                }
           });

       }else{
           res.status(400).json({errors});
       }
    });

    app.get('/api/employees/:_id',(req,res)=>{
        db.collection('employees').findOne({_id:new mongodb.ObjectId(req.params._id)}, (err, employee)=>{
            res.json({employee});
        })
    });

    app.put('/api/employees/:_id',(req,res)=>{
       const {errors,isValid} = validate(req.body);

       if(isValid){
        const {firstName,lastName,age} = req.body;
           db.collection('employees').findOneAndUpdate(
               {_id: new mongodb.ObjectId(req.params._id)},
               {$set:{firstName,lastName,age}},
               {returnOriginal:false},
               (err,result)=>{
                   if(err){
                       res.status(500).json({errors:{global:err}});return;}
                       res.json({employee:result.value});
                   }
           );
       }else{
           res.status(400).json({errors});
       }
    });

    app.delete('/api/employees/:_id',(req,res)=>{
        db.collection('employees').deleteOne({ _id: new mongodb.ObjectId(req.params._id)},(err,r) =>{
            if(err){res.status(500).json({errors:{global:err}});return;}
                res.json({});
            
        })
    });

    app.use((req,res)=>{
        res.status(404).json({
            errors:{
                global:"Still working on it. Please come back later"
            }
        });
    });
    app.listen(8080,()=>console.log('Server running on port 8080'));
});
