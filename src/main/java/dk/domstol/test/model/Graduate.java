package dk.domstol.test.model;

import jakarta.persistence.Entity;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Graduate extends Student{
    private String tutor;
    private Long test;

    @Builder
    public Graduate(UUID id, String childName, School school, String tutor, Long test) {
        super(id, childName, school);
        this.tutor = tutor;
        this.test = test;
    }
}
