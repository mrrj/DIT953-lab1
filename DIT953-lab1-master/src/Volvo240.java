import java.awt.*;

/**
 * Represents a Volvo 240.
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Volvo240 extends car implements ITruckTransportable{
    private final static double trimFactor = 1.25;

    /**
     * Constructor of Volvo240 objects.
     */
    public Volvo240(){
       super(4,Color.black,100,"Volvo240", 1000);
    }

    /**
     * @return the current speed factor of the car.
     */
    private double speedFactor(){
        double sf = speedFactor(trimFactor);
        System.out.println(sf);
        return sf;
    }

    /**
     * Increases the speed of the Volvo240 depending on the given amount and trimFactor of the car.
     * The given amount can only be between 0 and 1.
     * @param amount specifies the amount with which to increase speed.
     */
    @Override
    public void gas(double amount){
        gas(speedFactor(), amount);
    }

    /**
     * Increases the speed of the Volvo240 depending on the given amount and trimFactor of the car.
     * The given amount can only be between 0 and 1.
     * @param amount specifies the amount with which to decrease the speed.
     */
    @Override
    public void brake(double amount){
        brake(speedFactor(), amount);
    }
}
