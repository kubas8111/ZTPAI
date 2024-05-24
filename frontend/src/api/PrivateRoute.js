// import React from "react";
// import { Route, Redirect } from "react-router-dom";
// import { AuthContext } from './AuthContext';
//
// const PrivateRoute = ({ component: Component, ...rest }) => {
//     const auth = useContext(AuthContext);
//
//     return (
//         <Route
//             {...rest}
//             render={(props) =>
//                 auth.accessToken ? <Component {...props} /> : <Redirect to="/login" />
//             }
//         />
//     );
// };
//
// export default PrivateRoute;
