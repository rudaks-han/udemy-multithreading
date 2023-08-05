package ex4;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("Intentional Exception");
        });

        thread.setName("Misbehaving thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Critical error happened in thread : " + t.getName()
                + " the error is " + e.getMessage());
            }
        });
        thread.start();
    }
}
