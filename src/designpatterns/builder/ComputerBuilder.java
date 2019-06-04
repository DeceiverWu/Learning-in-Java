package designpatterns.builder;

import designpatterns.common.Computer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 15:47
 */
public interface ComputerBuilder {

    void buildCpu();
    void buildHd();
    void buildRam();
    void buildBios();
    Computer buildComputer();
}
