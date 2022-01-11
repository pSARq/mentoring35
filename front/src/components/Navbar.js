import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="mi-navbar">
      <Link to="/">Home</Link>
      <Link to="randomLists">Lista</Link>
    </nav>
  );
};

export default Navbar;