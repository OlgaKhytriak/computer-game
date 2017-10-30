package com.olga.droidsgame.battle;

import org.apache.log4j.Logger;

import com.olga.droidsgame.io.Keyboard;

public class BattleField {
	private Team team1;
	private Team team2;
	private static final Logger LOG = Logger.getLogger(BattleField.class);
	
	public BattleField(){
		createTeams();
	}
	public void createTeams() {
		Keyboard reader = new Keyboard();
		int n = reader.readIntegerFromKeyboard("Specify the amount of teams:");
		setTeam1(new Team(n));
		setTeam2(new Team(n));
	}
	//public DroidChooser chooseStrategy(Team team) {
	//	LOG.info(String.format("Choice strategy for team [%s]", team.getTeamName()));
	//	return new DroidChooser();
	//}
	
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
