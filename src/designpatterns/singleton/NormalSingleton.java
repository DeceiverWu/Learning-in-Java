package designpatterns.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 15:36
 */
public class NormalSingleton {

    private static NormalSingleton instance = null;

    private NormalSingleton() {

    }

    public static NormalSingleton getInstance() {
        if (instance == null) {
            instance = new NormalSingleton();
        }
        return instance;
    }
}
