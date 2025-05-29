import Home from "./pages/Home";
import Player from "./pages/Player";
import MenuBar from "./components/MenuBar";
import "./App.css";
import { Route, Routes } from "react-router-dom";
function App() {
  import.meta.env.VITE_API_URL;

  return (
    <>
      <MenuBar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/player/:puuid" element={<Player />} />
        <Route path="/match/:matchId" element={<Player />} />
      </Routes>
    </>
  );
}

export default App;
