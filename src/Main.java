public class Main {
    public static void main(String[] args) {
        final CarManufacturer carManufacturer = new CarManufacturer();

        new Thread(null, carManufacturer::carBuyer, "Покупатель 1").start();
        new Thread(null, carManufacturer::carBuyer, "Покупатель 2").start();
        new Thread(null, carManufacturer::carBuyer, "Покупатель 3").start();
        new Thread(null, carManufacturer::сarManufacturing, "Производство автомобиля").start();

    }
}