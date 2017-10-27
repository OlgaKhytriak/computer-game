package com.olga.droidsgame.battle;

import java.util.concurrent.ThreadLocalRandom;

import com.olga.droidsgame.droids.SimpleDroid;

public class AlternatelyDroidChooser implements DroidChooser {
	private SimpleDroid droidJustMadeMove;
	private Team team;

	public AlternatelyDroidChooser(Team team) {

	}

	@Override
	public SimpleDroid choose(Team team) {
		SimpleDroid droid = null;
		int current = team.getTeamList().indexOf(droidJustMadeMove);
		int next;
		next = (current + 1) % (team.getCurrentNumberOfTeamMembers());
		System.out.println(next);
		droid = team.getTeamList().get(next);
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
