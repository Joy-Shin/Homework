package test;

public class Sunny {
    public static void main(String[] args) {
        OverrideTest o1 = new OverrideTest("Sunny");
        OverrideTest o2 = new OverrideTest("Sunny");

        if (o1.equals(o2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

class OverrideTest{
    String a;

    public OverrideTest(String a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OverrideTest that = (OverrideTest) o;

        return a != null ? a.equals(that.a) : that.a == null;
    }

    @Override
    public int hashCode() {
        return a != null ? a.hashCode() : 0;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
