import React, { useState, useEffect } from "react";
import axios from "axios";
import { useSelector, useDispatch } from "react-redux";

import ScoreBoard from "../components/gaming/ScoreBoard";
import Options from "../components/gaming/Options";
import Result from "../components/gaming/Result";

const GamePage = () => {

    const isSelected = useSelector(state => state.optionSelected);

    return (
        <div class="wrapper">
            <ScoreBoard />
            {(!isSelected) ? <Options /> : <Result />}
            {/* <Result /> */}
        </div>
    );
};

export default GamePage;
