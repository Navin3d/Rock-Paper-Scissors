import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    score: 0,
    optionSelected: false,
    selectedOption: "",
    playAgain: false,
    optionSelectedByOpponent: ""
};

const ScoreSlice = createSlice({
    name: "Score",
    initialState,
    reducers: {
        addOne(state) {
            state.score++;
        },
        toggleOptionSelected(state) {
            state.optionSelected = !state.optionSelected;
        },
        changeSelectedOption(state, action) {
            state.selectedOption = action.payload;
            state.optionSelected = !state.optionSelected;
        },
        togglePlayAgain(state) {
            state.playAgain = !state.playAgain;
        },
        setOpponentsOption(state, action) {
            state.optionSelectedByOpponent = action.payload;
        }
    }
});

export const scoreActions = ScoreSlice.actions;

export default ScoreSlice.reducer;
