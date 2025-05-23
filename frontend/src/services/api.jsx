const BASE_URL = "http://localhost:8080";

export const getAccounts = async () => {
  const response = await fetch(`${BASE_URL}/account`);
  const data = await response.json();
  return data;
};

export const getMatchesByParticipantPuuid = async (puuid) => {
  const response = await fetch(`${BASE_URL}/participant/${puuid}`);
  const data = await response.json();
  return data;
};
