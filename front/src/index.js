import React from 'react'
import { render } from 'react-dom'
import { createStore, applyMiddleware } from 'redux'
import { Provider } from 'react-redux'
import thunk from 'redux-thunk'
import App from './containers/App'
import { composeWithDevTools } from 'redux-devtools-extension'
import rootReducer from "./reducers"

const store = createStore(
  rootReducer,
  composeWithDevTools(applyMiddleware(thunk))
)

render(
  <Provider store={store}>
    <App dispatch={store.dispatch}/>
  </Provider>,
  document.getElementById('root')
)
