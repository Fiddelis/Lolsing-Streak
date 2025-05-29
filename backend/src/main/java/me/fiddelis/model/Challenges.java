package me.fiddelis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Embeddable;
import java.util.List;

@Embeddable
@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
public class Challenges {

    @JsonProperty("takedowns")
    public int takedowns;

    @JsonProperty("kda")
    public float kda;

    @JsonProperty("killParticipation")
    public float killParticipation;

    @JsonProperty("multikills")
    public int multikills;

    @JsonProperty("legendaryCount")
    public int legendaryCount;

    @JsonProperty("damagePerMinute")
    public float damagePerMinute;

    @JsonProperty("teamDamagePercentage")
    public float teamDamagePercentage;

    @JsonProperty("effectiveHealAndShielding")
    public float effectiveHealAndShielding;

    @JsonProperty("highestChampionDamage")
    public int highestChampionDamage;

    @JsonProperty("baronTakedowns")
    public int baronTakedowns;

    @JsonProperty("dragonTakedowns")
    public int dragonTakedowns;

    @JsonProperty("firstTurretKilled")
    public int firstTurretKilled;

    @JsonProperty("riftHeraldTakedowns")
    public int riftHeraldTakedowns;

    @JsonProperty("turretTakedowns")
    public int turretTakedowns;

    @JsonProperty("visionScorePerMinute")
    public float visionScorePerMinute;

    @JsonProperty("controlWardsPlaced")
    public int controlWardsPlaced;

    @JsonProperty("survivedSingleDigitHpCount")
    public int survivedSingleDigitHpCount;

    @JsonProperty("dodgeSkillShotsSmallWindow")
    public int dodgeSkillShotsSmallWindow;

    @JsonProperty("earlyLaningPhaseGoldExpAdvantage")
    public int earlyLaningPhaseGoldExpAdvantage;

    @JsonProperty("goldPerMinute")
    public float goldPerMinute;

    @JsonProperty("mythicItemUsed")
    public int mythicItemUsed;

    @JsonProperty("gameLength")
    public float gameLength;

    @JsonProperty("playedChampSelectPosition")
    public int playedChampSelectPosition;

    @JsonProperty("legendaryItemUsed")
    public List<Integer> legendaryItemUsed;
}