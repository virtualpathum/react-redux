import {USER_LOGGED_IN} from '../types';
import api from '../api';

//this redux action executes after user authenticated by api call
export const userLoggedIn = (user) => ({
    type:USER_LOGGED_IN,
    user
}) 



export const login = credentials => dispatch =>
api.user.login(credentials).then(user=>dispatch(userLoggedIn(user)))