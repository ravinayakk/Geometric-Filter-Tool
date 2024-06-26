import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {

    public static void main(String[] args) {
        ArrayList<Object> rectangles = new ArrayList<Object>();

        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(2, 3));
        rectangles.add(new Rectangle(5, 2));
        rectangles.add(new Rectangle(7, 8));
        rectangles.add(new Rectangle(9, 8));
        rectangles.add(new Rectangle(3, 4));
        rectangles.add(new Rectangle(5, 8));
        rectangles.add(new Rectangle(7, 8));
        rectangles.add(new Rectangle(9, 10));

        rectangles = BigRectangleFilter.collectAll(rectangles, new BigRectangleFilter(5));

        System.out.println("Perimeter of Big Rectangles from the Array List: ");
        for (Object x : rectangles) {
            Rectangle rectangle = (Rectangle) x;
            double perimeter = 2 * (rectangle.getHeight() + rectangle.getWidth());
            System.out.println("Perimeter: " + perimeter);
        }
    }
}