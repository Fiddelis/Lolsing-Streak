package me.fiddelis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {

    @Id
    @JsonProperty("matchId")
    public String matchId;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("participants")
    public List<Participant> participants = new ArrayList<>();

    @JsonProperty("gameCreation")
    public long gameCreation;

    @JsonProperty("gameDuration")
    public int gameDuration;

    @JsonProperty("gameStartTimestamp")
    public long gameStartTimestamp;

    @JsonProperty("gameEndTimestamp")
    public long gameEndTimestamp;

    @JsonProperty("gameMode")
    public String gameMode;

    @JsonProperty("info")
    public void unpackInfo(Info info) {
        this.gameCreation = info.gameCreation;
        this.gameDuration = info.gameDuration;
        this.gameStartTimestamp = info.gameStartTimestamp;
        this.gameEndTimestamp = info.gameEndTimestamp;
        this.gameMode = info.gameMode;

        for (Participant p : info.participants) {
            p.match = this;
            this.participants.add(p);
        }
    }

    @JsonProperty("metadata")
    public void unpackMetadata(Map<String, Object> metadata) {
        this.matchId = (String) metadata.get("matchId");
    }
}
