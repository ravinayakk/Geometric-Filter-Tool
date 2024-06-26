import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectangleFilter implements Filter {
    private double perimeter;

    public BigRectangleFilter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle r = (Rectangle) x;
            double perimeter = 2 * (r.height + r.width);
            return perimeter > 10;
        }
        return false;
    }

    public static ArrayList<Object> collectAll(ArrayList<Object> objects, Filter w) {
        ArrayList<Object> obj = new ArrayList<>();

        for (Object x : objects) {
            if (w.accept(x)) {
                obj.add(x);
            }
        }
        return obj;
    }
}