package com.taso.polovniautomobili.files;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    @Query(value = "SELECT ads_id FROM ads WHERE usr_id = ?1",
    nativeQuery = true)
    List<Long> findAllIdsAds(Long usrId);
}
