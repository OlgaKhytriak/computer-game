package com.olga.droidsgame.io;

import org.apache.log4j.Logger;

import com.olga.droidsgame.droids.SimpleDroid;

public class DriodInfoDisplayer { /// +++
	private static final Logger LOG = Logger.getLogger(DriodInfoDisplayer.class);

	public DriodInfoDisplayer() {
	}

	public void printAllInformation(SimpleDroid droid) {
		LOG.info(String.format("Droid type: %s ; health= %s; energy= %s", droid.getDroidType(), droid.getHealth(),
				droid.getEnergy()));
	}

	public void printEnergyInformation(SimpleDroid droid) {
		Integer energy = droid.getEnergy();
		if (0 == energy) {
			LOG.info("No energy!");
		}
		if (energy > 0) {
			LOG.info(String.format("Energy = %s", energy));
		}
	}

	public void printHealthInformation(SimpleDroid droid) {
		Integer health = droid.getHealth();
		Integer maxhealth = droid.getMaxHealth();
		if (health == maxhealth) {
			LOG.info(String.format("Ñompletely healthy!  Health  = %s", health));
		}
		if (health < maxhealth) {
			LOG.info(String.format("Health  = %s", health));
		}
	}

}
