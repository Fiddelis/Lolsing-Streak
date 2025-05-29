package me.fiddelis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;

@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
    public long gameCreation;
    public int gameDuration;
    public long gameStartTimestamp;
    public long gameEndTimestamp;
    public String gameMode;
    public List<Participant> participants;
}
