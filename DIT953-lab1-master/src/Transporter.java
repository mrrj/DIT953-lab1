import java.util.ArrayList;
import java.util.List;

/**
 * Dependency class used by classes that are transporters. An interface extending Movable has to be created for every
 * class depending on Transporter.
 * @param <T> the interface implemented by classes that can be transported by the dependent class (has to extend Movable).
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Transporter<T extends Movable> {
    private List<T> storage = new ArrayList<T>();
    private int max;

    private Mover mover;

    /**
     * Constructor for Transporter objects.
     * @param max the max amount of objects that can be stored.
     * @param mover the same Mover object used by dependent class.
     */
    public Transporter(int max, Mover mover) {
        this.max = max;
        this.mover = mover;
    }

    /**
     * Stores an object if the maximum capacity has not been reached.
     * @param t the object to be stored.
     */
    public void load(T t) {
        if (storage.size() < max) {
            storage.add(t);
        }
        else {
            System.out.println("Maximum storage capacity has been reached.");
        }
    }

    /**
     * @return the number of objects currently being stored.
     */
    public int getN() {
        return storage.size();
    }

    /**
     * @return one object storage.
     */
    public T unload(int i){ return storage.remove(i);}

    /**
     * Changes the xy-coordinates of the dependent object and all stored objects.
     */
    public void move() {
        mover.move();

        for (Movable m : storage) {
            m.setX(mover.getX());
            m.setY(mover.getY());
        }
    }
}
