package com.db.app.database.repository;

import com.db.app.database.model.CustomerDemographic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDemographicRepository extends JpaRepository<CustomerDemographic, Long> {
}
