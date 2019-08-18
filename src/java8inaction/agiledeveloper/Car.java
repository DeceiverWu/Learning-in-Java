package java8inaction.agiledeveloper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-08-11
 * Time: 14:04
 */
public class Car {

    private String make;
    private String model;
    private int year;

    public Car(String theMake, String theModel, int yearOfMake) {
        make = theMake;
        model = theModel;
        year = yearOfMake;
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
}
