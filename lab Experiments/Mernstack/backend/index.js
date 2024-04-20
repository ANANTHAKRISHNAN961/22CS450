import express  from "express";
import { PORT,mongoDBURL } from "./config.js";
import mongoose from "mongoose";
import eventroute from "./routes/eventroute.js"
import cors from "cors";

const app=express();

app.use(express.json());

//app.use(cors());

/*app.use(
    cors({
        origin: `https://localhost:3000`,
        methods: [`GET`,`POST`,`PUT`,`DELETE`],
        allowedHeaders:[`Content-Type`]
    })
)*/


app.get('/',(req,res)=>{
    console.log(req);
    return res.status(234).send("Welcome to Mern Stack");
});

app.use(`/events`,eventroute)
      
mongoose
    .connect(mongoDBURL)
    .then(()=>{
        console.log("App connected succesfully to the database");
        app.listen(PORT,()=>{
            console.log(`App is listening to port : ${PORT}`);
        });
    })
    .catch((error)=>{
        console.log(error);
    })
