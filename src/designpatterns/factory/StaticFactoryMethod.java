package designpatterns.factory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 15:40
 */
public class StaticFactoryMethod {

    interface Sender {
        public void send();
    }

    class  SmsSender implements Sender {

        @Override
        public void send() {
            System.out.println("This is sms...");
        }
    }
}
