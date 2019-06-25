package effectivejava.item3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-24
 * Time: 14:35
 */
public class StaticFactoryElvis {

    private static final StaticFactoryElvis INSTANCE = new StaticFactoryElvis();

    private StaticFactoryElvis() { }

    public static StaticFactoryElvis getINSTANCE() {
        return INSTANCE;
    }
}
