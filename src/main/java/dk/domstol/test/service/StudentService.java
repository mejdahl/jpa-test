package dk.domstol.test.service;

import dk.domstol.test.model.Freshman;
import dk.domstol.test.model.Graduate;
import dk.domstol.test.model.School;
import dk.domstol.test.model.School_;
import dk.domstol.test.repository.Repository;
import jakarta.persistence.EntityManager;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final Repository repository;
    private final EntityManager entityManager;

    public StudentService(Repository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;

        var skole=School.builder().id(UUID.randomUUID()).build();

        skole.addStudent(Graduate.builder().id(UUID.randomUUID()).build());
        skole.addStudent(Freshman.builder().id(UUID.randomUUID()).build());
        skole.setHelper(Graduate.builder().id(UUID.randomUUID()).build());
        repository.save(skole);

        var list=repository.findAll();

        var builder = entityManager.getCriteriaBuilder();
        var query = builder.createQuery(School.class);
        var root = query.from(School.class);
        root.fetch(School_.STUDENTS);
        root.fetch(School_.HELPER);


        var list2 = entityManager.createQuery(query).getResultList();
    }
}
