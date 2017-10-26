package com.olga.additional;

import com.olga.droids.SimpleDroid;

public class PrinterOfDriodInformation {
	private SimpleDroid droid;

	public PrinterOfDriodInformation(SimpleDroid droid) {
		setDroid(droid);
	}

	public void printEnergyInformation() {
		
		Integer energy = droid.getEnergy();
		if (0 == energy) {
			System.out.println("No energy!");
			}
		if (energy>0) {
			System.out.println(String.format("Energy = %s", energy));
		}
	}

	public SimpleDroid getDroid() {
		return droid;
	}

	public void setDroid(SimpleDroid droid) {
		this.droid = droid;
	}

}
