package me.fiddelis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
    public long gameCreation;
    public int gameDuration;
    public long gameStartTimestamp;
    public long gameEndTimestamp;
    public String gameMode;
    public List<Participant> participants;
}
