package me.fiddelis.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    public String puuid;
    public String gameName;
    public String tagLine;
}
