package com.olga.droidsgame.battle;

import java.util.concurrent.ThreadLocalRandom;

import com.olga.droidsgame.droids.SimpleDroid;

public class AlternatelyDroidChooser implements DroidChooser {
	private SimpleDroid droidJustMadeMove;
	private Team team;
	int indexOfDroidLastTurnMove;

	public AlternatelyDroidChooser(Team team) {
		setTeam(team);
		setDroidJustMadeMove(team.getTeamList().get(0));
		indexOfDroidLastTurnMove=0;
	}

	@Override
	public SimpleDroid choose() {
		SimpleDroid droid = null;
		int next;
		int current;
		current = team.getTeamList().indexOf(droidJustMadeMove);
		
		if (current>=0) {
			next = (current + 1) % (team.getCurrentNumberOfTeamMembers());
		}
		else if (indexOfDroidLastTurnMove<team.getTeamList().size()){
			next=indexOfDroidLastTurnMove;
		}
		else next=0;
		System.out.println("Current = "+current);
		System.out.println(next);
		droid = team.getTeamList().get(next);
		setDroidJustMadeMove(droid);
		indexOfDroidLastTurnMove=next;
		System.out.println(droid.getDroidType());
		return droid;
	}

	public SimpleDroid getDroidJustMadeMove() {
		return droidJustMadeMove;
	}

	public void setDroidJustMadeMove(SimpleDroid droidJustMadeMove) {
		this.droidJustMadeMove = droidJustMadeMove;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}