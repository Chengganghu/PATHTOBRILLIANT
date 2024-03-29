package com.company.parttern.proxy.staticproxy;

public class SmsProxy implements SmsService {
    private final SmsService smsService;


    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String sendMessage(String message) {
        System.out.println("before method send()");
        smsService.sendMessage(message);
        System.out.println("after method send()");
        return null;
    }
}
