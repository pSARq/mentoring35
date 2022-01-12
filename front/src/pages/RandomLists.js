import React, { useEffect } from "react";
import { getAll, deleteRandom, updateRandom } from "../actions";
import { connect } from "react-redux";
import Delete from "../components/Delete";
import Update from "../components/Update";
import { useNavigate } from "react-router-dom";

const RandomLists = ({ dispatch, loading, randomLists, hasErrors, redirect }) => {

  let navigate = useNavigate()

  useEffect(async () => {
    if(redirect){
      await navigate(redirect)
    }

    dispatch(getAll());
  }, [dispatch, redirect, navigate]);


  const onDelete = (id) => {dispatch(deleteRandom(id))}

  const onUpdate = (random) => {
      dispatch(updateRandom(random))
  }
  const renderRandomList = () => {
    if (loading) {
      return <h3>Loading questions...</h3>;
    }
    if (hasErrors) {
      return <h3>Unable to display questions.</h3>;
    }

    return (
      <table className="container table">
        <thead className="table-primary">
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Fecha</th>
            <th scope="col">Lista original</th>
            <th scope="col">Lista aleatoria</th>
            <th scope="col"></th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          {randomLists.length != 0 ?
          randomLists.map((random) => (
            <tr key={random.id}>
            <th>{random.id}</th>
            <td>{random.date}</td>
            <td>{random.orginalList}</td>
            <td>{random.randomList}</td>
            <td><Update onUpdate={onUpdate} random={random}/></td>
            <td><Delete onDelete={onDelete} id={random.id}/></td>
          </tr>
          )) :
          <h3>No hay datos</h3>}
        </tbody>
      </table>
    );
  };

  return (
    <div className="container">
      <h1>Lista de randoms</h1>
      {renderRandomList()}
    </div>
  );
};

const mapStateToProps = (state) => ({
  loading: state.random.loading,
  randomLists: state.random.randomLists,
  hasErrors: state.random.hasErrors,
  redirect: state.random.redirect
});

export default connect(mapStateToProps)(RandomLists);
