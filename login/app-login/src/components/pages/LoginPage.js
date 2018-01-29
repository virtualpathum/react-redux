import React from 'react';
import LoginForm from '../forms/LoginForm';
//import { Link } from 'react-router-dom';
import PropTypes from 'prop-types';
//connect function is used to connect the component with redux
import {connect} from 'react-redux';
import {login} from '../../actions/auth';


class LoginPage extends React.Component{
    //here pass the data to the login thunk action. if data is valid redirect to the home page
    //history is pass to this component by react router
    //login  thunk will be available when this component is connect to redux
    submit = (data) => this.props.login(data).then(()=>this.props.history.push('/'));

    render(){
        return(
            <div>
                <h1> Login Page </h1>

                <LoginForm submit={this.submit}/>
            </div>
        );
    }
}
LoginPage.propTypes = {
    history:PropTypes.shape({
        push:PropTypes.func.isRequired
    }).isRequired,
    login: PropTypes.func.isRequired
}
//null param means that we do not need any value from redux store
//login is the the dispatch function 
export default connect(null,{login})(LoginPage);