import express from "express";
import { Event } from "../models/eventModel.js";

const router=express.Router();

router.post(`/`,async(req,res)=>{
    try{
        if (!req.body.event ||
            !req.body.name ||
            !req.body.place ||
            !req.body.attendees
        ) {
            return res.status(400).send({
                message: `send all required fields:event,name,place,attendees`,
            })
        };
        const newEvent ={
            event:  req.body.event,
            name: req.body.name,
            place: req.body.place,
            attendees: req.body.attendees,
        };
        const event=await Event.create(newEvent);
        return res.status(201).send(event);
    } catch(error) {
        console.log(error.message);
        res.status(500).send({message:error.message});
    }
});
router.get(`/`,async(req,res)=>{
        try{
            const events= await Event.find({});
            return res.status(200).json({
                count: events.length,
                data: events,
            });
        } catch(error) {
            console.log(error.message);
            res.status(500).send({message:error.message});
        }
});
router.get(`/:id`,async(req,res)=>{
        try{
            const {id} =req.params;
            const event= await Event.findById(id);
            return res.status(200).json(event)
            } catch(error) {
            console.log(error.message);
            res.status(500).send({message:error.message});
        }
});
router.put(`/:id`,async(req,res)=>{
        try{
            if (!req.body.event ||
                !req.body.name ||
                !req.body.place ||
                !req.body.attendees
            ){
                return res.status(400).send({
                    message: `send all required fields:event,name,place,attendees`,
                })
            };
            const {id}=req.params;
            const result= await Event.findByIdAndUpdate(id,req.body);
            if(!result){
                return res.status(400).json({message:"Event not found"})
            }   return res.status(200).json({message: "Event updated successfully"});
        } catch(error) {
            console.log(error.message);
            res.status(500).send({message:error.message});
        }
});
router.delete(`/:id`,async(req,res)=>{
            try{
                const {id} =req.params;
                const result= await Event.findByIdAndDelete(id);
                if(!result){
                    return res.status(400).json({message:`Event not found`})
                }
                return res.status(200).json({message:`Event Removed succesfully`})
                } catch(error) {
                console.log(error.message);
                res.status(500).send({message:error.message});
            }
});

export default router;