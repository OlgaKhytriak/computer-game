package com.olga.droidsgame.battle;

import java.util.concurrent.ThreadLocalRandom;

import com.olga.droidsgame.droids.SimpleDroid;

public class RandomDroidChooser implements DroidChooser{

	@Override
	public SimpleDroid choose(Team team) {
		int max = team.getCurrentNumberOfTeamMembers();
		int index = ThreadLocalRandom.current().nextInt(0, max);
		return team.getTeamList().get(index);
	}

}
