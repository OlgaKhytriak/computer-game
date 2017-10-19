package droids;

import java.util.ArrayList;

public class Team {
	private Integer numberOfTeamMembers;
	private ArrayList<Droid> teamList;
	private final Keyboard readerFromKeyboard;

	public void printTeamList() {
		System.out.println("It is the list of team members:");
		for (Droid currentDroid : teamList) {
			 System.out.println("Droid "+currentDroid.getClass().getName());
		}
	}
	public void fillInTeamList() {
		System.out.println("Team has " + numberOfTeamMembers + " members");
		System.out.println("Chois types of drids: 1- RepairDroid; 2- BattleDroid; 3- SuperDroid");
		Droid currentDroid = null;
		int i = 0;
		while (i < numberOfTeamMembers) {
			Integer typeTeamMember = readerFromKeyboard.readIntegerFromKeyboard("Input the type of team member ¹ " + (i+1));
			switch (typeTeamMember) {
			case 1:
				 currentDroid=new SimpleRepairDroid();
				break;
			case 2:
				currentDroid=new SimpleBattleDroid();
				break;
			case 3:
				currentDroid=new SuperDroid();
				break;
			default:
				System.out.println("You enter wrong type of droid ¹ "+i+"Try again");
			break;
			}
			if ((typeTeamMember==1)|(typeTeamMember==2)|(typeTeamMember==3)) {
				i++;
				teamList.add(currentDroid);
			}
			
		}
	}

	/**
	 * @param numberOfTeamMembers
	 */
	Team(Integer numberOfTeamMembers) { // Constructor with number of team's members
		setNumberOfTeamMembers(numberOfTeamMembers);
		setTeamList(new ArrayList<Droid>(numberOfTeamMembers));
		readerFromKeyboard = new Keyboard();
	}

	public Integer getNumberOfTeamMembers() {
		return numberOfTeamMembers;
	}

	public void setNumberOfTeamMembers(Integer numberOfTeamMembers) {
		this.numberOfTeamMembers = numberOfTeamMembers;
	}

	public ArrayList<Droid> getTeamList() {
		return teamList;
	}

	public void setTeamList(ArrayList<Droid> teamList) {
		this.teamList = teamList;
	}
}
