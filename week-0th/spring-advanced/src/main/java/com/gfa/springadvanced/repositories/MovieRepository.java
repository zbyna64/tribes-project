package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.fromJson.Movie;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
