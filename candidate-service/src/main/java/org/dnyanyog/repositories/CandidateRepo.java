package org.dnyanyog.repositories;

import java.util.Optional;
import org.dnyanyog.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {

  Optional<Candidate> findByresumeMediaId(long resumeMediaId);

  Integer deleteByresumeMediaId(long resumeMediaId);

  Optional<Candidate> findBymobile(Integer mobile);
}
