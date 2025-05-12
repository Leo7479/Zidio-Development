package com.zidioconnect.code.repositories;

import com.zidioconnect.code.models.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobPostingRepository extends JpaRepository<JobPosting, Long> {
    @Query(value="SELECT * FROM JobPostings WHERE LOWER(name) LIKE CONCAT('%',:name,'%')", nativeQuery = true)
    List<JobPosting> findByName(String name);
}
