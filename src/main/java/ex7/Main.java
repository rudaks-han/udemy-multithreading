package ex7;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new BlockThread());
        thread.start();
        thread.interrupt();
    }

    private static class BlockThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking thread");
            }
        }
    }
}
