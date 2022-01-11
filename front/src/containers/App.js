import React from "react";
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import Home from "../pages/Home";
import RandomLists from "../pages/RandomLists"
import NotFound from "../pages/NotFound"
import Navbar from "../components/Navbar"

const App = () => {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />}/>
        <Route path="randomLists" element={<RandomLists />} />
        <Route path="/:id" element={<Home />}/>
        <Route path="*" element={<NotFound />} />
      </Routes>
    </Router>
  );
};



export default App;
