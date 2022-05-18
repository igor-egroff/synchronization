import java.util.ArrayList;
import java.util.List;

public class CarManufacturer {
    private static final int STOCK_CARS = 2; // минимальный запас авто
    private static final int CAR_PRODUCTION_TIME = 3000;

    //  Продавец
    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>();


    public Car carBuyer() {
        System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
        return seller.carBuyer();

    }

    public void сarManufacturing() {
        try {
            while (cars.size() < STOCK_CARS) { //после отгрузки всех заказов, создаем минимальный запас авто
                // и останавливаем поток
                Thread.sleep(CAR_PRODUCTION_TIME);
                seller.receiveCar();
            }
        } catch (InterruptedException err) {
        }

    }

    public List<Car> getCars() {
        return cars;
    }

}
