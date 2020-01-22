public class Main {
    public static void main(String[]args){
        Saab95 s = new Saab95();
        s.incrementSpeed(10);
        s.move();
        s.turnLeft();
        System.out.println("x is " + s.getX() + "\n y is " + s.getY());


    }
}
