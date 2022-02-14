import { useSelector, useDispatch } from "react-redux";
import axios from "axios";

import { playerActions } from "../../redux/slices/player-slice";

import Paper from "../../asserts/images/Paper.png";
import Rock from "../../asserts/images/Rock.png";
import Scissors from "../../asserts/images/Scissors.png";
import { baseUrl } from "../../config";

const Options = () => {

    const dispatch = useDispatch();

    const player = useSelector(state => state.player);

    const handleClick = async (value) => {
        console.log("Clicked: " + value);
        dispatch(playerActions.changePlayerSelection(value));

        const url = `${baseUrl}/api/player`;
        
        const res = await axios.post(url, player);

        playerActions.inializePlayer(res.data);

        init();
    }

    const [roomId, setRoomId] = useState("");
    const [playerId, setPlayerId] = useState("");

    const init = async () => {
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
    }

    return (
        <div>
            <div class="hands">
                <div class="hand paper">
                    <button name="Paper" onClick={() => handleClick("PAPER")} value="PAPER"><img src={Paper} /></button>
                </div>
                <div class="hand scissors">
                    <button onClick={() => handleClick("SCISSOR")} value="SCISSOR"><img src={Scissors} /></button>
                </div>
                <div class="hand rock">
                    <button onClick={() => handleClick("ROCK")} value="ROCK"><img src={Rock} /></button>                      
                </div>
            </div>
        </div>
    );
}

export default Options;
