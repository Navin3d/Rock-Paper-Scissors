import React, { useState } from "react";

import Header from "../components/basic/Header";
import Footer from "../components/basic/Footer";
import CreateRoomForm from "../components/forms/CreateRoomForm";
import RoomJoiningForm from "../components/forms/RoomJoiningForm";

const HomePage = () => {

    const [isCreateHidden, setCreateHidden] = useState(true);

    const handleClick = () => {
        setCreateHidden(prev => !prev);
    }

    return (
        <div>
            <div class="container">
                <div hidden={isCreateHidden}>
                    <CreateRoomForm />
                </div>
                <div hidden={!isCreateHidden}>
                    <RoomJoiningForm />
                </div>
                <button className="create" onClick={handleClick}>Create Or join</button>
            </div>
            {/* <Header /> */}
            {/* <Footer /> */}
        </div>
    );
}

export default HomePage;
