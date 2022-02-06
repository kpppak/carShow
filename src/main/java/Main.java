public class Main {
    public static void main(String[] args) {
        final AutoShow autoShow = new AutoShow();
        final Seller seller = new Seller();

        Runnable selling = autoShow::sellTheCar;
        Runnable receiving = autoShow::receiveTheCar;

        ThreadGroup threadGroup = new ThreadGroup("main group");

        new Thread(threadGroup, selling, "Client1").start();
        new Thread(threadGroup, selling, "Client2").start();
        new Thread(threadGroup, selling, "Client4").start();
        new Thread(null, receiving, "Automotive Producer").start();
        new Thread(threadGroup, selling, "Client3").start();
        new Thread(threadGroup, selling, "Client4").start();
        new Thread(threadGroup, selling, "Client4").start();
    }
}
