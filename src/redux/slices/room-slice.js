import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    "roomId": "",
    "players": [
        {
            "playerId": "",
            "playerSelection": null,
            "playerScore": 0,
            "played": false
        }
    ],
    "isWaitingForPlayer": true,
    "isActive": true
};

const RoomSlice = createSlice({
    name: "Room",
    initialState,
    reducers: {
        initialize(state, action) {
            state = action.payload;
            localStorage.setItem("roomId", action.payload.roomId);
        },
        destroy(state) {
            state = initialState;
            localStorage.removeItem("roomId");
        }
    }
});

export const roomActions = RoomSlice.actions;

export default RoomSlice.reducer;
