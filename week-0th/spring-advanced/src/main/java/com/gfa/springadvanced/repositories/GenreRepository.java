package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.fromJson.Genre;
import com.gfa.springadvanced.models.fromJson.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
