package P23ObjectsAndClasses_More_Exercises.P04TeamworkProjects;

import java.util.List;

public class Team {
    private String creator;
    private String teamName;
    private List<String> teamList;

    public Team(String creator, String teamName, List<String> teamList) {
        this.creator = creator;
        this.teamName = teamName;
        this.teamList = teamList;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<String> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<String> teamList) {
        this.teamList = teamList;
    }
}
