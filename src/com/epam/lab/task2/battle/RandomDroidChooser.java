package com.epam.lab.task2.battle;

import java.util.concurrent.ThreadLocalRandom;

import com.epam.lab.task2.droids.SimpleDroid;

public class RandomDroidChooser implements DroidChooser {
	private Team team;

	public RandomDroidChooser(Team team) {
		setTeam(team);
	}

	@Override
	public SimpleDroid choose() {
		int max = team.getCurrentNumberOfTeamMembers();
		int index = ThreadLocalRandom.current().nextInt(0, max);
		return team.getTeamList().get(index);
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
