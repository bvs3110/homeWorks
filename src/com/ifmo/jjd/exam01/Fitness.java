package com.ifmo.jjd.exam01;

public class Fitness {
    final private String fitnessName;
    private FitnessZone[] fitnessZones;
    private Subscription[] subscriptions;
    private Boolean isOpen;

    public Fitness(String fitnessName, int fitnessZoneCount, int subscriptionCount) {
        this.fitnessName = fitnessName;
        if (fitnessZoneCount < 1) throw new IllegalArgumentException("Неверное значение fitnessZoneCount");
        this.fitnessZones = new FitnessZone[fitnessZoneCount];
        if (subscriptionCount < 1) throw new IllegalArgumentException("Неверное значение subscriptionCount");
        this.subscriptions = new Subscription[subscriptionCount];
        this.isOpen = false;
    }

    public String getFitnessName() {
        return fitnessName;
    }

    public FitnessZone[] getFitnessZones() {
        return fitnessZones;
    }

    public Subscription[] getSubscriptions() {
        return subscriptions;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public boolean zoneExist(FitnessZone fitnessZone) {
        if (fitnessZone == null) throw new IllegalArgumentException("Неверное значение fitnessZone");
        for (FitnessZone zone : fitnessZones) {
            if(fitnessZone.equals(zone)) return true;
        }
        return false;
    }

    public boolean addZone(FitnessZone fitnessZone){
        if (fitnessZone == null) throw new IllegalArgumentException("Неверное значение fitnessZone");
        for (int i = 0; i < fitnessZones.length; i++) {
            if (fitnessZones[i] == null) {
                fitnessZones[i] = fitnessZone;
                return true;
            }
        }
        return false;
    }
    public boolean addSubscription(Subscription subscription) {
        if (subscription == null) throw new IllegalArgumentException("Неверное значение subscription");
        for (int i = 0; i < subscriptions.length; i++) {
            if (subscriptions[i] == null) {
                subscriptions[i] = subscription;
                return true;
            }
        }
        return false;
    }

    public void openFitness() {
        this.isOpen = true;
    }

    public void closeFitness() {
        for (int i = 0; i < fitnessZones.length; i++) {
            fitnessZones[i].stopZone();
        }
        this.isOpen = false;
    }


}
