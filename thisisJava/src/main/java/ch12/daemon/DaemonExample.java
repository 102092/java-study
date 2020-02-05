package ch12.daemon;

public class DaemonExample {

    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println("메인스레드 종료");
    }
}
