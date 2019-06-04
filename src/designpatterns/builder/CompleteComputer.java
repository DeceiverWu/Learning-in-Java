package designpatterns.builder;

import designpatterns.common.Computer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 15:47
 */
public class CompleteComputer implements ComputerBuilder {

    private Computer computer;

    public CompleteComputer() {
        this.computer = new Computer();
    }

    @Override
    public void buildCpu() {
        computer.setCpu("set cpu...");
    }

    @Override
    public void buildHd() {
        computer.setHd("set hd...");
    }

    @Override
    public void buildRam() {
        computer.setRam("set ram...");
    }

    @Override
    public void buildBios() {
        computer.setBios("set bios...");
    }

    @Override
    public Computer buildComputer() {
        return computer;
    }
}
