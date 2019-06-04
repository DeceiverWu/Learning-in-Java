package designpatterns.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 15:37
 */
public class StaticInnerSingleton {

    private static class LazyHolder {
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    private StaticInnerSingleton() {

    }

    public static final StaticInnerSingleton getInstance(){
        return LazyHolder.INSTANCE;
    }
}
