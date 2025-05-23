import { Menubar } from "primereact/menubar";
import { getAccounts } from "../services/api";
import "../css/Home.css";
import { useEffect, useState } from "react";
function MenuBar() {
  const [players, setPlayers] = useState([]);
  const [error, setError] = useState([]);

  useEffect(() => {
    const getPlayers = async () => {
      try {
        const accountsList = await getAccounts();
        setPlayers(accountsList);
      } catch (err) {}
    };

    getPlayers();
  }, []);

  const items = [
    {
      label: "Home",
      icon: "pi pi-home",
      url: "/",
    },
    {
      label: "Players",
      icon: "pi pi-search",
      items: players.map((player) => ({
        label: player.gameName,
        icon: "pi pi-user",
        url: `/player/${player.puuid}`,
      })),
    },
    {
      label: "Contact",
      icon: "pi pi-envelope",
      url: "/contact",
    },
  ];

  return (
    <Menubar model={items} className="secondary-background p-1 border-round" />
  );
}

export default MenuBar;
