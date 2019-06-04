package designpatterns.builder;

import designpatterns.common.Computer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 15:46
 */
public class ComputerDirection {

    public Computer buildComputer(ComputerBuilder builder){
        builder.buildCpu();
        builder.buildHd();
        builder.buildBios();
        builder.buildRam();
        return builder.buildComputer();
    }
}
