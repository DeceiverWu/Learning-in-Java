package java8inaction.common;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-06
 * Time: 13:56
 */
public class Person {

    private Optional<Car> car;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public Optional<Car> getCar() {
        return car;
    }
}
