/**
 * Class A is defined for you.
 */
public class A
{
    public A() {}

    public void methodA1(int v) {
        System.out.println("methodA1 in A called with value " + v);
    }

    public void methodA2(int v) {
        System.out.println("methodA2 in A called with value " + v);
    }

    public void methodA3(int v) {
        System.out.println("methodA3 in A called with value " + v);
        methodA2(v + 10);
    }
}
