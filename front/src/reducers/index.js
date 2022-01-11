import randomReducer from "./randomReducer"
import { combineReducers } from "redux"

const rootReducer = combineReducers({
    random: randomReducer
})

export default rootReducer

