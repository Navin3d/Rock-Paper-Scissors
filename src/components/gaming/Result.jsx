import { useSelector, useDispatch } from "react-redux";

import { scoreActions } from "../../redux/slices/score-slice";
import Paper from "../../asserts/images/Paper.png";
import Rock from "../../asserts/images/Rock.png";
import Scissors from "../../asserts/images/Scissors.png";


const Result = () => {

    const dispatch = useDispatch();

    const yourOption = useSelector(state => state.selectedOption);
    const opponentsOption = useSelector(state => state.optionSelectedByOpponent);

    const optionToImage = (option) => {
        if(option === "Paper") {
            return Paper;
        } else if (option === "Rock") {
            return Rock;
        } else {
            return Scissors;
        }
    }

    const handlePlayAgain = () => {
        dispatch(scoreActions.togglePlayAgain());
    }

    return (
        <div class="contest">       
            <div class="userhand">
                <h1>YOU PICKED</h1>
                <div class="handImageContainer">
                    <img id="userPickImage" src={optionToImage(yourOption)} />
                </div>
            </div>
            <div class="referee"> 
                <div class="decision"><h1> YOU WIN! </h1></div>
                <button class="newGame" onClick={handlePlayAgain}>PLAY AGAIN</button>
            </div>
            <div class="computerhand">
                <h1>THE HOUSE PICKED</h1>
                <div class="handImageContainer">
                    <img id="computerPickImage" src={optionToImage(opponentsOption)} /> 
                </div>   
            </div>       
        </div> 
    );
}

export default Result;
