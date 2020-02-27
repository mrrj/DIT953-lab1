
/**
 * Dependency class used by classes that can move.
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Mover {
    private double x = 0;
    private double y = 0;
    private double direction = 0;
    private double turnAngle = Math.PI/4;
    private double currentSpeed = 0;

    /**
     * Changes the current speed.
     * @param speed the new speed of the object.
     */
    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    /**
     * @return the current speed.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Turns 45 degrees in positive direction.
     */
    public void turnLeft() {
        direction += turnAngle;
        if(direction >= 2 * Math.PI)
        {
            direction = 0;
        }
    }

    /**
     * Turns 45 degrees in negative direction.
     */
    public void turnRight() {
        direction -= turnAngle;
        if(direction <= -2 * Math.PI)
        {
            direction = 0;
        }
    }

    /**
     * Changes the direction to a given value.
     * @param direction the new direction
     */
    public void setDirection(double direction) {
        this.direction = direction;
    }

    /**
     * @return the current direction.
     */
    public double getDirection() {
        return direction;
    }

    /**
     * Changes the xy-coordinates of the object based on the current speed and direction.
     */
    public void move() {
        double dx = Math.cos(direction)*currentSpeed;
        double dy = Math.sin(direction)*currentSpeed;
        x += dx;
        y += dy;
    }

    /**
     * @return the x-coordinate of the object.
     */
    public double getX(){
        return x;
    }

    /**
     * @return the y-coordinate of the object.
     */
    public  double getY(){
        return  y;
    }

    /**
     * Changes the x-coordinate to a given value.
     * @param x the new x-coordinate.
     */
    public void setX(double x){
        this.x = x;
    }

    /**
     * Changes the y-coordinate to a given value.
     * @param y the new y-coordinate.
     */
    public void setY(double y){
        this.y = y;
    }
}