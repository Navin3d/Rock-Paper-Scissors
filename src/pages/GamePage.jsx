import React, { useState, useEffect } from "react";
import axios from "axios";
import { useSelector, useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";

import { roomActions } from "../redux/slices/room-slice";
import { playerActions } from "../redux/slices/player-slice";

import ScoreBoard from "../components/gaming/ScoreBoard";
import Options from "../components/gaming/Options";
import Result from "../components/gaming/Result";
import { baseUrl } from "../config";

const GamePage = () => {

    const navigate = useNavigate();
    const isSelected = useSelector(state => state.player.playerSelection);

    const [roomId, setRoomId] = useState("");
    const [playerId, setPlayerId] = useState("");

    useEffect(async () => {
        setRoomId(localStorage.getItem("roomId"));
        setPlayerId(localStorage.getItem("playerId"));

        console.log("Room Id: " + roomId);

        roomId ? navigate("/game") : navigate("/");

        const url1 = `${baseUrl}/api/room/${roomId}/show`;
        const response1 = await axios.get(url1);
        let waiting = await roomActions.initialize(response1.data);

        const url2 = `${baseUrl}/api/player/${playerId}/show`;
        const response2 = await axios.get(url2);
        waiting = await playerActions.inializePlayer(response2.data);
    }, []);

    return (
        <div class="wrapper">
            <ScoreBoard />
            {(!isSelected) ? <Options /> : <Result />}
            {/* <Result /> */}
        </div>
    );
};

export default GamePage;
