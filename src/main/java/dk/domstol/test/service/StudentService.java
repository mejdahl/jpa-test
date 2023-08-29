package dk.domstol.test.service;

import dk.domstol.test.model.Freshman;
import dk.domstol.test.model.Graduate;
import dk.domstol.test.model.Graduate_;
import dk.domstol.test.model.School;
import dk.domstol.test.model.School_;
import dk.domstol.test.repository.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Join;
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
        var helper =  (Join<Object, Object>)root.fetch(School_.HELPER);
        query.where(builder.equal(helper.get(Graduate_.NAVN),"mig"));

        var list2 = entityManager.createQuery(query).getResultList();
    }
}
