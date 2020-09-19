package kz.aitu.advancedJava.repository;

import kz.aitu.advancedJava.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {


    @Query(value = "select * from student", nativeQuery = true)
    Student getStudent();

    List<Student> findAllByGroupId(long group_id);


}
