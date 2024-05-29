import React, { useEffect } from "react";
import { useHistory } from "react-router-dom";
import CustomNavbar from "../components/CustomNavbar/CustomNavbar";
import AnnouncementForm from "../components/AnnouncementForm/AnnouncementForm";

const AddAnnouncementPage = () => {
    const history = useHistory();

    useEffect(() => {
        const accessToken = localStorage.getItem("accessToken");
        const refreshToken = localStorage.getItem("refreshToken");

        if (!accessToken || !refreshToken) {
            history.push("/");
        }
    }, [history]);

    return (
        <>
            <CustomNavbar />
            <AnnouncementForm />
        </>
    );
};

export default AddAnnouncementPage;