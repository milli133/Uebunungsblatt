package BSP3;

public abstract class Worker {
    protected String name;
    protected boolean shouldRun;

    public Worker(String name, boolean shouldRun) {
        this.name = name;
        this.shouldRun = true;
    }

    protected abstract void work();

    protected void printStarted() {
        System.out.println(this.name + " wurde gestartet...");
    }

    protected void printStopped() {
        System.out.println(this.name + " wurde gestoppt...");
    }

    public void stopWorker() {
        shouldRun = false;
    }
}
