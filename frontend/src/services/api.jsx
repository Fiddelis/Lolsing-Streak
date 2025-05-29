const apiUrl = import.meta.env.VITE_API_URL;

export const getAccounts = async () => {
  const response = await fetch(`${apiUrl}/account`);
  const data = await response.json();
  return data;
};

export const getMatchesByParticipantPuuid = async (puuid) => {
  const response = await fetch(`${apiUrl}/participant/${puuid}`);
  const data = await response.json();
  return data;
};
