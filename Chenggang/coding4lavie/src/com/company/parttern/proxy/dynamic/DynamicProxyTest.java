package com.company.parttern.proxy.dynamic;

public class DynamicProxyTest {

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.sendMessage("java");
    }
}
