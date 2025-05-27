package com.zidioconnect.code.repositories;

import com.zidioconnect.code.models.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICertificationRepository extends JpaRepository<Certification, Long> {
    List<Certification> findByStudent_Id(long id);
}
