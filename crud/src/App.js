import React, { Component } from 'react';
import logo from './logo.svg';
import {Link} from 'react-router-dom';
import {Route} from 'react-router';
import EmployeesPage from './EmployeesPage'
import EmployeeFormPage from './EmployeeFormPage'
import './App.css';


const ActiveLink = ({label, to, activeOnlyWhenExact}) => (
  <Route path={to} exact={activeOnlyWhenExact} children={({match}) =>(
    <Link className={match ? 'active item' : 'item'} to={to}>{label}</Link>
  )}/>
);

class App extends Component {
  render() {
    return (
      <div className="ui container">
        <div className="ui three item menu">
        <ActiveLink activeOnlyWhenExact  to="/" label="Home"/>
        <ActiveLink activeOnlyWhenExact to="/employees" label="Employees" />
        <ActiveLink activeOnlyWhenExact  to="/employees/new" label="Add New Employee"/>
        </div>
        {/* define the routes for each link*/}
        <Route exact path="/employees" component={EmployeesPage}/>
        <Route path="/employees/new" component={EmployeeFormPage}/>
        {/* id parameter will be available in the EmployeeForm props*/}
        <Route path="/employee/:_id" component={EmployeeFormPage}/>
      </div>
    );
  }
}

export default App;
