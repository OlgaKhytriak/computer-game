package com.olga.droidsgame.battle;

import org.apache.log4j.Logger;

import com.olga.droidsgame.droids.DefenderBattleDroid;
import com.olga.droidsgame.droids.DefenderRepairDroid;
import com.olga.droidsgame.droids.Droideka;
import com.olga.droidsgame.droids.SimpleBattleDroid;
import com.olga.droidsgame.droids.SimpleChargeEnergyDroid;
import com.olga.droidsgame.droids.SimpleDroid;
import com.olga.droidsgame.droids.SimpleRepairDroid;
import com.olga.droidsgame.droids.SuperDoctor;
import com.olga.droidsgame.droids.SuperDroid;
import com.olga.droidsgame.droids.SuperPowerfullDroid;
import com.olga.droidsgame.io.Keyboard;
import com.olga.droidsgame.io.TeamInfoDisplayer;

public class TeamListFiller {
	private final Keyboard readerFromKeyboard;
	private TeamInfoDisplayer teamInfoDisplayer;
	private static final Logger LOG = Logger.getLogger(TeamListFiller.class);
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
					.readIntegerFromKeyboard(String.format("Input the type of team member ¹ [%s]", i+1));
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
			case 6:
				currentDroid = new Droideka();
				break;
			case 7:
				currentDroid = new SuperDoctor();
				break;
			case 8:
				currentDroid = new DefenderRepairDroid();
				break;
			case 9:
				currentDroid = new SuperPowerfullDroid();
				break;
			default:
				LOG.info((String.format("You enter wrong type of droid ¹ [%s].  !! Try again: ",i)));
				break;
			}
			if ((0<typeTeamMember)&&(typeTeamMember<10)) {
				i++;
				team.getTeamList().add(currentDroid);
				currentDroid.setMyTeam(team);
			}

		}
	}
}
