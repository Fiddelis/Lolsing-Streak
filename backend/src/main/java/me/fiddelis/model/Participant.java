package me.fiddelis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
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
    private String championName;

    @JsonProperty("riotIdGameName")
    private String riotIdGameName;

    @JsonProperty("riotIdTagline")
    private String riotIdTagline;

    @JsonProperty("role")
    private String role;

    @JsonProperty("kills")
    private int kills;

    @JsonProperty("deaths")
    private int deaths;

    @JsonProperty("assists")
    private int assists;

    @JsonProperty("win")
    private boolean win;

    @JsonProperty("challenges")
    private Challenges challenges;
    // Getters e Setters
}
