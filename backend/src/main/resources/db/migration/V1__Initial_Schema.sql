CREATE TABLE Account
(
    puuid    VARCHAR(255) NOT NULL,
    gameName VARCHAR(255),
    tagLine  VARCHAR(255),
    CONSTRAINT pk_account PRIMARY KEY (puuid)
);