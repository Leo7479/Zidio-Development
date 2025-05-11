package com.zidioconnect.code.repositories;






import com.zidioconnect.code.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUser_Id(Long userId);
}
