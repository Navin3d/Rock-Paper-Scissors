import { useSelector } from "react-redux";

import Title from "../../asserts/images/title.png";

const ScoreBoard = () => {

    const score = useSelector(state => state.score);
    
    return (
        <div class="scoreboard"> 
          <div class="title">
              <img src={Title} />
          </div>
          <div class="score">
              <p>SCORE</p>
              <h1>{ score }</h1>
          </div>
        </div>
    );
}

export default ScoreBoard;
