package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.fromJson.Movie;
import com.gfa.springadvanced.models.fromJson.ProductionCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionCompanyRepository extends JpaRepository<ProductionCompany, Long> {

}
