package BSP3;

import java.util.Date;

public class TimePrintWorker extends Worker implements Runnable {

    public TimePrintWorker(String name, boolean shouldRun) {
        super(name, shouldRun);
    }

    @Override
    protected void work() {
        printStarted();

        while (super.shouldRun) {
            Date d = new Date();
            System.out.println(d.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printStopped();
        stopWorker();
    }

    @Override
    public void run() {
        work();
    }
}
