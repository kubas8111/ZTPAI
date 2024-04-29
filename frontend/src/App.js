import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import HomePage from "./pages/HomePage";
import LoginPage from "./pages/LoginPage";
import SearchPage from "./pages/SearchPage";
import ProfilePage from "./pages/ProfilePage";
import AnnouncementPage from "./pages/AnnouncementPage";
import RegisterPage from "./pages/RegisterPage";
import AddAnnouncementPage from "./pages/AddAnnouncementPage";

const App = () => {
    return (
        <Router>
            <Switch>
                <Route exact path="/" component={HomePage} />
                <Route path="/home" component={HomePage} />
                <Route path="/login" component={LoginPage} />
                <Route path="/register" component={RegisterPage} />
                <Route path="/search" component={SearchPage} />
                <Route path="/profile" component={ProfilePage} />

                <Route path="/announcement" component={AnnouncementPage} />
                <Route path="/addAnnouncement" component={AddAnnouncementPage} />
            </Switch>
        </Router>
    );
};

export default App;