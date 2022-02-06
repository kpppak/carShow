public class Seller {
    Object seller;
    final int TIME_TO_GET_CAR = 2000;
    final int TIME_TO_SELL_CAR = 1500;
    final int CARS_QUOTA = 7;

    private static AutoShow autoShow;

    public Seller(AutoShow autoShow) {
        this.autoShow = autoShow;
    }

    public Seller() { }

    public synchronized void receiveAuto() {
        for (int i = 0; i < CARS_QUOTA; i++){
            try {
                Thread.sleep(TIME_TO_GET_CAR);
                autoShow.getAutos().add(new Car());
                System.out.println("автосалон получил новый автомобиль");
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sellAuto() {
        System.out.println("покупатель зашел в автосалон");
        try {
            if (autoShow.getAutos().size() == 0) {
                System.out.println("нет автомобилей ");
                wait();
            }
            Thread.sleep(TIME_TO_SELL_CAR);
            System.out.println("Покупатель уехал на новом авто");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        autoShow.getAutos().remove(0);
        notifyAll();
    }
}
