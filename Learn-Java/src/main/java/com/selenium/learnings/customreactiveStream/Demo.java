package com.selenium.learnings.customreactiveStream;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Demo {

    public static void main(String[] args) {
        Publisher<String> publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(1);




    }
}
