package com.ifmo.jjd.exam01;

import java.util.Arrays;
import java.util.Objects;

public class FitnessZone {
    private String fitnessZoneName;
    private Subscription[] subscriptions;

    public FitnessZone(String fitnessZoneName) {
        this.fitnessZoneName = fitnessZoneName;
        this.subscriptions = new Subscription[20];
    }

    public String getFitnessZoneName() {
        return fitnessZoneName;
    }

    public Subscription[] getSubscriptions() {
        return subscriptions;
    }

    public boolean subscriptionExist(Subscription subscription) {
        if (subscription == null) throw new IllegalArgumentException("Неверное значение subscription");
        for (Subscription mySubscription : subscriptions) {
            if(subscription.equals(mySubscription)) return true;
        }
        return false;
    }

    public boolean addSubscription(Subscription subscription) {
        if (subscription == null) throw new IllegalArgumentException("Неверное значение subscription");
        if(subscriptionExist(subscription)) return false;
        for (int i = 0; i < subscriptions.length; i++) {
            if(subscriptions[i] == null) {
                subscriptions[i] = subscription;
                return true;
            }
        }
        return false;
    }

    public boolean stopSubscription(Subscription subscription) {
        if (subscription == null) throw new IllegalArgumentException("Неверное значение subscription");
        for (int i = 0; i < subscriptions.length; i++) {
            if(subscription.equals(subscriptions[i])) {
                subscriptions[i] = null;
                return true;
            }
        }
        return false;
    }

    public void stopZone() {
        for (int i = 0; i < subscriptions.length; i++) {
            subscriptions[i] = null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FitnessZone)) return false;
        FitnessZone that = (FitnessZone) o;
        return Objects.equals(fitnessZoneName, that.fitnessZoneName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fitnessZoneName);
    }

    @Override
    public String toString() {
        return fitnessZoneName;
    }
}
