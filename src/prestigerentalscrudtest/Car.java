/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prestigerentalscrudtest;

/**
 *
 * @author Chidera
 */
public class Car {
    private String vin;
    private String make;
    private String model;
    private int year;
    private String type;

    public Car(String vin, String make, String model, int year, String type) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }
    
    
    
}
