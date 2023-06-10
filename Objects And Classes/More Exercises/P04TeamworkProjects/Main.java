package P23ObjectsAndClasses_More_Exercises.P04TeamworkProjects;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTeams = Integer.parseInt(scanner.nextLine());
        List<Team> teamList = new ArrayList<>();

        for (int i = 1; i <= numTeams; i++) {
            String input = scanner.nextLine();
            String currentCreator = input.split("-")[0];
            String currentTeamName = input.split("-")[1];
            List<String> teamNames = new ArrayList<>();
            Team team = new Team(currentCreator, currentTeamName, teamNames);

            if (teamList.stream().anyMatch(p -> p.getTeamName().equals(currentTeamName))) {
                System.out.printf("Team %s was already created!%n", currentTeamName);
                continue;
            }
            if (teamList.stream().anyMatch(p -> p.getCreator().equals(currentCreator))) {
                System.out.printf("%s cannot create another team!%n", currentCreator);
                continue;
            }

            teamList.add(team);
            System.out.printf("Team %s has been created by %s!%n", currentTeamName, currentCreator);
        }

        String command = scanner.nextLine();

        while (!command.equals("end of assignment")) {
            String currentUser = command.split("->")[0];
            String currentTeam = command.split("->")[1];
            if (teamList.stream().noneMatch(p -> p.getTeamName().equals(currentTeam))) {
                System.out.printf("Team %s does not exist!%n", currentTeam);
                command = scanner.nextLine();
                continue;
            }

            if (teamList.stream().anyMatch(p -> p.getCreator().equals(currentUser)) || teamList.stream().anyMatch(p -> p.getTeamList().contains(currentUser))) {
                System.out.printf("Member %s cannot join team %s!%n", currentUser, currentTeam);
                command = scanner.nextLine();
                continue;
            }

            for (Team team : teamList) {
               if (team.getTeamName().equals(currentTeam)) {
                   team.getTeamList().add(currentUser);
               }
            }

            command = scanner.nextLine();
        }

        List<Team> disbandedTeamsList = new ArrayList<>();

        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).getTeamList().size() == 0) {
                disbandedTeamsList.add(teamList.get(i));
                teamList.remove(i);
                i--;
            }
        }

        List<TeamWIthSize> activeTeams = new ArrayList<>();
        for (Team team : teamList) {
            String creator = team.getCreator();
            String teamName = team.getTeamName();
            List<String> listOfTeams = team.getTeamList();
            int teamSize = team.getTeamList().size();
            TeamWIthSize newTeam = new TeamWIthSize(creator, teamName, listOfTeams, teamSize);
            activeTeams.add(newTeam);
        }

        activeTeams.sort(Comparator.comparing(TeamWIthSize :: getTeamSize).reversed().thenComparing(Comparator.comparing(TeamWIthSize :: getTeamName)));

        disbandedTeamsList.sort(Comparator.comparing(Team :: getTeamName));

        for (TeamWIthSize activeTeam : activeTeams) {
            Collections.sort(activeTeam.getTeamList());
            System.out.println(activeTeam.getTeamName());
            System.out.println("- " + activeTeam.getCreator());
            for (String name : activeTeam.getTeamList()) {
                System.out.println("-- " + name);
            }
        }

        System.out.println("Teams to disband:");

        for (Team team : disbandedTeamsList) {
            Collections.sort(team.getTeamList());
            System.out.println(team.getTeamName());
        }

    }
}
