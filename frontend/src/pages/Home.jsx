import { Carousel } from "primereact/carousel";
import { Tag } from "primereact/tag";
import { Card } from "primereact/card";
import { getAccounts, getMatchesByParticipantPuuid } from "../services/api";
import "../css/Home.css";
import { useEffect, useState } from "react";

function Home() {
  const [accounts, setAccount] = useState([]);
  const [matchesByAccount, setMatchesByAccount] = useState({});
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const loadAccountsAndMatches = async () => {
      try {
        const accountsList = await getAccounts();
        setAccount(accountsList);

        const matchesGrouped = {};

        await Promise.all(
          accountsList.map(async (account) => {
            try {
              const matches = await getMatchesByParticipantPuuid(account.puuid);
              matchesGrouped[account.gameName] = matches;
            } catch (err) {
              console.error("Erro ao buscar partidas de:", account.puuid);
              matchesGrouped[account.gameName] = [];
            }
          })
        );

        setMatchesByAccount(matchesGrouped);
        setError(null);
      } catch (err) {
        setError("Erro ao carregar contas e partidas");
      } finally {
        setLoading(false);
      }
    };

    loadAccountsAndMatches();
  }, []);

  const matchTemplate = (match) => {
    return (
      <>
        <div
          className={`elevate-hover shadow-2 hover:shadow-6 border-round m-2 text-center py-5 px-3 ${
            match.win === true ? "match-win" : "match-loss"
          }`}
        >
          <div>
            <Tag value={match.role === "NONE" ? "JUNGLE" : match.role} />
            <h6 className="mt-0 mb-3"></h6>
            <img
              src={`https://cdn.communitydragon.org/15.10.1/champion/${match.championName}/square`}
              alt={match.championName}
              className="w-5 shadow-6"
            />
          </div>

          <div>
            <h4 className="mb-1">{match.championName}</h4>
            <div class="text-center border-round-sm bg-primary">
              {match.kills}/{match.deaths}/{match.assists}
              <br></br>
              {match.challenges.kda.toFixed(2)}
            </div>
          </div>
        </div>
      </>
    );
  };

  const responsiveOptions = [
    {
      breakpoint: "1400px",
      numVisible: 5,
      numScroll: 1,
    },
    {
      breakpoint: "1199px",
      numVisible: 3,
      numScroll: 1,
    },
    {
      breakpoint: "767px",
      numVisible: 2,
      numScroll: 1,
    },
    {
      breakpoint: "575px",
      numVisible: 1,
      numScroll: 1,
    },
  ];

  return (
    <div className="background">
      <div class="block text-center p-4 border-round">
        <Card title="Lolsing Streak" className="secondary-background">
          <div className="w-8 m-auto text-center">
            Este site foi desenvolvido como uma forma alternativa de visualizar
            suas partidas de League of Legends. A proposta é ir além das
            estatísticas tradicionais, oferecendo uma experiência mais visual e
            interativa para acompanhar seu desempenho no jogo.
          </div>
        </Card>
      </div>
      {Object.entries(matchesByAccount).map(([accountName, matches]) => (
        <div
          key={accountName}
          className="equal-height block font-bold text-center p-4 border-round mb-3 fadein animation-duration-1000"
        >
          <Card title={accountName} className="secondary-background">
            <div className="equal-height">
              <Carousel
                value={matches}
                numVisible={10}
                numScroll={4}
                itemTemplate={matchTemplate}
                responsiveOptions={responsiveOptions}
              />
            </div>
          </Card>
        </div>
      ))}
    </div>
  );
}

export default Home;
