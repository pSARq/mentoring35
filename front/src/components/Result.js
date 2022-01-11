import React, {useEffect} from 'react'
import { connect } from 'react-redux';
import { getById } from '../actions';

const Result = ({random, dispatch, idSaved, redirect}) => {
  
  useEffect( async () => {
    dispatch(getById(idSaved))
    await renderResult()
  }, [idSaved, redirect])

  const renderResult = () => {
    if(random){
      return(
        <div>
          <h2>Resultado</h2>
          {random.randomList}
        </div>
      )
    }
    return(
      <div></div>
    )
  }
  

  return (
    <div className='mt-5'>
     {renderResult()}
    </div>
  )
}


const stateMapToPros = state => ({
  random: state.random.random,
  idSaved: state.random.idSaved,
  redirect: state.random.redirect
})

export default connect(stateMapToPros)(Result)
