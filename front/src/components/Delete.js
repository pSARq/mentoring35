import React, {Fragment} from 'react'

export default function Delete({onDelete, id}) {

    const idBotonModal = "#deleteBook" + id;
    const idModal = "deleteBook" + id;

    const buttonDelete = () => {    
        onDelete(id)
    }

    return (
        <Fragment>
        <button
          type="button"
          className="btn btn-outline-danger"
          data-bs-toggle="modal"
          data-bs-target={idBotonModal}
        >
          Eliminar
        </button>
  
        <div
          className="modal fade"
          id={idModal}
          tabIndex="-1"
          aria-labelledby="exampleModalLabel"
          aria-hidden="true"
        >
          <div className="modal-dialog">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title" id="exampleModalLabel">
                  ¿Está seguro que quiere eliminar?
                </h5>
                <button
                  type="button"
                  className="btn-close"
                  data-bs-dismiss="modal"
                  aria-label="Close"
                ></button>
              </div>
              <div className="modal-footer">
                <button
                  type="button"
                  className="btn btn-primary"
                  data-bs-dismiss="modal"
                >
                  Volver
                </button>
                <button type="button" onClick={buttonDelete} className="btn btn-danger" data-bs-dismiss="modal">
                  Eliminar
                </button>
              </div>
            </div>
          </div>
        </div>
      </Fragment>
    )
}
