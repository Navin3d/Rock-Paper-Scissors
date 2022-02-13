import { useState, useEffect, Fragment } from "react";
import { Alert, Spinner } from "reactstrap";
import { useNavigate } from 'react-router-dom';
import axios from "axios";

import { baseUrl } from "../../config";
import { roomActions } from "../../redux/slices/room-slice";

const RoomJoiningForm = () => {

    const navigate = useNavigate();

    const [roomId, setRoomId] = useState("");
    const [error, setError] = useState("");
    const [loading, setLoading] = useState(false);
	const [isDisabled, setDisabled] = useState(true);
	const onDismiss = () => setError(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        console.log("Option: " + roomId);
        
        try {
            setLoading(true);
			setError("");

			const url = `${baseUrl}/api/room/${roomId}/join`;
            const response = await axios.get(url);

            localStorage.setItem("roomId", response.data.roomId);
            localStorage.setItem("playerId", response.data.players[0].playerId);

            console.log("Response: " + JSON.stringify(response.data));

            let waiting = await roomActions.initialize(response.data);

            waiting = await navigate("/game");
        } catch (e) {
            setError(e);
            console.log(e);
        } finally {
            setLoading(false);
        }
    }

    const handleChange = (e) => {
		const { value } = e.target;
        setRoomId(value);
	}

    useEffect(() => {
		localStorage.getItem("roomId") ? navigate("/game") : navigate("/");
		const isFilled = Boolean(roomId);
		isFilled ? setDisabled(false) : setDisabled(true);
		document.title = "Join-Room";
	}, [roomId]);

    return (
        <Fragment>
            <form onSubmit={handleSubmit}>
                <Alert color="danger" isOpen={!!error} toggle={onDismiss}>
                    { `${error.message}` }
                </Alert>
                <p>Join Room</p>
                <input type="text" onChange={handleChange} name="roomId" value={roomId} placeholder="Room-Id" /><br />
                <input type="submit" disabled={isDisabled} value="Sign in" /><br />
                { loading && <Spinner color="success" /> }
            </form>
        </Fragment>
    );
}

export default RoomJoiningForm;
