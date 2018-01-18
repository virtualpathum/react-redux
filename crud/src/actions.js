
export const SET_EMPLOYEES = 'SET_EMPLOYEES'
export const ADD_EMPLOYEE = 'ADD_EMPLOYEE'
export const EMPLOYEE_FETCHED = 'EMPLOYEE_FETCHED'
export const UPDATED_EMPLOYEE = 'UPDATED_EMPLOYEE'
export const DELETED_EMPLOYEE = 'DELETED_EMPLOYEE'


function handleResponse(response){
    if(response.ok){
        return response.json();
    }else{
        let error = new Error(response.statusText);
        error.response = response;
        throw error;
    }
}

//Define the set employees action which accepts the employee collection
// and return object with type SET_EMPLOYEES and employees collection
export function setEmployees(employees){
 return{
     type:SET_EMPLOYEES,
     employees

 }
}

export function employeeFetched(employee){
    console.log("inside employee fetched", employee);
    return{
        type: EMPLOYEE_FETCHED,
        employee
    }
}
 export function updatedEmployee(employee){
    return{
        type: UPDATED_EMPLOYEE,
        employee
    }
} 

export function deletedEmployee(employeeId){
    return{
        type: DELETED_EMPLOYEE,
        employeeId
    }
} 

//redux thunk to add the created employee to the redux store just after we create
//this will cache the created record in the redux store while the actual ajax request process in the background
export function addEmployee(employee){
    console.log("inside add employee");
    return{
        type:ADD_EMPLOYEE,
        employee
    }
}

export function saveEmployee(data){
    return dispatch => {
        return fetch('/api/employees',{
            method: 'post',
            body:JSON.stringify(data),
            headers:{
                "Content-Type":"application/json"
            }
        }).then(handleResponse)
        .then(data => dispatch(addEmployee(data.employee)));
    }

}

export function updateEmployee(data){
    return dispatch => {
        return fetch(`/api/employees/${data._id}`,{
            method: 'put',
            body:JSON.stringify(data),
            headers:{
                "Content-Type":"application/json"
            }
        }).then(handleResponse)
        .then(data => dispatch(updatedEmployee(data.employee)));
    }

}

export function deleteEmployee(id){
    return dispatch => {
        return fetch(`/api/employees/${id}`,{
            method: 'delete',
            headers:{
                "Content-Type":"application/json"
            }
        }).then(handleResponse)
        .then(data => dispatch(deletedEmployee(id)));
    }

}

export function fetchEmployees(){
    return dispatch => {
        fetch('/api/employees')
        //processing the server request here
        //gets the response and conver to json and pass it further
        .then(res=>res.json())
        //dispatch setEmployees action and pass employees collection
        .then(data => dispatch(setEmployees(data.employees)));
    }
}

//if the employee already in redux store need to update it
//else need to add it to the list
export function fetchEmployee(id){
    return dispatch => {
        fetch(`/api/employees/${id}`)
        //processing the server request here
        //gets the response and conver to json and pass it further
        .then(res=>res.json())
        //dispatch setEmployees action and pass employees collection
        .then(data => dispatch(employeeFetched(data.employee)));
    }
}