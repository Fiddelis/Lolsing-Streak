package me.fiddelis.model;


import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@RegisterForReflection
public class Account {
    @Id
    public String puuid;
    public String gameName;
    public String tagLine;
}
