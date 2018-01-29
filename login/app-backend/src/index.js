import express from 'express';
import path from 'path';
import bodyParser from "body-parser";

const app = express();

//import the route
import auth from './routes/auth';
app.use(bodyParser.json());
//mount the auth route to the app
app.use('/api/auth', auth);
//app.post("/api/auth", (req,res) => {
//  res.status(400).json({errors:{global:"Invalid credentials"}});
//});

app.get('/*',(req,res) => {
    res.sendFile(path.join(__dirname, 'index.html'))
})

app.listen(8080,()=>console.log('Running on localhost:8080'))
