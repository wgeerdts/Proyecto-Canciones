package com.wgeerdts.canciones_db.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wgeerdts.canciones_db.modelos.Cancion;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long>{
   List<Cancion> findAll();

   Cancion save(Cancion cancion);

   void deleteById(Long Id);
}
