import java.util.ArrayList;

/**
 * Represents a Ferry used for transporting cars.
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Ferry implements Movable {
    private boolean rampIsUp = true;
    private double enginePower;
    private Transporter<IFerryTransportable> transporter;
    private Mover mover = new Mover();
    private double maxWeight;


    /**
     * Constructor for Ferry objects.
     * @param maxCapacity the maximum amount of cars that can be transported by ferry.
     * @param enginePower the engine power of the ferry.
     * @param maxWeight the maximum weight that a
     */
    public Ferry(int maxCapacity, double enginePower, double maxWeight) {
        transporter = new Transporter<IFerryTransportable>( maxCapacity, mover);
        this.enginePower = enginePower;
        this.maxWeight = maxWeight;
    }

    /**
     * Loads a given car onto the Ferry.
     * @param c the car to be loaded.
     */
    public void load(car c) {
        if (isLoadable(c)) {
            transporter.load(c);
        }
    }

    /**
     * Returns true if a given car can currently be laoded onto the ferry.
     * @param c the car to be loaded.
     * @return true if car can be loaded else false.
     */
    private boolean isLoadable(car c) {
        if (!(c instanceof  IFerryTransportable))
        if (c.getWeigth() > maxWeight) return false;
        if (rampIsUp) return false;
        if (c.distanceFrom(this) > 2) return false;
        return true;
    }

    /**
     * Unloads a single car from the ferry.
     * @return the unloaded car.
     */
    public IFerryTransportable unload() {
        if (transporter.getN() > 0) {
            return transporter.unload(0);
        }
        else {
            System.out.println("Storage is empty.");
            return null;
        }
    }

    /**
     * Raises the ramp of the ferry.
     */
    public void raise() {
        rampIsUp = true;
    }

    /**
     * Lowers the ramp of the ferry.
     */
    public void lower() {
        if (getCurrentSpeed() == 0) {
            rampIsUp = false;
        }
    }

    /**
     * @return the number of cars currently being transported.
     */
    public int nTransported() {
        return transporter.getN();
    }

    /**
     * Increases the speed if the given amount is between 0 and 1.
     * The speed cannot exceed the enginePower of the ferry.
     * @param amount specifies the amount with which to increase the speed.
     */
    public void gas(double amount) {
        if (rampIsUp && amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    private void incrementSpeed(double amount) {
        double newSpeed = mover.getCurrentSpeed() + amount;
        newSpeed = Math.min(newSpeed, enginePower);
        setCurrentSpeed(newSpeed);
    }

    /**
     * Decreases the speed if the given amount is between 0 and 1.
     * The speed cannot be lower than 0.
     * @param amount the amount with which to decrease the speed.
     */
    public void brake(double amount) {
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    private void decrementSpeed(double amount) {
        double newSpeed = mover.getCurrentSpeed() - amount;
        newSpeed = Math.max(newSpeed, 0);
        setCurrentSpeed(newSpeed);
    }

    /**
     * Sets speed to zero.
     */
    public void stopEngine() {
        mover.setCurrentSpeed(0);
    }

    private void setCurrentSpeed(double speed) {
        mover.setCurrentSpeed(speed);
    }

    /**
     * @return the current speed of the ferry.
     */
    public double getCurrentSpeed() {
        return mover.getCurrentSpeed();
    }

    /**
     * Changes the direction of the ferry to a given value.
     * @param direction the new direction
     */
    public void setDirection(double direction) {
        mover.setDirection(direction);
    }

    /**
     * @return the current direction of the ferry.
     */
    public double getDirection() {
        return mover.getDirection();
    }

    /**
     * @return the x-coordinate of the ferry.
     */
    public double getX() {
        return mover.getX();
    }

    /**
     * @return the y-coordinate of the ferry.
     */
    public double getY() {
        return mover.getY();
    }

    /**
     * Changes the x-coordinate of the ferry.
     * @param x the new x-coordinate.
     */
    public void setX(double x) {
        mover.setX(x);
    }

    /**
     * Changes the y-coordinate of the ferry.
     * @param y the new y-coordinate of the ferry.
     */
    public void setY(double y) {
        mover.setY(y);
    }

    /**
     * Changes the direction by 45 degrees in the negative direction.
     */
    public void turnRight() {
        mover.turnRight();
    }

    /**
     * Changes the direction by 45 degrees in the positive direction.
     */
    public void turnLeft() {
        mover.turnLeft();
    }

    /**
     * Changes the position of the ferry depending on the current speed and direction of the ferry.
     * Also changes the position of all cars currently being transported.
     */
    public void move() {
        transporter.move();
    }
}
