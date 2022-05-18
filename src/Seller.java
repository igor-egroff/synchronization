class Seller {
    final private CarManufacturer carManufacturer;
    private static final int TIME_OF_CAR_SALE = 1000;
    private static final int CAR_PRODUCTION_TIME = 30;

    public Seller(CarManufacturer carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public synchronized void receiveCar() {
        try {
            Thread.sleep(CAR_PRODUCTION_TIME);
            carManufacturer.getCars().add(new Car());
            System.out.println("Toyota выпустил 1 авто");
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Car carBuyer() {
        try {
            System.out.println("Продавец продает автомобиль   " + Thread.currentThread().getName());
            while (carManufacturer.getCars().size() == 0) {
                System.out.println("Продавец: Не могу продать - авто нет!");
                wait();
            }
            Thread.sleep(TIME_OF_CAR_SALE);
            System.out.println("уехал на новеньком авто  " + Thread.currentThread().getName());
        } catch
        (InterruptedException e) {
            e.printStackTrace();
        }
        return carManufacturer.getCars().remove(0);
    }
}
