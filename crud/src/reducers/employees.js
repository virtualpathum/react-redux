import { SET_EMPLOYEES, ADD_EMPLOYEE, EMPLOYEE_FETCHED, UPDATED_EMPLOYEE, DELETED_EMPLOYEE } from "../actions";

//This reducer react to the action and act accordingly

export default function employees(state = [],action = {}){
    switch(action.type){
        case SET_EMPLOYEES:
            return action.employees;
        case ADD_EMPLOYEE:
        //returns all items from current state and new item
            return [
                ...state,
                action.employee
            ];
        case EMPLOYEE_FETCHED:
        //search the employee record in the state index by id
            const index = state.findIndex(item => item._id === action.employee._id);
            //employee exists in the state
            if(index > -1){
                //iterate over the state array and search for the employee with the id 
                //and return the employee
                return state.map(item =>{
                    if(item._id === action.employee._id) return action.employee;
                    return item;
                });
            }else{
                return [
                    ...state,
                    action.employee
                ]
            }
        case UPDATED_EMPLOYEE:
            return state.map(item=>{
                if(item._id === action.employee._id) return action.employee
                return item;
            })

        case DELETED_EMPLOYEE:
            return state.filter(item => item._id !== action.employeeId);
        default:return state;
    }
}
    