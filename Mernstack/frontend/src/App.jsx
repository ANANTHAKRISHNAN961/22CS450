import React from 'react'
import Home from './pages/Home';
import CreateEvent from './pages/CreateEvent';
import DeleteEvent from './pages/DeleteEvent';
import EditEvent from './pages/EditEvent';
import ShowEvents from './pages/ShowEvents';
import { Routes,Route } from 'react-router-dom';
export const App = () => {
  return (
    <Routes>
      <Route path='/' element={<Home/>} />
      <Route path='/events/create' element={<CreateEvent/>} />
      <Route path='/events/details/:id' element={<ShowEvents/>} />
      <Route path='/events/edit/:id' element={<EditEvent/>} />
      <Route path='/events/delete/:id' element={<DeleteEvent/>} />
    </Routes>
  )
}

export default App;