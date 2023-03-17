package com.graphisoft.ecotech.repository;

import com.graphisoft.ecotech.model.InfoImage;
import com.graphisoft.ecotech.model.LogBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoImageRepository extends JpaRepository<InfoImage, Long> {
}
