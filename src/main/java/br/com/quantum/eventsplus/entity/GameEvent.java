package br.com.quantum.eventsplus.entity;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;



public class GameEvent {

    private final String name;
    private int playersLimit;
    private PotionEffectType effect;
    private boolean isAvaliable;
    private List<Player> players;
    private List<Location> spawnLocations;
    private int time;
    private boolean isConfigFinish;
    private Location waitPoint;

    public GameEvent(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.spawnLocations = new ArrayList<>();
        this.time = 0;
    }
    public String getName() {
        return name;
    }

    public int getPlayersLimit() {
        return playersLimit;
    }

    public void setPlayersLimit(int limit) {
        this.playersLimit = limit;
    }

    public PotionEffectType getEffect() {
        return effect;
    }

    public void setEffect(PotionEffectType effect) {
        this.effect = effect;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    public void setAvaliable(boolean avaliable) {
        isAvaliable = avaliable;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Location> getSpawnLocations() {
        return spawnLocations;
    }

    public void setSpawnLocations(List<Location> spawnLocations) {
        this.spawnLocations = spawnLocations;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isConfigFinish() {
        return isConfigFinish;
    }

    public void setConfigFinish(boolean configFinish) {
        isConfigFinish = configFinish;
    }

    public void addSpawn(Location location) {
        this.spawnLocations.add(location);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    public Location getWaitPoint() {
        return waitPoint;
    }

    public void setWaitPoint(Location waitPoint) {
        this.waitPoint = waitPoint;
    }

}
