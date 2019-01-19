package Ecosystem;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.*;

public class Territory{
	Plant plant;
    ArrayList <Resource> resources;
    String ground;
    Image groundImg = null, plantImg = null;

    public Territory(String gName) {
        resources = new ArrayList<Resource>();
        ground = gName;
        
        try
		{
			groundImg = ImageIO.read(new File("Summative Graphics\\" + gName + ".png"));
		}
		catch (IOException e)
		{
		}
    }
    
    public Territory(String gName, String pName) {
    	this(gName);
    	plant = new Plant(pName);

    	try
		{
			plantImg = ImageIO.read(new File("Summative Graphics\\" + pName + ".png"));
		}
		catch (IOException e)
		{
		}
    }
    
    public void grow() {
    	
    }
    
    public void release() {
    	resources.add(plant.resource);
    }

}
