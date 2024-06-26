
public class ShortWordFilter implements Filter{
    @Override
    public boolean accept(Object x) {
        String p = (String) x;
        return p.length() < 5;
    }
}