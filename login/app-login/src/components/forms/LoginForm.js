import React from 'react';
import {Form,Button,Message} from 'semantic-ui-react';
import validator from 'validator';
import PropTypes from 'proptypes';
import InlineError from '../messages/InlineError';

class LoginForm extends React.Component {

  state = {
    data : {email:'',password:''},
    loading:false,
    errors:{}
  };

  //On Change get event and set data. When saving need to keep what is already in data. For that have used ...
  //what we need to
  onChange = e=>this.setState({data:{...this.state.data,[e.target.name]:e.target.value}});

  onSubmit = () =>{
    const errors = this.validate(this.state.data);
    this.setState({errors});
    if(Object.keys(errors).length ===0){
      this.setState({loading:true});
      this.props.submit(this.state.data).catch(err => this.setState({errors:err.response.data.errors, loading:false}));
    }
  }

  validate = (data) =>{
    const errors = {};
    if(!validator.isEmail(data.email)) errors.email = "Invalid email";
    if(!data.password) errors.password = "Password cannot be blank";
    return errors;

  }

  render() {
    const {data,errors,loading} = this.state;
        return(
          <Form onSubmit={this.onSubmit} loading= {loading} >
          {errors.global && <Message negative>
            <Message.Header>Something went wrong</Message.Header>
            <p>{errors.global}</p>
          </Message>}
            <Form.Field error={!!errors.email}>
              <label htmlFor="email">Email</label>
              <input type="email" name="email" placeholder="example@example.com" value={data.email} onChange={this.onChange}/>
              {errors.email && <InlineError text={errors.email}/>}
            </Form.Field>
            <Form.Field error={!!errors.password}>
              <label htmlFor="password">Password</label>
              <input type="password" name="password" placeholder="" value={data.password} onChange={this.onChange} />
              {errors.password && <InlineError text={errors.password} />}
            </Form.Field>

              <Button primary> Login </Button>
          </Form>
      );
  }
}



LoginForm.protoTypes = {
  submit: PropTypes.func.isRequired
};

export default LoginForm;
