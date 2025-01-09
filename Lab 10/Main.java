class AA {
    synchronized void foo(BB b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered AA.foo");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("AA Interrupted");
        }
        System.out.println(name + " trying to call BB.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside AA.last");
    }
}

class BB {
    synchronized void bar(AA a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered BB.bar");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("BB Interrupted");
        }
        System.out.println(name + " trying to call AA.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside BB.last");
    }
}

class Deadlock implements Runnable {
    AA a = new AA();
    BB b = new BB();

    Deadlock() {
        Thread.currentThread().setName("MainThread");
        Thread t = new Thread(this, "RacingThread");
        t.start();

        a.foo(b); // Get lock on AA in the main thread.
        System.out.println("Back in main thread");
    }

    public void run() {
        b.bar(a); // Get lock on BB in the other thread.
        System.out.println("Back in other thread");
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}
