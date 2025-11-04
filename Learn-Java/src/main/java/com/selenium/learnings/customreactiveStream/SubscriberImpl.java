package com.selenium.learnings.customreactiveStream;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriberImpl implements Subscriber<String> {


    private Subscription subscription;


    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        System.out.println("Subscription SUccessfully");
    }

    @Override
    public void onNext(String data) {
        System.out.println(data);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {
        System.out.println("Subscription Complete");
    }

    public Subscription getSubscription() {
        return subscription;
    }
}
