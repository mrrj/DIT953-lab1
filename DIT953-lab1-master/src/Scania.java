import java.awt.*;

/**
 * Represents a Scania.
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Scania extends car {
    private double flatbed = 0;
    /**
     * Constructor of Scania objects.
     */
    public Scania() {
        super(2,Color.red,100, "Scania", 15000);
    }

    /**
     * Raises flatbed with a certain angle.
     * The flatbed cannot be above 70 degrees.
     * @param angle specifies the angle with which to raise the flatbed.
     */
    public void raise(double angle){
        if(getCurrentSpeed()!=0)
        {
            System.out.println("Cannot raise flatbed while moving");
            return;
        }
        flatbed += angle;
        if(flatbed>70)
        {
            flatbed = 70;
            System.out.println("Max angle reached");
        }
    }

    /**
     * Lowers the flatbed with a certain angle.
     * The flatbed cannot be lower than 0 degrees.
     * @param angle specifies the angle with which to lower the flatbed.
     */
    public void lower(double angle){
        flatbed -= angle;
        if(flatbed<0)
        {
            flatbed = 0;
            System.out.println("Min angle reached");
        }
    }

    /**
     * @return the current angle of the flatbed.
     */
    public double getAngle(){
        return flatbed;
    }

    /**
     * Increases the speed by a given amount.
     * Speed can only be increased if flatbed is lowered completely.
     * @param amount specifies the amount with which to increase speed.
     */
    @Override
    public void gas(double amount) {
        if (flatbed == 0) {
            super.gas(amount);
        }
        else {
            System.out.println("Cannot increase speed while flatbed is raised.");
        }
    }

}
