package stock;

public class WebApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("Web App Notification: Stock price updated to $" + stockPrice);
    }
}