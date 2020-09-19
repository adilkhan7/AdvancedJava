package kz.aitu.advancedJava.repository;

import kz.aitu.advancedJava.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {



}
