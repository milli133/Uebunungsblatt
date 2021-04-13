package BSP3;

import java.io.*;
import java.util.ArrayList;

public class FileReadWorker extends Worker implements Runnable {

    private String path;
    private ArrayList<String> lines = new ArrayList<>();

    public FileReadWorker(String name, boolean shouldRun) {
        super(name, shouldRun);
        this.path = "src/BSP3/data/times.txt";
    }

    @Override
    protected void work() {

        System.out.println(name + " wurde gestartet...");
        try {
            FileReader fr = new FileReader(new File(path));
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("read: " + line);
                lines.add(line);
                Thread.sleep(500);
            }

            printStopped();

            if (!shouldRun) {
                stopWorker();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        work();
    }
}
