package droids;

import java.util.concurrent.ThreadLocalRandom;

public class Battle {
private Team team1;
private Team team2;

public Battle (Team team1, Team team2) {
	setTeam1(team1);
	setTeam2(team2);
	
}
public void fightTeam() {
	
}
public void fightTwo(Droid droidAttacker,Droid droidVictim ) {
	
}
private int randomNumber(Team team) {
	int max=team.getNumberOfTeamMembers();
	int rnd=ThreadLocalRandom.current().nextInt(0, max);
	System.out.println(rnd);
	return rnd;
}
private Droid choisAttacker(Team team) {
	int index=randomNumber(team);
	return team.getTeamList().get(index);
}
private Droid choisVictim(Team team) {
	int index=randomNumber(team);
	return team.getTeamList().get(index);
}
public Team getTeam1() {
	return team1;
}
public void setTeam1(Team team1) {
	this.team1 = team1;
}
public Team getTeam2() {
	return team2;
}
public void setTeam2(Team team2) {
	this.team2 = team2;
}

}
