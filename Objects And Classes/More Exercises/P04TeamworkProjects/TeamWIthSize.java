package P23ObjectsAndClasses_More_Exercises.P04TeamworkProjects;

import java.util.List;

public class TeamWIthSize {
    private String creator;
    private String teamName;
    private List<String> teamList;
    private int teamSize;

    public TeamWIthSize(String creator, String teamName, List<String> teamList, int teamSize) {
        this.creator = creator;
        this.teamName = teamName;
        this.teamList = teamList;
        this.teamSize = teamSize;
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

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
