package BFS;

public class OverridingTest {
    public static void main(String[] args) {
        A a = new A();
        A ma = new B();
        a.shoot();
        ma.shoot();
    }
}

class A {
    void shoot() {
        System.out.println("아처");
    }
}

class B extends A {
    void shoot() {
        System.out.println("마아");
    }
}
