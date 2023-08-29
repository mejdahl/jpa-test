package dk.domstol.test.model;

import jakarta.persistence.Entity;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Freshman extends Student {
    private String mentor;
    private String test;

    @Builder
    public Freshman(UUID id, String name, School school, String mentor, String test) {
        super(id, name, school);
        this.mentor = mentor;
        this.test = test;
    }
}
