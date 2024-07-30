import image.Image;
import image.ProxyImage;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // The image is not loaded until display() is called
        image1.display();
        image1.display();

        image2.display();
    }
}