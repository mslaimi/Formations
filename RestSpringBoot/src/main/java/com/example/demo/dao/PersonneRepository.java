package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Personne;

@RepositoryRestResource(
collectionResourceRel = "personnes", 
itemResourceRel = "personne", 
path = "personnes")
public interface PersonneRepository extends JpaRepository<Personne, Long> {
	List <Personne> findByNom(@Param("nom") String nom);
}
