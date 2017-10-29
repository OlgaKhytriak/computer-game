package com.olga.droidsgame.battle;

import java.util.concurrent.ThreadLocalRandom;

import com.olga.droidsgame.constants.DroidType;
import com.olga.droidsgame.droids.BattleDroid;
import com.olga.droidsgame.droids.ChargeEnergyDroid;
import com.olga.droidsgame.droids.RepairDroid;
import com.olga.droidsgame.droids.SimpleDroid;
import com.olga.droidsgame.io.BattleInfoDisplayer;
import com.olga.droidsgame.io.TeamInfoDisplayer;

public class Battle {
	private Team team1;
	private Team team2;
	private Integer turn;
	private TeamInfoDisplayer teamInfoDisplayer;
	private DroidChooser droidChooser1;
	private DroidChooser droidChooser2;
	private BattleInfoDisplayer battleInfoDisplayer;
	private Team teamAttacker;
	private Team teamVictim;

	public Battle(Team team1, Team team2, DroidChooser droidChooser1, DroidChooser droidChooser2) {
		setTeam1(team1);
		setTeam2(team2);
		turn = 0;
		teamInfoDisplayer = new TeamInfoDisplayer();
		battleInfoDisplayer = new BattleInfoDisplayer(this);
		setDroidChooser1(droidChooser1);
		setDroidChooser2(droidChooser2);
	}

	public void startBattle() {
		battleInfoDisplayer.displayTurnInformation();
		int whileController = 100;
		while (!team1.getTeamList().isEmpty() && !team2.getTeamList().isEmpty() && (whileController > 0)) {
			whileController--;
			//
			setTurn(turn + 1);
			System.out.println("-----TURN  №  " + turn + "  (1->2)------");
			if (ifNOEnergyToFightCharge()) {
				return;
			}
			attakTeam1OnTeam2();
			battleInfoDisplayer.displayBouthTeamsInformation();

			if (!team2.getTeamList().isEmpty()) {
				setTurn(turn + 1);
				System.out.println("-----TURN  №  " + turn + "  (2->1) ------");
				if (ifNOEnergyToFightCharge()) {
					return;
				}
				attakTeam2OnTeam1();
				battleInfoDisplayer.displayBouthTeamsInformation();
			} else {
				battleInfoDisplayer.dispalayVinnerInfo(team1);
				return;
			}
		}
		if (team1.getTeamList().isEmpty()) {
			battleInfoDisplayer.dispalayVinnerInfo(team2);
		}
	}

	private boolean turnFirstAttacSecond(Team attackerTeam, Team victimTeam) {
		setTurn(turn + 1);
		System.out.println("-----TURN  №  " + turn + "  (1->2)------");
		if (ifNOEnergyToFightCharge()) {
			return false;
		}
		attakTeam1OnTeam2();
		battleInfoDisplayer.displayBouthTeamsInformation();
		return true;
	}

	private boolean ifNOEnergyToFightCharge() {
		boolean checker = (0 == team1.sumBattleAndChargeTeamEnergy() && 0 == team2.sumBattleAndChargeTeamEnergy());
		if (checker) {
			battleInfoDisplayer.displayNoEnergy();
			int sizeTeam1 = team1.getTeamList().size();
			int sizeTeam2 = team2.getTeamList().size();
			if (sizeTeam1 > sizeTeam2) {
				battleInfoDisplayer.dispalayVinnerInfo(team1);
			} else if (sizeTeam2 > sizeTeam1) {
				battleInfoDisplayer.dispalayVinnerInfo(team2);
			} else {
				battleInfoDisplayer.dispalayDeadHaetInfo();
			}
		}
		return checker;
	}

	public void attakTeam1OnTeam2() {
		SimpleDroid drAttacker = droidChooser1.choose();
		SimpleDroid drVictim = droidChooser2.choose();
		fightTwo(drAttacker, drVictim);
		if (!drVictim.isAlive()) {
			team2.deleteTeamMember(drVictim);
			Integer numberOfTeaMembers = team2.getCurrentNumberOfTeamMembers();
			team2.setNumberOfTeamMembers(numberOfTeaMembers);
		}

	}

	public void attakTeam2OnTeam1() {
		SimpleDroid drAttacker = droidChooser2.choose();
		SimpleDroid drVictim = droidChooser1.choose();
		fightTwo(drAttacker, drVictim);
		if (!drVictim.isAlive()) {
			team1.deleteTeamMember(drVictim);
			Integer numberOfTeaMembers = team1.getCurrentNumberOfTeamMembers();
			team1.setNumberOfTeamMembers(numberOfTeaMembers);
		}
	}

	public void fightTwo(SimpleDroid droidAttacker, SimpleDroid droidVictim) {
		if (0 == droidAttacker.getEnergy()) {
			System.out.println("No energy"); // якщо нема енергії він просто не ходить
			return;
		}
		DroidType attackerType = droidAttacker.getDroidType();
		DroidType victimType = droidVictim.getDroidType();
		if (DroidType.SIMPLE_BATTLE_DROID.equals(attackerType) || DroidType.SUPER_DROID.equals(attackerType)) {
			BattleDroid droidCanShoot = (BattleDroid) droidAttacker;// What is it? : I don't understand what I have done
																	// with interface in this case???
			droidCanShoot.shoot(droidVictim);
		} else if (DroidType.SIMPLE_REPAIR_DROID.equals(attackerType)) {
			SimpleDroid injuredDroid = droidAttacker.getMyTeam().findFirstInjuredDroid();
			// injuredDroid.printInfo();
			if (null == injuredDroid) {
				System.out.println("No injured droids for repairing");
			} else {
				RepairDroid droidCanRepair = (RepairDroid) droidAttacker;
				droidCanRepair.repair(injuredDroid);
			}
		} else if (droidAttacker instanceof ChargeEnergyDroid) {
			SimpleDroid dischargedDroid = droidAttacker.getMyTeam().findFirstDischargedDroid();
			if (null == dischargedDroid) {
				System.out.println("No discharged droid in the team");
			} else {
				ChargeEnergyDroid droidCanCharge = (ChargeEnergyDroid) droidAttacker;
				droidCanCharge.charge(dischargedDroid);
			}

		}

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

	public DroidChooser getDroidChooser2() {
		return droidChooser2;
	}

	public void setDroidChooser2(DroidChooser droidChooser2) {
		this.droidChooser2 = droidChooser2;
	}

	public DroidChooser getDroidChooser1() {
		return droidChooser1;
	}

	public void setDroidChooser1(DroidChooser droidChooser1) {
		this.droidChooser1 = droidChooser1;
	}

	public Integer getTurn() {
		return turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public Team getTeamAttacker() {
		return teamAttacker;
	}

	public void setTeamAttacker(Team teamAttacker) {
		this.teamAttacker = teamAttacker;
	}

	public Team getTeamVictim() {
		return teamVictim;
	}

	public void setTeamVictim(Team teamVictim) {
		this.teamVictim = teamVictim;
	}

}
