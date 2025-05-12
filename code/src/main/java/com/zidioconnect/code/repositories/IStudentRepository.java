package com.zidioconnect.code.repositories;
import com.zidioconnect.code.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Student findByUser_Id(Long userId);
    boolean existsByUser_Id(long userId);

}
