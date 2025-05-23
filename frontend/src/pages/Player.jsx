import { useParams } from "react-router-dom";

function Player() {
  const { puuid } = useParams();
  return <h1>{puuid}</h1>;
}

export default Player;
