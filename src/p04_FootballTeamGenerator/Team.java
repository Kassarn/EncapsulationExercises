package p04_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    private double rating;

    public Team(String name) {
        setName(name);
        this.players =  new ArrayList<>();
    }

    private void setName(String name) {
        if(name.isEmpty() || name.equals("null") || name.matches("\\s+")) {
            throw  new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
    public void removePlayer(String  name){
        if (!this.players.removeIf(p-> p.getName().equals(name))){
            System.out.printf("Player %s is not in %s team.\n",name,this.name);
        }

}

    public String getName() {
        return name;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        try {
            return Math.round(this.players.stream().mapToDouble(Player::getPlayerRating).sum() / this.players.size());
        }catch (Exception e){
            return 0;
        }
    }
}
