import java.awt.*;

/**
 * Represents a car.
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
  */
public abstract class car implements Movable, IFerryTransportable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double weight;

    private Mover mover = new Mover();

    /**
     * Constructor for subclasses of car.
     * @param nrDoors specifies the number of doors of the car.
     * @param color specifies the color of the car.
     * @param enginePower specifies the engine power of the car.
     * @param modelName specifies the model name of the car.
     */
    public car(int nrDoors, Color color, double enginePower, String modelName, double weight) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
        this.weight = weight;
    }

    /**
     * Changes the position of the car.
     */
    public void move() {
        mover.move();
    }

    /**
     * Changes the direction of the car by 45 degrees in the positive direction.
     */
    public void turnLeft() {
        mover.turnLeft();
    }

    /**
     * Changes the direction of the car by 45 degrees in the negative direction.
     */
    public void turnRight() {
        mover.turnRight();
    }

    /**
     * Changes the direction of the car.
     * @param direction specifies the direction.
     */
    public void setDirection(double direction){
        mover.setDirection(direction);
    }

    /**
     * @return the current direction of the car.
     */
    public double getDirection()
    {
        return mover.getDirection();
    }

    /**
     * @return the current x-coordinate of the car.
     */
    public double getX(){
        return mover.getX();
    }

    /**
     * @return the current y-coordinate of the car.
     */
    public  double getY(){
        return  mover.getY();
    }

    /**
     * Changes the x-coordinate of the car.
     * @param x the new x-coordinate.
     */
    public void setX(double x){
        mover.setX(x);
    }

    /**
     * Changes the y-coordinate of the car.
     * @param y the new y-coordinate.
     */
    public void setY(double y){
        mover.setY(y);
    }
    /**
     * @return the number of doors on the car.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * @return the cars enginge power.
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * @return the current speed of the car.
     */
    public double getCurrentSpeed(){
        return mover.getCurrentSpeed();
    }

    /**
     * Changes the current speed of the car.
     * @param speed specifies the new speed.
     */
    private void setCurrentSpeed(double speed) {
        mover.setCurrentSpeed(speed);
    }

    /**
     * @return the color of the car.
     */
    public Color getColor(){
        return color;
    }

    /**
     * Changes the color of the car.
     * @param clr specifies the color.
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets the current speed of the car to 0.1.
     */
    public void startEngine(){
        mover.setCurrentSpeed(0.1);
    }

    public double getWeigth(){
        return weight;
    }
    /**
     * Sets the speed of the car to 0.
     */
    public void stopEngine(){
        mover.setCurrentSpeed(0);
    }

    /**
     * @param factor individual factor from sub classes.
     * @return the current speed factor of the car.
     */
    public double speedFactor(double factor) {
        return enginePower * 0.01 * factor;
    }

    /**
     * Increments the speed of the car.
     * @param factor speed factor of car.
     * @param amount amount to increase speed with.
     */
    private void incrementSpeed(double factor, double amount) {
        double newSpeed = mover.getCurrentSpeed() + factor * amount;
        newSpeed = Math.min(newSpeed, enginePower);
        setCurrentSpeed(newSpeed);
    }

    /**
     * Decrements the speed of the car.
     * @param factor speed factor of car.
     * @param amount amount to decrease speed with.
     */
    private void decrementSpeed(double factor, double amount){
        double newSpeed = mover.getCurrentSpeed() + factor * -amount;
        newSpeed = Math.max(newSpeed, 0);
        setCurrentSpeed(newSpeed);
    }

    /**
     * Calculates the distance from a given car.
     * @param m the object to calculate distance to.
     * @return the distance between the given car and the caller.
     */
    public double distanceFrom(Movable m) {
        double x1 = getX();
        double y1 = getY();
        double x2 = m.getX();
        double y2 = m.getY();

        double deltaX = x2 - x2;
        double deltaY = y2 - y1;
        double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        return distance;
    }

    /**
     * Increases speed of the car.
     * Used in classes without a speedFactor method.
     * @param amount specifies the amount with which to increase speed.
     */
    public void gas(double amount) {
        gas(1,amount);
    }

    /**
     * Decrease the speed of the car.
     * Used in classes without a speedFactor method.
     * @param amount specifies the amount with which to decrease the speed.
     */
    public void brake(double amount) {
        brake(1,amount);
    }

    /**
     * Accelerates car.
     * @param factor speed factor.
     * @param amount amount to increase speed with.
     */
    public void gas(double factor, double amount) {
        if(!(amount < 0) && !(amount > 1)) {
            incrementSpeed(factor, amount);
        }
    }
    /**
     * Deaccelerates car
     * @param factor speed factor.
     * @param amount amount to decrease speed with.
     */
    public void brake(double factor, double amount) {
        if (!(amount < 0) && !(amount > 1)) {
            decrementSpeed(factor, amount);
        }
    }

    /**
     * @return a reference to the cars mover object.
     */
    public Mover getMover() {
        return mover;
    }
}
