package designpatterns.builder;

import designpatterns.common.Person;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 15:45
 */
public interface PersonBuilder {

    void buildHead();
    void buildBody();
    void buildFoot();
    Person buildPerson();
}
