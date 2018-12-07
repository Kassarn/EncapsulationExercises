package p04_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                List<Team> teams = new ArrayList<>();


                String line = "";
                while (!"END".equals(line = reader.readLine())) {

                    String[] command = line.split(";");
                    String currentTeam = command[1];
                    try {
                        switch (command[0]) {
                            case "Team":
                                Team team = new Team(command[1]);
                                teams.add(team);

                                break;
                            case "Add":
                                addPlayer(teams, command, currentTeam);
                                break;
                            case "Remove":
                                removePlayer(teams, command, currentTeam);

                                break;
                            case "Rating":
                                for (Team team1 : teams) {
                                    if (currentTeam.equals(team1.getName())) {
                                        System.out.printf("%s - %s",team1.getName(),new DecimalFormat("#.##").format(team1.getRating()));
                                    } else {
                                        System.out.printf("Team %s does not exist.\n", currentTeam);
                                    }
                                }
                                break;
                        }
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }



                }



    }

    private static void removePlayer(List<Team> teams, String[] command, String currentTeam) {
        String playername = command[2];

        for (Team team1 : teams) {
            if (currentTeam.equals(team1.getName())) {
              team1.removePlayer(playername); /// TODO: 11/19/2018
            }
        }

    }

    private static void addPlayer(List<Team> teams, String[] command, String currentTeam) {
        String playername = command[2];
        int statsOne = Integer.parseInt(command[3]);
        int statsTwo = Integer.parseInt(command[4]);
        int statsThree = Integer.parseInt(command[5]);
        int statsFour = Integer.parseInt(command[6]);
        int statsFive = Integer.parseInt(command[7]);
        Player player = new Player(playername, statsOne, statsTwo, statsThree, statsFour, statsFive);
        boolean isExist = true;
        for (Team team1 : teams) {
            if (currentTeam.equals(team1.getName())) {
                team1.addPlayer(player);
                isExist= false;
            }
        }
        if(isExist){
            System.out.printf("Team %s does not exist.\n",currentTeam);
        }
    }
}
