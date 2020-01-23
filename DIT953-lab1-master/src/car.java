import java.awt.*;

public abstract class car implements Movable{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public double x = 0;
    public double y = 0;
    public double direction = 0;

    public car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    public void move() {
        double dx = Math.cos(getDirection())*getCurrentSpeed();
        double dy = Math.sin(getDirection())*getCurrentSpeed();
        setX(getX() + dx);
        setY(getY() + dy);
    }
    public void turnLeft() {
        setDirection(getDirection() + 45);
        if(getDirection() >= 360)
        {
            setDirection(0) ;
        }
    }
    public void turnRight() {
        setDirection(getDirection() - 45);
        if(getDirection() <= -360)
        {
            setDirection(0) ;
        }
    }

    public void setDirection(double direction){
        this.direction = direction;
    }
    public double getDirection()
    {
        return direction;
    }

    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public  double getY(){
        return  y;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }

}
