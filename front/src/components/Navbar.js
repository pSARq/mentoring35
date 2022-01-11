import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav>
      <Link className="link" to="/">Home</Link>
      <Link className="link" to="randomLists">Lista</Link>
    </nav>
  );
};

export default Navbar;
