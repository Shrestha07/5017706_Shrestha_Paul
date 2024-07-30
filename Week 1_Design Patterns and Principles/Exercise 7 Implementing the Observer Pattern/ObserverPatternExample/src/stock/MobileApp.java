package stock;

public class MobileApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("Mobile App Notification: Stock price updated to $" + stockPrice);
    }
}