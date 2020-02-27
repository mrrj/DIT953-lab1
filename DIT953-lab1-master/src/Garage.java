import java.util.ArrayList;
import java.util.List;

/**
 * Represents a garage.
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Garage <C extends car>{
    private int maxCars;
    private List<C> cars = new ArrayList<C>();

    /**
     * Constructor for Garage objects.
     * @param maxCars the max amount of cars the garage can hold at one time.
     */
    public Garage(int maxCars) {
        this.maxCars = maxCars;
    }

    /**
     * Adds a given car to the garage.
     * @param c the car to be added to the garage.
     */
    public void addCar(C c){
       if(cars.size()<maxCars){
           cars.add(c);
       }
    }

    /**
     * @param index specifies the car to remove from storage.
     * @return the car with the given index.
     */
    public C removeCar(int index) {
        if (cars.size() > index) {
            return cars.remove(index);
        }
        else {
            System.out.println("Not enough cars in storage.");
            return null;
        }
    }

    /**
     * @return the number of cars currently being stored.
     */
    public int nCars() {
        return cars.size();
    }
}
