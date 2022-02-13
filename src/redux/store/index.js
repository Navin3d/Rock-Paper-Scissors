import { configureStore } from "@reduxjs/toolkit";

import RoomSlice from "../slices/room-slice";
import PlayerSlice from "../slices/player-slice";

const store = configureStore({
    reducer: {
        room: RoomSlice,
        player: PlayerSlice,
    }
});

const subscriber = () => {
    const updatedState = store.getState();

    console.log("Store: " + JSON.stringify(updatedState));
}

store.subscribe(subscriber);

export default store;
