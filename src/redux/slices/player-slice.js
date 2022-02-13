import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    "playerId": "",
    "playerSelection": null,
    "playerScore": 0,
    "played": false
};

const PlayerSlice = createSlice({
    name: "Player",
    initialState,
    reducers: {
        inializePlayer(state, action) {
            state = action.payload;
            localStorage.setItem("playerId", action.payload.playerId);
        },
        destroyPlayer(state) {
            state = initialState;
            localStorage.removeItem("playerId");
        },
        changePlayerSelection(state, action) {
            state.playerSelection = action.payload;
            state.played = true;
        }
    }
});

export const playerActions = PlayerSlice.actions;

export default PlayerSlice.reducer;
