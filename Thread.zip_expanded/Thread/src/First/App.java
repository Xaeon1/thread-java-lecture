package First;

public class App {
    private static int counter = 0;

    public static void main(String[] args) {
        process();
        System.out.println(counter);
    }

    public static void process() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (App.class) {
                        counter++;
                    }
                    System.out.println("t1: " + counter);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {

                    synchronized (App.class) {
                        counter++;
                    }
                    System.out.println("t2: " + counter);
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
