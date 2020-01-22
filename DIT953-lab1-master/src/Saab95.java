import java.awt.*;
import java.lang.Math;

public class Saab95 extends car{

    public boolean turboOn;

    @Override
    public void move() {
        double dx = Math.sin(getDirection())*getCurrentSpeed();
        double dy = Math.cos(getDirection())*getCurrentSpeed();
        setX(getX()+dx);
        setY(getY()+dy);
    }

    @Override
    public void turnLeft() {
        setDirection(getDirection()+45);
        if(getDirection()>= 360)
        {
            setDirection(0) ;
        }
    }

    @Override
    public void turnRight() {
        setDirection(getDirection()-45);
        if(getDirection()>= 360)
        {
            setDirection(0) ;
        }
    }

    public Saab95() {
        super(2,Color.red,125,"Saab95");
        turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
