package java8inaction.agiledeveloper;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-08-11
 * Time: 14:09
 */
public class CarTest {

    @Test
    public static List<String> getModelsAfter2000UsingFor(List<Car> cars) {
        //List<Car> carsSortedByYear = new ArrayList<>();
        //
        //for (Car car : cars) {
        //    if (car.getYear() > 2000) {
        //        carsSortedByYear.add(car);
        //    }
        //}
        //
        //Collections.sort(carsSortedByYear, new Comparator<Car>() {
        //
        //    @Override
        //    public int compare(Car o1, Car o2) {
        //        return new Integer(o1.getYear()).compareTo(o2.getYear());
        //    }
        //});
        //
        //List<String> models = new ArrayList<>();
        //for (Car car : carsSortedByYear) {
        //    models.add(car.getModel());
        //}
        //
        //return models;

        return cars.stream()
                .filter(car -> car.getYear() > 2000)
                .sorted(Comparator.comparing(Car::getYear))
                .map(Car::getModel)
                .collect(Collectors.toList());
    }
}
