import React from 'react';
import PropTypes from 'prop-types';
import {Link} from 'react-router-dom';
//import {Route} from 'react-router';

export default function EmployeeCard({employee, deleteEmployee}){
    return(
        <div className="ui card" key={employee._id}>
            <div className="content">
                <div className="header">{employee.firstName}</div>
            </div>
            <div className="extra content">
            <div className="ui two buttons">
            {/* creating the route for edit and remove. adding the props */}
                <Link to={`/employee/${employee._id}`} className="ui basic button green">Edit</Link>
                <div className="ui basic button red" onClick={()=>deleteEmployee(employee._id)}>Remove</div>
            </div>
        </div>
        </div>
       
    );
}

EmployeeCard.propTypes = {
    employee:PropTypes.object.isRequired,
}