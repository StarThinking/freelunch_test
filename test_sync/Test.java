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
        
            long i;

            for(i = 0; i < 1000000000;) {
                    i++;
            }
        }
    }

    public void run() {
        while (true) {
            func();

  //          try {
            long i;

            for(i = 0; i < 1000000000; ) {
                i++;
            }
                //Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

