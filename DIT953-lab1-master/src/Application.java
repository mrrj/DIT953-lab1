public class Application {
    /*
     *Represents application. "startar, sammanför och skapar komponenten"
     */

    public static void main(String[] args){
        //TODO: Tie it all together
        CarModel cm = new CarModel();
        CarView cw = new CarView("CarSim 1.0",  cm);
        CarController cc = new CarController(cm, cw);



        cm.cars.add(new Volvo240());
        cm.cars.add(new Saab95());
        cm.cars.add(new Scania());

        cm.addObserver(cw);

        //initCars(cc.cars);


        // Start the timer
        cm.timer.start();
    }

}
