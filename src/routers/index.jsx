import React from "react";
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";

import HomePage from "../pages/HomePage";
import GamePage from "../pages/GamePage";
import PageNotFound from "../pages/404Page";

const AppRouter = () => (
  <BrowserRouter>
    <div>
      <Routes>
        <Route path="/" element={<HomePage />} exact={true} />
        <Route path="/game" element={<GamePage />} />
        <Route element={<PageNotFound />} />
      </Routes>
    </div>
  </BrowserRouter>
);

export default AppRouter;
