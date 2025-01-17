package Ecosystem;

/**
 * The Plant class represents trees and shrubs in landscape that can drop resources.
 * They are one of the main sources of animal interactions.
 * Plants are randomly generated and randomly spawn food.
 */
public class Plant {

	//fields
	private String name;
	private int size;

	/**
	 * This constructor creates a new Plant.
	 * @param plantName is a String representing what type of plant is made
	 * @param s represents the size of the plant
	 */
	public Plant(String plantName, int s) {
		name = plantName;
		size = s;
	}
	
	/**
	 * The grow method updates the size of the plant.
	 * Plants grow when they are small and slowly fluctuate in size after maturation.
	 */
	public void grow() {
		if (size < 20)
			size += 5;
		else if (size < 40)
			size += 2;
		else if (size < 80)
			size += 1;
		else
			size += Math.random() * 5 - 2;
	}
	
	/**
	 * @return the size of the plant
	 */
	public int size() {
		return size;
	}
}


