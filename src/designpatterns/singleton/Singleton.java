package designpatterns.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 15:37
 */
public class Singleton {

    private static Singleton instance = null;

    private Singleton() {

    }

    public static final Singleton getInstance(){
        if (instance == null){
            synchronized (instance){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
