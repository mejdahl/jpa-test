package dk.domstol.test.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School {
    @Id
    private UUID id;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    Set<Student> students;

    @Transient
    public void addStudent(Student student) {
        if (students==null) {
            students=new HashSet<>();
        }
        student.setSchool(this);
        students.add(student);
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Graduate helper;

}
