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

    return (
        <div class="wrapper">
            <ScoreBoard />
            {(!isSelected) ? <Options /> : <Result />}
            {/* <Result /> */}
        </div>
    );
};

export default GamePage;
