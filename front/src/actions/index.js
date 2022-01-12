const URL_BASE = 'https://back-taller-clase-fullstack.herokuapp.com/random';


export const LOADING = "LOADING"
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

export function getAll(){
  return async (dispatch) => {
    dispatch(loading());
    try {
      const response = await fetch(`${URL_BASE}/get`);
      const data = await response.json();
      dispatch(success({ randomLists: data, redirect: null, random: null }));
    } catch (error) {
      dispatch(failure());
    }
  };
};

export function getById(idRandomList){
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

export function saveRandom(orginalList){
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
      dispatch(success({ idSaved: id, redirect: "/" }));
    } catch (error) {
      dispatch(failure());
    }
  };
}

export function updateRandom(random){
  return async (dispatch) => {
    dispatch(loading());
    try {
      const response = await fetch(`${URL_BASE}/update`, {
        method: "PUT",
        mode: "cors",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(random),
      });
      dispatch(success({ redirect: `/randomLists`, random: null }));
    } catch (error) {
      dispatch(failure());
    }
  };
}

export function deleteRandom(idRandomList){
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
      dispatch(success({ redirect: `/randomLists`, random: null }));
    } catch (error) {
      dispatch(failure());
    }
  };
}

