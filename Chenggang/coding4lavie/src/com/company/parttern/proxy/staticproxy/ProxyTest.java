package com.company.parttern.proxy.staticproxy;

public class ProxyTest {

    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);

        smsProxy.sendMessage("chenggang");
    }
}
