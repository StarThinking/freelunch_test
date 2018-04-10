import java.util.ArrayList;
import java.util.List;

public class Test {
    private static int num = 10;

    public static void main(String[] args) throws InterruptedException { 
        List<Thread> mythreads = new ArrayList<Thread>();
        int i;

        for (i=0; i<num; i++) {
            Thread t = new MyThread();
            t.start();
            mythreads.add(t);

        }
        
        for (i=0; i<num; i++) {
            mythreads.get(i).join();

        }
    }
}

class MyThread extends Thread {
    private static Object mutex = new Object();

    public void func() {
        synchronized (MyThread.mutex) {
            System.out.println("synchronized func in thread " + Thread.currentThread().getId());
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        while (true) {
            func();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

