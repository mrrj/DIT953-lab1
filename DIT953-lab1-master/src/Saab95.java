import java.awt.*;

/**
 * Represents a Saab 9-5.
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Saab95 extends car implements ITruckTransportable{
    private boolean turboOn;

    /**
     * Constructor for Saab95 objects.
     */
    public Saab95() {
        super(2,Color.red,125,"Saab95", 1000);
        turboOn = false;
    }

    /**
     * Turns turbo on.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns turbo off.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * @return the current speed factor of the car.
     */
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        double sf = speedFactor(turbo);
        System.out.println(sf);
        return sf;
    }

    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * Increases the speed of the Saab95 depending on the given amount and whether or not the turbo is turned on.
     * The given amount has to be between 0 and 1.
     * @param amount
     */
    @Override
    public void gas(double amount){
        gas(speedFactor(), amount);
    }

    /**
     * Decreases the speed of the car depending on the given amount and whether or not turbo is turned on.
     * The given amount can only be between 0 and 1.
     * @param amount specifies the amount with which to decrease the speed.
     */
    @Override
    public void brake(double amount){
        brake(speedFactor(), amount);
    }
}
