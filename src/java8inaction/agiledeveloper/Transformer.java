package java8inaction.agiledeveloper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-08-12
 * Time: 18:52
 */
@FunctionalInterface
public interface Transformer<T> {
    T transform(T input);
}
