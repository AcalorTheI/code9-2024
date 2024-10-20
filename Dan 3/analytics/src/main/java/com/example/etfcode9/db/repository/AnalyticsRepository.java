package com.example.etfcode9.db.repository;

import com.example.etfcode9.db.entity.Analytics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnalyticsRepository extends CrudRepository<Analytics, Long> {

    Optional<Analytics> findByShortUlr(String shortUrl);
}
