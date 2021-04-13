package com.ifmo.jjd.exam01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class Subscription implements FitnessTraining {
    final private UUID uuid;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate registrationStart;
    private LocalDate registrationEnd;
    private LocalTime validFrom;
    private LocalTime validTo;
    private FitnessZone[] fitnessZones;

    public Subscription(String firstName, String lastName, LocalDate birthDate, LocalDate registrationEnd, LocalTime validFrom, LocalTime validTo, int fitnessZoneCount) {
        this.uuid = UUID.randomUUID();
        if (firstName == null || firstName.strip().length() < 2) throw new IllegalArgumentException("Неверное значение firstName");
        this.firstName = firstName.strip();
        if (lastName == null || lastName.strip().length() < 2) throw new IllegalArgumentException("Неверное значение lastName");
        this.lastName = lastName.strip();
        if (birthDate == null) throw new IllegalArgumentException("Неверное значение birthDate");
        this.birthDate = birthDate;
        this.registrationStart = LocalDate.now();
        if (registrationEnd == null) throw new IllegalArgumentException("Неверное значение registrationEnd");
        this.registrationEnd = registrationEnd;
        if (validFrom == null) throw new IllegalArgumentException("Неверное значение validFrom");
        this.validFrom = validFrom;
        if (validTo == null) throw new IllegalArgumentException("Неверное значение validTo");
        this.validTo = validTo;
        if (fitnessZoneCount < 1) throw new IllegalArgumentException("Неверное значение fitnessZoneCount");
        this.fitnessZones = new FitnessZone[fitnessZoneCount];
    }
    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public FitnessZone[] getFitnessZones() {
        return fitnessZones;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getRegistrationStart() {
        return registrationStart;
    }

    public LocalDate getRegistrationEnd() {
        return registrationEnd;
    }

    public boolean addFitnessZone(FitnessZone fitnessZone) {
        if (fitnessZone == null) return false;
        for (int i = 0; i < fitnessZones.length; i++) {
            if (fitnessZones[i] == null) {
                fitnessZones[i] = fitnessZone;
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription)) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "Абонемент № " + uuid +
                " Имя: " + firstName +
                " Фамилия: " + lastName +
                " Дата рождения: " + birthDate +
                " Действует с " + registrationStart +
                " по " + registrationEnd;
    }

    @Override
    public String startTraining(Fitness fitness, FitnessZone fitnessZone) {
        boolean fitnessFlag = false;
        if (fitness == null) throw new IllegalArgumentException("Неверное значение fitness");
        if (fitnessZone == null) throw new IllegalArgumentException("Неверное значение fitnessZone");
        if (!fitness.getOpen()) return "Фитнес закрыт";
        if (!fitness.zoneExist(fitnessZone)) return "В нашем фитнесе нет такой зоны";
        if (registrationEnd.isBefore(LocalDate.now())) return "Срок абонемента истек";
        if (registrationStart.isAfter(LocalDate.now())) return "Срок абонемента еще не наступил";
        if (validFrom.isAfter(LocalTime.now())) return "Время тренировки еще не наступило";
        if (validTo.isBefore(LocalTime.now())) return "Время тренировки уже прошло";
        for (FitnessZone zone : fitnessZones) {
            if (zone.equals(fitnessZone)){
                fitnessFlag = true;
                break;
            }
        }
        if (!fitnessFlag) return "Абонемент не подходит для данной зоны";
        for (FitnessZone zone : fitness.getFitnessZones()) {
            if(zone.subscriptionExist(this)) return "Абонемент уже зарегистрирован";
        }
        if (!fitnessZone.addSubscription(this)) return "Эта зона фитнеса переполнена";
        return this.getFirstName() + " " + this.getLastName() + " " + fitnessZone.toString() + " " + LocalDateTime.now();
    }

    @Override
    public void stopTraining(Fitness fitness, FitnessZone fitnessZone) {
        if (fitness == null) throw new IllegalArgumentException("Неверное значение fitness");
        if (fitnessZone == null) throw new IllegalArgumentException("Неверное значение fitnessZone");
        if (!fitness.zoneExist(fitnessZone)) return;
        fitnessZone.stopSubscription(this);
    }
}
