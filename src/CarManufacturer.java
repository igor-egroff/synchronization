import java.util.ArrayList;
import java.util.List;

public class CarManufacturer {

    //  Продавец
    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>(10);


    public Car carBuyer() {
        synchronized (seller) {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            return seller.carBuyer();
        }
    }

    public void сarManufacturing() {
        seller.receiveCar();
    }

    public List<Car> getCars() {
        return cars;
    }

}
