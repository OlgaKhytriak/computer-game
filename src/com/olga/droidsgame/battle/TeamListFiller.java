package com.olga.droidsgame.battle;

import com.olga.droidsgame.droids.DefenderBattleDroid;
import com.olga.droidsgame.droids.SimpleBattleDroid;
import com.olga.droidsgame.droids.SimpleChargeEnergyDroid;
import com.olga.droidsgame.droids.SimpleDroid;
import com.olga.droidsgame.droids.SimpleRepairDroid;
import com.olga.droidsgame.droids.SuperDroid;
import com.olga.droidsgame.io.BattleInfoDisplayer;
import com.olga.droidsgame.io.DriodInfoDisplayer;
import com.olga.droidsgame.io.Keyboard;
import com.olga.droidsgame.io.TeamInfoDisplayer;

public class TeamListFiller {
	private final Keyboard readerFromKeyboard;
	private TeamInfoDisplayer teamInfoDisplayer;
	TeamListFiller() {
		readerFromKeyboard = new Keyboard();
		teamInfoDisplayer = new TeamInfoDisplayer();
	}

	public void fill(Team team) {
		teamInfoDisplayer.printInfoForTeamFill(team);
		SimpleDroid currentDroid = null;
		int i = 0;
		while (i < team.getBeginNumberOfTeamMembers()) {
			Integer typeTeamMember = readerFromKeyboard
					.readIntegerFromKeyboard("Input the type of team member ¹ " + (i + 1));
			switch (typeTeamMember) {
			case 1:
				currentDroid = new SimpleRepairDroid();
				break;
			case 2:
				currentDroid = new SimpleBattleDroid();
				break;
			case 3:
				currentDroid = new SuperDroid();
				break;
			case 4:
				currentDroid = new SimpleChargeEnergyDroid();
				break;
			case 5:
				currentDroid = new DefenderBattleDroid();
				break;
			default:
				System.out.println("You enter wrong type of droid ¹ " + i + "Try again");
				break;
			}
			if (typeTeamMember == 5 || typeTeamMember == 1 || typeTeamMember == 2 || typeTeamMember == 3
					|| typeTeamMember == 4) {
				i++;
				team.getTeamList().add(currentDroid);
				currentDroid.setMyTeam(team);
			}

		}
	}
}
