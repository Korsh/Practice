package HomeWork1;

import java.util.Random;

/**
 * Created by arzhanov on 10/29/15.
 */
public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Delivery[] deliveryReport = new Delivery[100];

        for(int i=0; i<100; i++) {
            deliveryReport[i] = new Delivery(random.nextInt(2000),random.nextInt(180),random.nextInt(4000));
        }
        printDeliveryReport(deliveryReport);
        deliveryReport = sortDeliveryReport(deliveryReport);
        printDeliveryReport(deliveryReport);

    }

    public static Delivery[] sortDeliveryReport(Delivery[] deliveryReport) {
        int minimalValue;
        for (int i=0; i<deliveryReport.length; i++) {
            minimalValue = i;
            for(int j=i+1; j<deliveryReport.length; j++) {
                if(deliveryReport[j].getTotalPrice() < deliveryReport[minimalValue].getTotalPrice()) {
                    minimalValue = j;
                }
            }
            if(i != minimalValue) {
                Delivery tmp = deliveryReport[i];
                deliveryReport[i] = deliveryReport[minimalValue];
                deliveryReport[minimalValue] = tmp;
            }
        }
        return  deliveryReport;
    }

    static public void printDeliveryReport(Delivery[] deliveryReport) {
        System.out.println("№ | Distance | Speed | Capacity | PricePerKilo | TotalPrice");
        for(int i=0; i<100; i++) {
            System.out.println(i+1+" | "+deliveryReport[i].getDistance()+" | "+deliveryReport[i].getSpeed()+" | "+deliveryReport[i].getCapacity()+" | "+deliveryReport[i].getPricePerKilo()+" | "+deliveryReport[i].getTotalPrice());
        }
    }

}
