package entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "my_climber")
public class Climber implements Cloneable{
    @Column(nullable = false)
    private String fullName; //полное имя
    private int age; //возраст
    private String email; //почта
    @Column(nullable = false, unique = true)
    @Id
    private UUID uuid; //идентификатор
    @ManyToOne(fetch = FetchType.LAZY)
    private ClimbingGroup group;

    //    методы
    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().length() < 3) throw new IllegalArgumentException("Значение fullName < 3");
        this.fullName = fullName;
    }

    public void setAge(int age) {
        if (age < 18) throw new IllegalArgumentException("age < 18");
        this.age = age;
    }

    public void setEmail(String email) {
        if (email == null || !email.trim().contains("@")) throw new IllegalArgumentException("!email");
        this.email = email;
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID();
    }

    public String getFullName() {
        return fullName;
    }
    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public UUID getUuid() {
        return uuid;
    }

    public ClimbingGroup getGroup() {
        return group;
    }

    public void setGroup(ClimbingGroup group) {
        this.group = group;
    }

    //    Alt + Ins Alt+Fn+ins


    @Override
    public String toString() {
        return "Climber{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", uuid=" + uuid +
                '}';
    }

    @Override
    public Climber clone() {
        try {
            return (Climber) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Climber)) return false;
        Climber climber = (Climber) o;
        return age == climber.age && Objects.equals(fullName, climber.fullName) && Objects.equals(email, climber.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age, email, uuid);
    }
}
