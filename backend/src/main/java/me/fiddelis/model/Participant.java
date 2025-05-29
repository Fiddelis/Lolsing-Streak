package me.fiddelis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;

@Entity
@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    @JsonIgnore
    public Match match;

    @JsonProperty("puuid")
    public String puuid;

    @JsonProperty("championName")
    public String championName;

    @JsonProperty("riotIdGameName")
    public String riotIdGameName;

    @JsonProperty("riotIdTagline")
    public String riotIdTagline;

    @JsonProperty("role")
    public String role;

    @JsonProperty("kills")
    public int kills;

    @JsonProperty("deaths")
    public int deaths;

    @JsonProperty("assists")
    public int assists;

    @JsonProperty("win")
    public boolean win;

    @JsonProperty("challenges")
    public Challenges challenges;
}
