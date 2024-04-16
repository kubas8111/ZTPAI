import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import HomePage from "./pages/HomePage";
import LoginPage from "./pages/LoginPage";
import SearchPage from "./pages/SearchPage";

const App = () => {
    return (
        <Router>
            <Switch>
                <Route exact path="/" component={HomePage} />
                <Route path="/home" component={HomePage} />
                <Route path="/login" component={LoginPage} />
                <Route path="/search" component={SearchPage} />
                <Route path="/addAnnouncement" component={HomePage} />
                {/* Dodaj więcej tras do innych stron tutaj */}
            </Switch>
        </Router>
    );
};

export default App;