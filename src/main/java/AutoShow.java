import java.util.ArrayList;
import java.util.List;

public class AutoShow {
    final int CAPACITY = 10;

    final Seller seller = new Seller(this);

    List<Car> cars = new ArrayList<>(CAPACITY);

    public void sellTheCar(){
        synchronized (seller){
            seller.sellAuto();
        }
    }

    public void receiveTheCar(){
        synchronized (seller){
            seller.receiveAuto();
        }

    }

    public List<Car> getAutos() {
        return cars;
    }
}
