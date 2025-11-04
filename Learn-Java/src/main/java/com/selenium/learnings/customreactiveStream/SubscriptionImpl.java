package com.selenium.learnings.customreactiveStream;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriptionImpl implements Subscription {

   private final Subscriber subscriber;

    public SubscriptionImpl(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void request(long val) {
        System.out.println("Data recieved " + val);
        for(int i=0;i<val;i++){
            subscriber.onNext("Muhassan");
        }
        subscriber.onComplete();
    }

    @Override
    public void cancel() {

    }
}
