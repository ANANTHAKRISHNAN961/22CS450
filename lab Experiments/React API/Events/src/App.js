import { BrowserRouter, Routes, Route } from "react-router-dom";
import Signup from './pages/Signup';
import Signin from './pages/Signin.js';
import Home from "./pages/Home";
import Nopage from "./pages/Nopage";
import { Event } from "./pages/Event.js";
export function App(){
    return(
        <>
            <BrowserRouter>
            <Routes>
                <Route index element={<Home />} />
                <Route path="/home" element={<Home />} />
                <Route path="/signin" element={<Signin />}/>
                <Route path="/signup" element={<Signup />}/>
                <Route path="/Events" element={<Event/>}/>
                <Route path="*" element={<Nopage />}/>
            </Routes> 
            </BrowserRouter>
        </>
    )}