package proxy;

import java.lang.reflect.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-21
 * Time: 17:39
 */
public class ProxyTest {

    public static void main(String[] args) throws Throwable {
        //proxyMethodOne();
        //proxyMethodTwo();
        proxyMethodThree();
    }

    public static void proxyMethodOne() throws Exception {
        Class<?> proxyClass = Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);
        Constructor<?> proxyClassConstructor = proxyClass.getConstructor(InvocationHandler.class);
        Calculator proxyCalculator = (Calculator)proxyClassConstructor.newInstance(new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                CalculatorImpl calculator = new CalculatorImpl();
                System.out.println("before invoke...");
                Object invoke = method.invoke(calculator, args);
                System.out.println(invoke);
                System.out.println("after invoke...");
                return invoke;
            }
        });

        proxyCalculator.add(1, 1);
    }

    //public static void proxyMethodTwo() throws Exception {
    //    Calculator calculator = new CalculatorImpl();
    //    Calculator proxy = (Calculator)getProxy(calculator);
    //    proxy.add(1, 2);
    //    proxy.subtract(2, 3);
    //}
    //
    //public static Object getProxy(Object target) throws Exception {
    //    Class<?> proxyClass = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
    //    Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
    //    Object instance = constructor.newInstance(new InvocationHandler() {
    //
    //        @Override
    //        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //            System.out.println("before invoke...");
    //            Object invoke = method.invoke(target, args);
    //            System.out.println(invoke);
    //            System.out.println("after invoke...");
    //            return invoke;
    //        }
    //
    //    });
    //
    //    return instance;
    //}

    public static void proxyMethodThree() throws Exception {
        Calculator calculator = new CalculatorImpl();
        Calculator proxy = (Calculator)getProxy(calculator);
        proxy.add(1, 2);

    }

    public static Object getProxy(Object obj) throws Exception {
        Object instance = Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before invoke...");
                        Object invoke = method.invoke(obj, args);
                        System.out.println(invoke);
                        System.out.println("after invoke...");
                        return invoke;
                    }

                });
        return instance;
    }
}
