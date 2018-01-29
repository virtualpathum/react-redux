import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter} from 'react-router-dom';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import 'semantic-ui-css/semantic.min.css';
//createStore creats the redux store and applyMiddleware allows to use thunk middle ware
import {createStore,applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
//provider connects the react and redux
import {Provider} from 'react-redux';
import rootReducer from './rootReducer';
import {composeWithDevTools} from 'redux-devtools-extension';

const store = createStore(rootReducer,

    composeWithDevTools(applyMiddleware(thunk))

);

ReactDOM.render(
    <BrowserRouter>
    <Provider store={store}>    
        <App />
    </Provider>
</BrowserRouter>,
document.getElementById('root'));
registerServiceWorker();
