import java.awt.*;
import java.util.Stack;

/**
 * Represents a truck used for transporting cars.
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Truck extends car{
    private boolean rampIsUp = true;
    private Transporter<ITruckTransportable> transporter;
    private double maxWeight;


    /**
     * Constructor for Truck objects.
     */
    public Truck(int maxCapacity, double maxWeight) {
        super(2, Color.red,100, "Truck", 15000);
        transporter = new Transporter<ITruckTransportable>(maxCapacity, getMover());
        this.maxWeight = maxWeight;
    }

    /**
     * Loads a car onto the truck.
     * A car can only be loaded if its weight is not above 1500 kg, the ramp of the truck is down, the car is within
     * 2 length units from the truck, and the given car is not the truck itself. The truck can hold a maximum of 10 cars
     * at one time.
     * @param c the car to be loaded onto the truck.
     */
    public void load(car c){
        if(isLoadable(c))
        {
            transporter.load( (ITruckTransportable) c);
        }
    }

    /**
     * Checks if a given car can be loaded onto truck at current moment.
     * @param c the car to be loaded.
     * @return true if the car can be loaded, else false.
     */
    private boolean isLoadable(car c) {
        if (!(c instanceof ITruckTransportable)) return false;
        if (c.getWeigth() > maxWeight) return false;
        if (transporter.getN() > 10) return false;
        if (rampIsUp) return false;
        if (distanceFrom(c) > 2) return false;
        if (c == this) return false;
        return true;
    }

    /**
     * Unloads a single car from the truck.
     * Can only be done if the ramp is lowered and the truck is not already empty.
     */
    public car unload(){
        if(readyToUnload())
        {
            int i = transporter.getN() - 1;
            car c = (car) transporter.unload(i);
            c.setX(getX()+1);
            c.setY(getY()+1);
            return c;
        }
        return null;
    }

    /**
     * Checks if truck can unload.
     * @return true if truck can unload, else false.
     */
    public boolean readyToUnload(){
        if(rampIsUp){
            System.out.println("Cannot unload while ramp is up");
            return false;
        }
        if(transporter.getN() < 0 ) {
            System.out.println("No cars to unload");
            return false;
        }
        return true;
    }

    /**
     * Raises the ramp of the truck.
     */
    public void raise()
    {
        rampIsUp = true;
    }

    /**
     * Lowers the ramp of the truck.
     * Can only be done if the truck is not moving.
     */
    public void lower(){
        if(getCurrentSpeed()== 0){
            rampIsUp = false;
        }
    }

    /**
     * Changes the position of the truck and all cars currently being transported.
     */
    @Override
    public void move() {
        transporter.move();
    }

    /**
     * Increases the speed of the
     * @param amount specifies the amount with which to increase speed.
     */
    @Override
    public void gas(double amount) {
        if(rampIsUp) {
            super.gas(amount);
        }
        else {
            System.out.println("Cannot increase speed while ramp is down.");
        }
    }

}
