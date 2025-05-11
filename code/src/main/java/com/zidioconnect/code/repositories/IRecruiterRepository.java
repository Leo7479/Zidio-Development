package com.zidioconnect.code.repositories;

import com.zidioconnect.code.models.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRecruiterRepository extends JpaRepository<Recruiter, Long> {
    public Optional<Recruiter> findByUser_Id(long id);
    public List<Recruiter> findByCompanyName(String name);
}
