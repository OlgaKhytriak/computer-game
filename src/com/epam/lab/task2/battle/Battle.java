package com.epam.lab.task2.battle;

import org.apache.log4j.Logger;

import com.epam.lab.task2.StartGame;
import com.epam.lab.task2.constants.GeneralProjectConstants;
import com.epam.lab.task2.droids.BattleDroid;
import com.epam.lab.task2.droids.ChargeEnergyDroid;
import com.epam.lab.task2.droids.RepairDroid;
import com.epam.lab.task2.droids.SimpleDroid;
import com.epam.lab.task2.io.BattleInfoDisplayer;
import com.epam.lab.task2.io.TeamInfoDisplayer;

public class Battle {
	private Team team1;
	private Team team2;
	private Integer turn;
	private DroidChooser droidChooser1;
	private DroidChooser droidChooser2;
	private BattleInfoDisplayer battleInfoDisplayer;
	private Team teamAttacker;
	private Team teamVictim;
	private BattleField battleField;
	private StrategyChooser strategyChooser;
	private static final Logger LOG = Logger.getLogger(Battle.class);

	public Battle() {
		strategyChooser = new StrategyChooser(this);
		battleField = new BattleField();
		setTeam1(battleField.getTeam1());
		setTeam2(battleField.getTeam2());
		setTurn(0);
		new TeamInfoDisplayer();
		battleInfoDisplayer = new BattleInfoDisplayer(this);
		chooseStrategies();
		setDroidChooser1(droidChooser1);
		setDroidChooser2(droidChooser2);
	}

	public void chooseStrategies() {

		int indexStrategyTeam1 = strategyChooser.chooseStrategy(team1);

		if (1 == indexStrategyTeam1) {
			droidChooser1 = new RandomDroidChooser(team1);
		} else if (2 == indexStrategyTeam1) {
			droidChooser1 = new AlternatelyDroidChooser(team1);
		} else {
			LOG.error("Incorrect number of strategy. Try again.");
			chooseStrategies();
			return;
		}
		int indexStrategyTeam2 = strategyChooser.chooseStrategy(team2);
		if (1 == indexStrategyTeam2) {
			droidChooser2 = new RandomDroidChooser(team2);
		} else if (2 == indexStrategyTeam2) {
			droidChooser2 = new AlternatelyDroidChooser(team2);
		} else {
			LOG.error("Incorrect number of strategy. Try again.");
			chooseStrategies();
			return;
		}

	}

	public void startBattle() {
		battleInfoDisplayer.displayTurnInformation();
		int whileController = GeneralProjectConstants.WHILE_CONTROLLER;
		while (!team1.getTeamList().isEmpty() && !team2.getTeamList().isEmpty() && (whileController > 0)) {
			whileController--;
			if (!team1.isBattleDroidTeam() || !team2.isBattleDroidTeam()) {
				LOG.info("No Battle droid in both teams");
				return;
			}
			turnFirstAttackSecond(team1, team2);
			boolean chargeInfo = ifNOEnergyToFightCharge();
			if (chargeInfo) {
				return;
			}
			if (!team2.getTeamList().isEmpty()) {
				turnSocondAttackFirst(team2, team1);
				chargeInfo = ifNOEnergyToFightCharge();
				if (chargeInfo) {
					return;
				}
			} else {
				battleInfoDisplayer.dispalayVinnerInfo(team1);
				return;
			}
		}
		if (team1.getTeamList().isEmpty()) {
			battleInfoDisplayer.dispalayVinnerInfo(team2);
		}

	}

	private boolean turnFirstAttackSecond(Team attackerTeam, Team victimTeam) {
		setTurn(turn + 1);
		LOG.info("-----TURN  �  " + turn + "  (1->2)------");
		if (ifNOEnergyToFightCharge()) {
			return false;
		}
		attakTeam1OnTeam2();
		battleInfoDisplayer.displayBouthTeamsInformation();
		return true;
	}

	private boolean turnSocondAttackFirst(Team attackerTeam, Team victimTeam) {
		setTurn(turn + 1);
		LOG.info("-----TURN  �  " + turn + "  (2->1)------");
		if (ifNOEnergyToFightCharge()) {
			return false;
		}
		attakTeam2OnTeam1();
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
		LOG.info(String.format("%s is moving", droidAttacker.toString()));
		if (0 == droidAttacker.getEnergy()) {
			LOG.info("No energy");
			return;
		}
		if (droidAttacker instanceof BattleDroid) {
			BattleDroid droidCanShoot = (BattleDroid) droidAttacker;
			LOG.info(String.format("%s is victim", droidVictim.toString()));
			droidCanShoot.shoot(droidVictim);
		}
		if (droidAttacker instanceof RepairDroid) {
			SimpleDroid injuredDroid = droidAttacker.getMyTeam().findFirstInjuredDroid();
			if (null == injuredDroid) {
				LOG.info("No injured droids for repairing.");
			} else {
				RepairDroid droidCanRepair = (RepairDroid) droidAttacker;
				LOG.info(String.format("%s will be repaired", injuredDroid.toString()));
				droidCanRepair.repair(injuredDroid);
			}
		}
		if (droidAttacker instanceof ChargeEnergyDroid) {
			SimpleDroid dischargedDroid = droidAttacker.getMyTeam().findFirstDischargedDroid();
			if (null == dischargedDroid) {
				LOG.info("No discharged droid in the team");
			} else {
				ChargeEnergyDroid droidCanCharge = (ChargeEnergyDroid) droidAttacker;
				LOG.info(String.format("%s will be charged", dischargedDroid.toString()));
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
