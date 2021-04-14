package com.company.parttern.proxy.staticproxy;

public class SmsServiceImpl implements SmsService {
    @Override
    public String sendMessage(String message) {
        System.out.println("send message :" + message);
        return message;
    }
}
