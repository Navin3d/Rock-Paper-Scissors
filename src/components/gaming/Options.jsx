import { useSelector, useDispatch } from "react-redux";

import { scoreActions } from "../../redux/slices/score-slice";

import Paper from "../../asserts/images/Paper.png";
import Rock from "../../asserts/images/Rock.png";
import Scissors from "../../asserts/images/Scissors.png";

const Options = () => {

    const dispatch = useDispatch();

    const handleClick = (value) => {
        console.log("Clicked: " + value);
        dispatch(scoreActions.changeSelectedOption(value));
    }

    return (
        <div>
            <div class="hands">
                <div class="hand paper">
                    <button name="Paper" onClick={() => handleClick("Paper")} value="Paper"><img src={Paper} /></button>
                </div>
                <div class="hand scissors">
                    <button onClick={() => handleClick("Scissors")} value="Scissors"><img src={Scissors} /></button>
                </div>
                <div class="hand rock">
                    <button onClick={() => handleClick("Rock")} value="Rock"><img src={Rock} /></button>                      
                </div>
            </div>
        </div>
    );
}

export default Options;
