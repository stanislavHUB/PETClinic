package webUi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;
import webUi.entity.Specialty;

import java.util.Set;

public interface SpecialtyRepository extends Repository<Specialty, Integer> {
    @Query("SELECT specialties FROM Specialty specialties")
    @Transactional(readOnly = true)
    Set<Specialty> findSpecialty();
}
