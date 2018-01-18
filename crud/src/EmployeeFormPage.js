import React from 'react';
import {connect} from 'react-redux';
import {saveEmployee,fetchEmployee, updateEmployee} from './actions';
import {Redirect} from 'react-router';
import EmployeeForm from './EmployeeForm'

//this class is responsible for getting data and pass to EmployeeForm component
class EmployeeFormPage extends React.Component{
   
    state = {
        redirect:false
    }

       //To fetch the record by id when the form loads
    // this function executes when the component is mounted to the page
    componentDidMount = () =>{
        const{match} = this.props;
        if(match.params._id){
            this.props.fetchEmployee(match.params._id);
        }
    }

    saveEmployee = ({_id, firstName, lastName, age}) => {
        if(_id){
            return this.props.updateEmployee({_id,firstName,lastName,age}).then(
                    ()=>{this.setState({redirect:true})},
             );
        }else{
            return this.props.saveEmployee({firstName,lastName,age}).then(
                () => {this.setState({redirect:true})},
             );
        }
    }
   
    render(){
        return(
            <div>
                {
                    this.state.redirect ?
                    <Redirect to="/employees" /> :
                    <EmployeeForm
                        employee={this.props.employee}
                        saveEmployee={this.saveEmployee}/>
                }
            </div>
        );
    }
}

// When updating
//if the id is present we need to check whether the record is available in redux store

function mapStateToProps(state,props){
    const{match} = props;
    if(match.params._id){
        console.log(state)
        return{
            employee:state.employees.find(item => item._id === props.match.params._id)
        }
    }
    return{ employee:null};
}

export default connect(mapStateToProps,{saveEmployee,fetchEmployee, updateEmployee}) (EmployeeFormPage);
