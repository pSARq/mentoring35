import React, { useEffect } from "react";
import { getAll, deleteRandom, updateRandom } from "../actions";
import { connect } from "react-redux";
import Delete from "../components/Delete";
import Update from "../components/Update";

const RandomLists = ({ dispatch, loading, randomLists, hasErrors, redirect }) => {
  useEffect(() => {
    dispatch(getAll());
    console.log(randomLists)
  }, [dispatch, redirect]);

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
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Fecha</th>
            <th scope="col">Lista original</th>
            <th scope="col">Lista aleatoria</th>
            <th scope="col"></th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          {randomLists.map((random) => (
            <tr key={random.id}>
            <th>{random.id}</th>
            <td>{random.date}</td>
            <td>{random.orginalList}</td>
            <td>{random.randomList}</td>
            <td><Update onUpdate={onUpdate} random={random}/></td>
            <td><Delete onDelete={onDelete} id={random.id}/></td>
          </tr>
          ))}
        </tbody>
      </table>
    );
  };

  return (
    <div>
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
