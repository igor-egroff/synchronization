public class Main {
    private static final int NUMBER_OF_BUYERS = 3;

    public static void main(String[] args) {
        final CarManufacturer carManufacturer = new CarManufacturer();

        for (int i = 1; i < NUMBER_OF_BUYERS; i++) {
            new Thread(null, carManufacturer::carBuyer, "Покупатель " + i).start();
        }

        new Thread(null, carManufacturer::сarManufacturing, "Производство автомобиля").start();

    }
}