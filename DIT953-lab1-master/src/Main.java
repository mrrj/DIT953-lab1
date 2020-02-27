import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[]args){
        Saab95 s = new Saab95();
        car v = new Volvo240();
        car sc = new Scania();

        s.setTurboOn();

        s.gas(1);
        v.gas(1);
        sc.gas(1);

        s.move();
        v.move();
        sc.move();

        System.out.println("Saab - x is: " + s.getX() + ". y is: " + s.getY()+ ".speed: " + s.getCurrentSpeed());
        System.out.println("Volvo - x is: " + v.getX() + ". y is: " + v.getY() + ". Speed: " + v.getCurrentSpeed());
        System.out.println("Scania - x is: " + sc.getX() + ". y is: " + sc.getY() + ". Speed: " + sc.getCurrentSpeed());

    }
}
