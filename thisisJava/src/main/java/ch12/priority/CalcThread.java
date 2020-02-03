package ch12.priority;

public class CalcThread extends Thread {
    public CalcThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) { }
        System.out.println(getName());
    }
}
