import React from "react";
import { connect } from "react-redux";
import { saveRandom } from "../actions";
import { useForm } from "react-hook-form";

const From = ({ loading, dispatch }) => {
  const { register, handleSubmit } = useForm();

  const onSubmit = (data) => {
    let random = {
      orginalList: data.contenido
    }
    dispatch(saveRandom(random));
  };
  return (
    <div>
      <form onSubmit={handleSubmit(onSubmit)}>
        <label htmlFor="list">Ingrese una lista separada por comas:</label>
        <div>
          <textarea
            id="list"
            {...register("contenido", {
              required: true
            })}
          />
        </div>
        <button className="btn btn-outline-success" type="submit" disabled={loading}>
          Enviar
        </button>
      </form>
    </div>
  );
};

const stateMapToPros = (state) => ({
  loading: state.random.loading,
})

export default connect(stateMapToPros)(From);
