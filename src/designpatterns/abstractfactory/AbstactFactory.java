package designpatterns.abstractfactory;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 15:43
 */
public class AbstactFactory {

    @Test
    public void test() {
        MailFactory mailFactory = new MailFactory();
        mailFactory.newSender().send();

    }
}


interface Sender {
    public void send();
}

interface Provider {
    public Sender newSender();
}

class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("This is mail...");
    }
}

class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("This is sms...");
    }
}

class MailFactory implements Provider {

    @Override
    public Sender newSender() {
        return new MailSender();
    }
}

class SmsFactory implements Provider {

    @Override
    public Sender newSender() {
        return new SmsSender();
    }
}

