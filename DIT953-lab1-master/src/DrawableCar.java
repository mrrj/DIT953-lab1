import java.awt.image.BufferedImage;

public class DrawableCar {

    car car;
    BufferedImage image;

    public DrawableCar(car car, BufferedImage image) {
        this.car = car;
        this.image = image;
    }

    public car getCar() {
        return car;
    }

    public BufferedImage getImage() {
        return image;
    }

}
