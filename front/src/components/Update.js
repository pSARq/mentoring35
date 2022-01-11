import React, { Fragment, useState } from "react";
import { useForm } from "react-hook-form";

export default function Update({ onUpdate, random }) {
  const {register, handleSubmit, formState:{ errors }} = useForm();
  const [orginalList, setOrginalList] = useState(random.orginalList);
  const idBotonModal = "#editBook" + random.id;
  const idModal = "editBook" + random.id;

  const buttonEdit = () => {
    random.orginalList = orginalList
    onUpdate(random)
  };

  return (
    <Fragment>
      <button
        type="button"
        className="btn btn-primary mb-4"
        data-bs-toggle="modal"
        data-bs-target={idBotonModal}
      >
        Editar
      </button>

      <div
        className="modal fade"
        id={idModal}
        data-bs-backdrop="static"
        data-bs-keyboard="false"
        tabIndex="-1"
        aria-labelledby="staticBackdropLabel"
        aria-hidden="true"
      >
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title" id="staticBackdropLabel">
                Ingrese la nueva lista
              </h5>
              <button
                type="button"
                className="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>

            <form onSubmit={handleSubmit(buttonEdit)}>
              <div className="modal-body">
                <label htmlFor="name" className="form-label">
                  Lista original
                </label>
                <textarea
                  type="text"
                  className="form-control"
                  id="orginalList"
                  value={orginalList}
                  placeholder="Ingrese la lista"
                  {...register("orginalList", {
                    required: {
                      value: true,
                      message: "Campo requerido",
                    },
                  })}
                  onChange={(e) => {
                    setOrginalList(e.target.value);
                  }}
                ></textarea>
                <div className="text-danger">{errors?.orginalList?.message}</div>
              </div>
              <div className="modal-footer">
                <button
                  type="button"
                  className="btn btn-success"
                  data-bs-dismiss="modal"
                >
                  Salir
                </button>
                <button
                  type="submit"
                  className="btn btn-primary"
                  data-bs-dismiss="modal"
                >
                  Guardar
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </Fragment>
  );
}
