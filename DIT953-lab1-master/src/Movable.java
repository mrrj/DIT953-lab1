/**
 * Interface for something movable.
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public interface Movable {
    void move();
    void turnLeft();
    void turnRight();
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();
}
