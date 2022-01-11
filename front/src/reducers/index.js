import * as actions from '../actions/index'

export const initialState = {
  loading: false,
  hasErrors: false,
  randomLists: [],
  random: {},
  redirect: null
}

export default function randomReducer(state = initialState, action) {
  switch (action.type) {
    case actions.LOADING:
      return { ...state, loading: true }
    case actions.LOADED_SUCCESS:
      return { ...state, ...action.payload, loading: false, hasErrors: false }
    case actions.LOADED_FAILURE:
      return { ...state, loading: false, hasErrors: true }
    default:
      return state
  }
}



// import { combineReducers } from "redux";

// function view(state = { loading: false }, action) {
//   switch (action.type) {
//     //TODO: refactorizar
//     case "view-loading": {
//       return {
//         loading: true,
//       };
//     }
//     case "view-loaded": {
//       return {
//         loading: false,
//       };
//     }
//     default:
//       return state;
//   }
// }

// function random(state = {result: {}},action) {
//   switch (action.type) {
//     case "random-result": {
//       return { result: action.data };
//     }
//     default:
//       return state;
//   }
// }

// const rootReducer = combineReducers({
//   view,
//   random,
// });

// export default rootReducer;
