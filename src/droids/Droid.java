package droids;

/**
 * @author okhytadmin
 *
 */
public abstract class Droid {
	private Integer power;
	private Integer health;
	private Integer energy;
	private byte positionX;
	private byte positionY;
	
	
		/**
	 * @return
	 */
	public Integer getPower() {
		return power;
	}

	/**
	 * @param power
	 */
	public void setPower(Integer power) {
		this.power = power;
	}

	public Droid() {

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

	public Byte getPositionX() {
		return positionX;
	}

	public void setPositionX(Byte positionX) {
		this.positionX = positionX;
	}

	public Byte getPositionY() {
		return positionY;
	}

	public void setPositionY(Byte positionY) {
		this.positionY = positionY;
	}

	abstract public void walk(byte x, byte y);
}
