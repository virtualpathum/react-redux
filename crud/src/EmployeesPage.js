import React from 'react';
import {connect} from 'react-redux';
import PropTypes from 'prop-types';
import EmployeesList from './EmployeesList';
import {fetchEmployees, deleteEmployee} from './actions';


class EmployeesPage extends React.Component{
 componentDidMount(){
     this.props.fetchEmployees();
 }

    render(){
        return(
            <div>
                <h1>Employee List</h1>
                <EmployeesList employees={this.props.employees} deleteEmployee={this.props.deleteEmployee}/>
            </div>
        );
    }
}

EmployeesPage.propTypes = {
    employees:PropTypes.array.isRequired,
    fetchEmployees:PropTypes.func.isRequired,
    deleteEmployee:PropTypes.func.isRequired
}

function mapStateToProps(state){
    return{
        employees:state.employees
    }
}

export default connect(mapStateToProps,{fetchEmployees,deleteEmployee})(EmployeesPage);
