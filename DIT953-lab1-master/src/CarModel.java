import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CarModel {

    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    //CarView frame;
    // A list of cars, modify if needed
    ArrayList<car> cars = new ArrayList<>();

    //Will be notified of changes
    private List<CarModelObserver> observers = new ArrayList<>();



    public void addObserver(CarModelObserver observer){
        observers.add(observer);
    }

    public void removeObserver(CarModelObserver observer){
        //remove from list
    }

    //can be private?
    public void notifyObservers(car c, int i) {
        for (CarModelObserver o : observers) {
            o.notifyMovement(c, i);
        }
    }



    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                car c = cars.get(i);
                c.move();

                //change direction if car hits a wall
                //if ((c.getX()+100) >= frame.getMaxX()) c.setDirection(Math.PI);
                //if (c.getX() <= 0) c.setDirection(0);

                //int x = (int) Math.round(c.getX());
                //int y = (int) Math.round(c.getY());

                //use observer
                notifyObservers(c, i);
                //moved to carView
                //frame.drawPanel.moveit(i, x, y);
                // repaint() calls the paintComponent method of the panel
                //frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (car c : cars) {
            c.gas(gas);
            System.out.println(c.getCurrentSpeed());
        }
    }

    void brake(int amount) {
        double brake = ((double) amount / 100);
        for (car c : cars) {
            c.brake(brake);
        }
    }

    void turboOn() {
        for (car c : cars) {
            if (c instanceof Saab95){
                Saab95 s = (Saab95) c;
                s.setTurboOn();
            }
        }
    }

    void turboOff() {
        for (car c : cars) {
            if (c instanceof Saab95) {
                Saab95 s = (Saab95) c;
                s.setTurboOff();
            }
        }
    }

    void liftBed() {
        for (car c : cars) {
            if (c instanceof Scania) {
                Scania s = (Scania) c;
                s.raise(35);
            }
        }
    }

    void lowerBed() {
        for (car c : cars) {
            if (c instanceof Scania) {
                Scania s = (Scania) c;
                s.lower(35);
            }
        }
    }

    void startAll() {
        for (car c : cars) {
            c.startEngine();
        }
    }

    void stopAll() {
        for (car c : cars) {
            c.stopEngine();
        }
    }


}
