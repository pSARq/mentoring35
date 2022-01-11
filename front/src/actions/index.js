// const URL_BASE = 'https://back-aplicacion-empresarial.herokuapp.com';
const URL_BASE = "https://localhost:8080/random";

export const LOADING = "LOADING";
export const LOADED_SUCCESS = "LOADED_SUCCESS";
export const LOADED_FAILURE = "LOADED_FAILURE";

export const loading = () => ({
  type: LOADING,
});

export const success = (payload) => ({
  type: LOADED_SUCCESS,
  payload,
});

export const failure = () => ({
  type: LOADED_FAILURE,
});

export const getAll = () => {
  return async (dispatch) => {
    dispatch(loading());
    try {
      const response = await fetch(`${URL_BASE}/get`);
      const data = await response.json();
      dispatch(success({ randomLists: data, redirect: null }));
    } catch (error) {
      dispatch(failure());
    }
  };
};

export const getById = (idRandomList) => {
  return async (dispatch) => {
    dispatch(loading());
    try {
      const response = await fetch(`${URL_BASE}/get/${idRandomList}`);
      const data = await response.json();
      dispatch(success({ random: data, redirect: null }));
    } catch (error) {
      dispatch(failure());
    }
  };
};

export const saveRandom = (orginalList) => {
  return async (dispatch) => {
    dispatch(loading());
    try {
      const response = await fetch(`${URL_BASE}/save`, {
        method: "POST",
        mode: "cors",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(orginalList),
      });
      const id = await response.text();
      dispatch(success({ redirect: `/${id}` }));
    } catch (error) {
      dispatch(failure());
    }
  };
}

export const updateRandom = (question) => {
  return async (dispatch) => {
    dispatch(loading());
    try {
      const response = await fetch(`${URL_BASE}/update`, {
        method: "PUT",
        mode: "cors",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(question),
      });
      const id = await response.text();
      dispatch(success({ redirect: `/${id}` }));
    } catch (error) {
      dispatch(failure());
    }
  };
}

export const deleteRandom = (idRandomList) => {
  return async (dispatch) => {
    dispatch(loading());
    try {
      await fetch(`${URL_BASE}/delete/${idRandomList}`, {
        method: "DELETE",
        mode: "cors",
        headers: {
          "Content-Type": "application/json",
        },
      });
      dispatch(success({ redirect: `/` }));
    } catch (error) {
      dispatch(failure());
    }
  };
}

