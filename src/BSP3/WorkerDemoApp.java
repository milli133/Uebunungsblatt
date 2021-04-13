package BSP3;

public class WorkerDemoApp {
    public static void main(String[] args) {
        Thread tpw = new Thread(new TimePrintWorker("TPW", true));
        Thread frw = new Thread(new FileReadWorker("FRW", true));

        tpw.start();
        frw.start();

        try {
            frw.join();
            tpw.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
