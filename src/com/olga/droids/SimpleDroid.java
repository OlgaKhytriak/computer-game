package com.olga.droids;

import com.olga.battle.Team;

/**
 * @author okhytadmin
 *
 */
public abstract class SimpleDroid implements Droid{
	/**
	 * Basic heals value. It is used to define the MAX_HEALTH for different droids
	 */
	public static final Integer BASIC_VALUE = 10;
	private Integer health;
	private Integer energy;
	private Integer maxHealth;
	private Integer maxEnergy;
	private Integer maxPower;
	private DroidType droidType;
	private boolean alive;
	private Team myTeam;

	public void printInfo() {
		System.out.println("Droid type:"+droidType+"; health="+health+"; energy="+energy+"; alive="+alive);
	}
	
	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getEnergy() {
		return energy;
	}

	public void setEnergy(Integer energy) {
		this.energy = energy;
	}

	public Integer getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(Integer maxHealth) {
		this.maxHealth = maxHealth;
	}

	public Integer getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(Integer maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public Integer getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(Integer maxPower) {
		this.maxPower = maxPower;
	}

	public DroidType getDroidType() {
		return droidType;
	}

	public void setDroidType(DroidType droidtype) {
		this.droidType = droidtype;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Team getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(Team myTeam) {
		this.myTeam = myTeam;
	}

	
	
	
}
