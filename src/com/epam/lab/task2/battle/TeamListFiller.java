package com.epam.lab.task2.battle;

import org.apache.log4j.Logger;

import com.epam.lab.task2.droids.BattleLazerDroid;
import com.epam.lab.task2.droids.DefenderBattleDroid;
import com.epam.lab.task2.droids.DefenderRepairDroid;
import com.epam.lab.task2.droids.Droideka;
import com.epam.lab.task2.droids.SimpleBattleDroid;
import com.epam.lab.task2.droids.SimpleChargeEnergyDroid;
import com.epam.lab.task2.droids.SimpleDroid;
import com.epam.lab.task2.droids.SimpleRepairDroid;
import com.epam.lab.task2.droids.SuperDoctor;
import com.epam.lab.task2.droids.SuperDroid;
import com.epam.lab.task2.droids.SuperPowerfullDroid;
import com.epam.lab.task2.io.Keyboard;
import com.epam.lab.task2.io.TeamInfoDisplayer;

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
			case 10:
				currentDroid = new BattleLazerDroid();
				break;
			default:
				LOG.info((String.format("You enter wrong type of droid ¹ [%s].  !! Try again: ",i)));
				break;
			}
			if ((0<typeTeamMember)&&(typeTeamMember<11)) {
				i++;
				team.getTeamList().add(currentDroid);
				currentDroid.setMyTeam(team);
			}

		}
	}
}
