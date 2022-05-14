class Seller {
    private CarManufacturer carManufacturer;

    public Seller(CarManufacturer carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public synchronized void receiveCar() {
        try {

            Thread.sleep(3000);

            carManufacturer.getCars().add(new Car());

            System.out.println("Toyota выпустил 1 авто");
            notify();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Car carBuyer() {
        try {
            System.out.println("Продавец продает автомобиль   " + Thread.currentThread().getName());
            while (carManufacturer.getCars().size() == 0) {
                System.out.println("Продавец: Не могу продать - авто нет!");
                new Thread(null, carManufacturer::сarManufacturing, "Производство автомобиля").start();
                wait();
            }
            Thread.sleep(1000);
           System.out.println("уехал на новеньком авто  " + Thread.currentThread().getName());
        } catch
        (InterruptedException e) {
            e.printStackTrace();
        }
        return carManufacturer.getCars().remove(0);
    }
}
