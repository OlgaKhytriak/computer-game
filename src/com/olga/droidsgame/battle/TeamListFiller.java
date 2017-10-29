package com.olga.droidsgame.battle;

import com.olga.droidsgame.droids.DefenderBattleDroid;
import com.olga.droidsgame.droids.SimpleBattleDroid;
import com.olga.droidsgame.droids.SimpleChargeEnergyDroid;
import com.olga.droidsgame.droids.SimpleDroid;
import com.olga.droidsgame.droids.SimpleRepairDroid;
import com.olga.droidsgame.droids.SuperDroid;
import com.olga.droidsgame.io.Keyboard;

public class TeamListFiller {
	private final Keyboard readerFromKeyboard;
	TeamListFiller(){
		readerFromKeyboard = new Keyboard();
	}
	public void fill(Team team) {
		System.out.println("Team has " + team.getBeginNumberOfTeamMembers() + " members.");
		System.out.println("Chois types of drids: 1- RepairDroid; 2- BattleDroid; 3- SuperDroid; 4- ChargeDroid; 5 -BallteDefenderDroid");

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
			if (typeTeamMember == 5 ||typeTeamMember == 1 || typeTeamMember == 2 || typeTeamMember == 3|| typeTeamMember == 4) {
				i++;
				team.getTeamList().add(currentDroid);
				currentDroid.setMyTeam(team);
			}

		}
	}
}
