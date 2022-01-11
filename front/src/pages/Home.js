import React from "react";
import From from "../components/From";
import Result from "../components/Result";

const Home = () => {
  return (
    <div>
      <div className="container text-center" >
        <h2>Lista Random</h2>
        <From />
        <Result />
      </div>
    </div>
  );
};



export default Home;
