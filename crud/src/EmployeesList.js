import React from 'react';
import PropTypes from 'prop-types';
import EmployeeCard from './EmployeeCard';

export default function EmployeesList({employees,deleteEmployee}) {

    const emptyMessage = (
        <p>There are no employees in the list</p>
    );

    const employeeList = (
        <div className="ui four cards">
            {employees.map(employee => <EmployeeCard employee={employee}  deleteEmployee={deleteEmployee}/>)}
        </div>
    );

    return(
        <div>
            {employees.length === 0? emptyMessage : employeeList}
        </div>
    );
}

EmployeesList.proptypes = {
    employees:PropTypes.array.isRequired,
    deleteEmployee:PropTypes.func.isRequired
}