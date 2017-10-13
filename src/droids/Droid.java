package droids;

/**
 * @author okhytadmin
 *
 */
public abstract class Droid {
	/**
	 * Basic heals value. It is used to define the MAX_HEALTH for different droids
	 */
	public static final Integer BASIC_VALUE=10;
	private Integer power;
	private Integer health;
	private Integer energy;
	private Integer positionX;
	private Integer positionY;
	private Integer maxHealth;
	private Integer maxEnergy;
	private Integer maxPower;
		
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

	public Integer getPositionX() {
		return positionX;
	}

	public void setPositionX(Integer positionX) {
		this.positionX = positionX;
	}

	public Integer getPositionY() {
		return positionY;
	}

	public void setPositionY(Integer positionY) {
		this.positionY = positionY;
	}

	abstract public void move(Integer x, Integer y);

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
}
