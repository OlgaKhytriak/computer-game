package com.olga.additional;

import com.olga.droids.SimpleDroid;

public class DriodInformation {
	private SimpleDroid droid;

	public DriodInformation(SimpleDroid droid) {
		setDroid(droid);
	}

	public void printAllInformation() {
		System.out.println(
		String.format("Droid type: %s ; health= %s; energy= %s",droid.getDroidType(),droid.getHealth(),droid.getEnergy()));
	}

	public void printEnergyInformation() {
		Integer energy = droid.getEnergy();
		if (0 == energy) {
			System.out.println("No energy!");
		}
		if (energy > 0) {
			System.out.println(String.format("Energy = %s", energy));
		}
	}

	public void printHealthInformation() {
		Integer health = droid.getHealth();
		Integer maxhealth = droid.getMaxHealth();
		if (health == maxhealth) {
			System.out.println(String.format("Ñompletely healthy!  Health  = %s", health));
		}
		if (health < maxhealth) {
			System.out.println(String.format("Health  = %s", health));
		}
	}

	public SimpleDroid getDroid() {
		return droid;
	}

	public void setDroid(SimpleDroid droid) {
		this.droid = droid;
	}

}
