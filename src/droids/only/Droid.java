package droids.only;

public abstract class Droid {
	private Integer power;
	
	
	/**
	 *  @return Return the value of power
	*/
	public Integer getPower() {
		return power;
	}
	/**
	 *  @return Set the value of power
	 *  @param
	*/
	public void setPower(Integer power) {
		this.power=power;
	}
	/**
	 *  @return Constructor by default 
	*/
	public Droid(){
		
	}

}
