import java.util.ArrayList;
import java.util.List;

public class CarManufacturer {

    //  Продавец
    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>(10);


    public Car carBuyer() {
        System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
        return seller.carBuyer();

    }

    public void сarManufacturing() {
        try {
            while (cars.size() < 2) { //после отгрузки всеех заказов, создаем минимальный запас авто и останавлмваем поток
                Thread.sleep(3000);
                seller.receiveCar();
            }
        } catch (InterruptedException err) {
        }

    }

    public List<Car> getCars() {
        return cars;
    }

}
