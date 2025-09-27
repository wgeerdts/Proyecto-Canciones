package com.wgeerdts.canciones_db.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wgeerdts.canciones_db.modelos.Artista;

@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long>{
   List<Artista> findAll();

   Artista save(Artista artista);
   
}
