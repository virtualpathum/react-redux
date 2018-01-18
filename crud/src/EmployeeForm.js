import React from 'react';
import classnames from 'classnames';

//this class receives the data from  EmployeeFormPage and render the form
class EmployeeForm extends React.Component{

    state = {
        _id:this.props.employee ? this.props.employee._id :null,
        firstName:this.props.employee ? this.props.employee.firstName :'',
        lastName:this.props.employee ? this.props.employee.lastName :'',
        age:this.props.employee ? this.props.employee.age :'',
        errors:{},
        loading:false
    }
    //fetching game details is a synchornous action.
    // when its done form component is already rendered to the page
    //when the redux store received the data this function will set that to the state
    componentWillReceiveProps = (nextProps) => {
        this.setState({
            _id:nextProps.employee._id,
            firstName:nextProps.employee.firstName,
            lastName:nextProps.employee.lastName,
            age:nextProps.employee.age
        })
    }



    handleChange = (e) =>{
        //check whether the element exists in the errors
        if(!!this.state.errors[e.target.name]){
            let errors = Object.assign({},this.state.errors);
           //every time user change field, previos validations disapper
            delete errors[e.target.name];
            this.setState({[e.target.name]:e.target.value,errors});
    
        }else{
            this.setState({[e.target.name]:e.target.value});
        }
     }

    handleSubmit = (e) =>{
        e.preventDefault();

         //validation
        let errors = {};
        if(this.state.firstName === '') errors.firstName = "Cannot be empty";
        if(this.state.lastName === '') errors.lastName = "Cannot be empty";
        this.setState({errors});

        const isValid = Object.keys(errors).length === 0 

        if(isValid){
            const {_id,firstName,lastName,age} = this.state;
            this.setState({loading:true});
            this.props.saveEmployee({_id,firstName,lastName,age})
            .catch((err) => err.response.json().then(({errors}) => this.setState({errors,loading:false}))
        );

        }
    }


    render(){

        const form = (
            <form className={classnames('ui','form',{loading:this.state.loading})} onSubmit={this.handleSubmit}>
                <h1>Add New Employee</h1>
                {!!this.state.errors.global && <div className="ui negative message"><p>{this.state.errors.global}</p></div>}
                <div className={classnames('field',{error:!!this.state.errors.firstName})}>
                    <label htmlFor="firstName"> First Name</label>
                    <input name="firstName" value={this.state.firstName} onChange={this.handleChange} id="firstName"/>
                    <span>{this.state.errors.firstName}</span>
                </div>
               
                <div className={classnames('field',{error:!!this.state.errors.lastName})}>
                    <label htmlFor="lastName"> Last Name</label>
                    <input name="lastName" value={this.state.lastName} onChange={this.handleChange} id="lastName"/>
                    <span>{this.state.errors.lastName}</span>
                </div>
                <div className={classnames('field',{error:!!this.state.errors.age})}>
                    <label htmlFor="age"> Age</label>
                    <input name="age" value={this.state.age} onChange={this.handleChange} id="age"/>
                    <span>{this.state.errors.age}</span>
                </div>
                <div className="field">
                    <button className="ui primary button">Save</button>
                </div>
            </form>

        );
        return(
            <div>
                {form}
            </div>
        );
    }

}


export default EmployeeForm;