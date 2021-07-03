package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
@Getter
@Setter
@Entity
public class ClimbingGroup {
    @Id
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    private Mountain mountain;
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Climber[] climbers;
    private LocalDateTime start;

    public ClimbingGroup(Mountain mountain, int climberCount) {
        this.mountain = Objects.requireNonNull(mountain, "mountain");
        climbers = new Climber[climberCount];
    }

    public  void addClimber(Climber climber) {
        Objects.requireNonNull(climber, "climber");
        for (int i = 0; i < climbers.length; i++) {
            if (climbers == null) {
                climbers[i] = climber;
                return; // в воид методах для заершения работы метода
            }
        }
        System.out.println("Мест нет" +
                "" +
                "");
    }

    @Override
    public String toString() {
        return "ClimbingGroup{" +
                "mountain=" + mountain +
                ", climbers=" + Arrays.toString(climbers) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClimbingGroup)) return false;
        ClimbingGroup that = (ClimbingGroup) o;
        return Objects.equals(mountain, that.mountain) && Arrays.equals(climbers, that.climbers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mountain);
        result = 31 * result + Arrays.hashCode(climbers);
        return result;
    }

    @Override
    public ClimbingGroup clone() {
        Mountain copyM = this.mountain.clone();
        ClimbingGroup copy = new ClimbingGroup(copyM, climbers.length);
        copy.climbers = climbers.clone();
        return copy;
    }
}
