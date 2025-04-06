package com.kafka.consumer.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafka.consumer.springboot.entity.WikimediaData;

@Repository
public interface WikimediaDataJPARepository extends JpaRepository<WikimediaData, Long> {

}
