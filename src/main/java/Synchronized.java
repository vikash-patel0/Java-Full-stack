class First {
    synchronized void display(String msg) {
        System.out.print("[ " + msg);
        try {
            Thread.sleep(1000); // simulate delay
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(" ]");
    }
}

class Second {
    String msg;
    First fobj;

    Second(First fp, String str) {
        fobj = fp;
        msg = str;
        start();
    }

    public void run() {
        fobj.display(msg);
    }
}
public class Synchronized {
    public static void main(String[] args) {
        First fnew = new First();
        new Second(fnew, "Welcome");
        new Second(fnew, "new");
        new Second(fnew, "Programmer");
    }
}
