package droids;

import java.util.concurrent.ThreadLocalRandom;

public class Battle {
	private Team team1;
	private Team team2;

	public Battle(Team team1, Team team2) {
		setTeam1(team1);
		setTeam2(team2);

	}

	public void fightTeams() {
		while (!team1.getTeamList().isEmpty() || !team2.getTeamList().isEmpty()) {
			Droid drAttacker = choisRandomDroid(team1);
			Droid drVictim = choisRandomDroid(team2);
			fightTwo(drAttacker, drVictim);
			if (!drVictim.getalive()) {
				team1.
			}

		}

	}

	public void fightTwo(Droid droidAttacker, Droid droidVictim) {
		if (0 == droidAttacker.getEnergy()) {
			System.out.println("No energy");
			return;
		}
		DroidType attackerType = droidAttacker.getDroidType();
		DroidType victimType = droidVictim.getDroidType();
		if (DroidType.SIMPLE_BATTLE_DROID.equals(attackerType) || DroidType.SUPER_DROID.equals(attackerType)) {
			BattleDroid droidCanShoot = (BattleDroid) droidAttacker;
			droidCanShoot.shoot(droidVictim);
		} else {
			RepairDroid droidCanRepair = (RepairDroid) droidAttacker;
			// !!Дописати що він лікує когось із своєї команди
		}

	}

	private Droid choisRandomDroid(Team team) {
		int max = team.getNumberOfTeamMembers();
		int index = ThreadLocalRandom.current().nextInt(0, max);
		return team.getTeamList().get(index);
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

}
