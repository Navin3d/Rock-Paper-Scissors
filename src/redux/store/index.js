import { configureStore } from "@reduxjs/toolkit";

import score from "../slices/score-slice";
import { scoreActions } from "../slices/score-slice";

const store = configureStore({
    reducer: score
});

const subscriber = () => {
    const updatedState = store.getState();

    console.log("Store: " + JSON.stringify(updatedState));
}

store.subscribe(subscriber);

export default store;
