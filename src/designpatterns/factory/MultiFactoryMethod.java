package designpatterns.factory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 15:42
 */
public class MultiFactoryMethod {

    private interface Sender {
        public void send();
    }

    private class  SmsSender implements Sender {

        @Override
        public void send() {
            System.out.println("This is sms...");
        }
    }

    private class MailSender implements Sender {

        @Override
        public void send() {
            System.out.println("This is mail...");
        }
    }

    public class SendFactory {

        public Sender newSmsSender() {
            return new SmsSender();
        }

        public Sender newMailSender() {
            return new MailSender();
        }
    }

}
