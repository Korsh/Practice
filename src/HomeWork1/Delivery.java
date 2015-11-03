package HomeWork1;

/**
 * Created by arzhanov on 11/2/15.
 */
public class Delivery {

    private int capacity;
    private int speed;
    private int distance;
    private float pricePerKilo = 0;

    public Delivery(int distance, int speed, int capacity) {
        this.capacity = capacity;
        this.speed = speed;
        if(speed == 0 || speed < 50) {
            this.speed = 120;
        }
        this.distance = distance;
    }

    public float getDistance() {
        return this.distance;
    }

    public float getSpeed() {
        return this.speed;
    }

    public  float getCapacity() {
        return this.capacity;
    }

    public float getTotalPrice() {
        return Float.parseFloat(String.format("%.2f", getPricePerKilo()*capacity));
    }

    public float getPricePerKilo() {
        if(this.pricePerKilo == 0) {
            float pricePerKilo = 0;
            for(int i=0; i<distance; i+=100) {
                pricePerKilo += 0.1;
            }

            for(int i=30; i<distance/speed; i +=15) {
                pricePerKilo += 0.05;
            }
            this.pricePerKilo = Float.parseFloat(String.format("%.2f", pricePerKilo));
        }

        return this.pricePerKilo;
    }


}
