// Car.java

class Vehicle
{
   private String make;
   private String model;
   private int year;
   Vehicle(String make, String model, int year)
   {
      this.make = make;
      this.model = model;
      this.year = year;
   }
   String getMake()
   {
      return make;
   }
   String getModel()
   {
      return model;
   }
   int getYear()
   {
      return year;
   }
}
class Car extends Vehicle
{
   private int numWheels;
   Car(String make, String model, int year, int numWheels)
   {
      super(make, model, year);
      this.numWheels = numWheels;
   }
   public static void main(String[] args)
   {
      Car car = new Car("Ford", "Fiesta", 2009, 4);
      System.out.println("Make = " + car.getMake());
      System.out.println("Model = " + car.getModel ());
      System.out.println("Year = " + car.getYear ());
      // Normally, you cannot access a private field via an object
      // reference. However, numWheels is being accessed from 
      // within a method (main()) that is part of the Car class.
      System.out.println("Number of wheels = "+car.numWheels);
   }
}
