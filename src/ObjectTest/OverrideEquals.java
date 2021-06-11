package ObjectTest;

/**
 * @author: minmengtao
 * @date: 2021/6/11
 */
class Cycle {
    private int r;

    Cycle(int r) {
        this.r = r;
    }

    public double getArea() {
        return Math.PI * r * r;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cycle) {
            Cycle c = (Cycle) obj;
            return this.getR() == c.getR();
        }
        return super.equals(obj);
    }
}
public class OverrideEquals {
    public static void main(String[] args) {
        Cycle c1 = new Cycle(1);
        Cycle c2 = new Cycle(1);
        //Cycle c2 = c1;
        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));
    }
}
