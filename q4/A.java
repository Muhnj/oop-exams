public class A implements X, Y {

    @Override
    public void a(String s) {
        System.out.println("Method a() received: " + s);
    }

    public static void main(String[] args) {
        A obj = new A();

        X.m();
        Y.m();

        System.out.println("W in X = " + X.W);
        System.out.println("W in Y = " + Y.W);

        obj.a("Hello");
        System.out.println("Square of 7 = " + obj.b(7));
    }
}
