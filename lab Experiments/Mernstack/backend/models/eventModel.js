import mongoose from "mongoose";

const eventSchema=mongoose.Schema(
    {
        event:  {
            type: String,
            required: true,
        },
        name:  {
            type: String,
            required: true,
        },
        place:  {
            type: String,
            required: true,
        },
        attendees:  {
            type: Number,
            required: true,
        }
    }, 
    {
        timestamps : true,
    }
);
export const Event = mongoose.model('Events', eventSchema);