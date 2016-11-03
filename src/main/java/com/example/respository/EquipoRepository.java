package com.example.respository;

import com.example.domain.Equipo;
import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by DAM on 21/10/16.
 */
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    List<Equipo> findByLocalidad(String localidad);

    @Query("select jugador from Jugador jugador Where jugador.equipo.nombre = :nombre")
    List<Jugador> findByNombreEquipo(@Param("nombre") String nombre);

    @Query("select jugador from Jugador jugador Where jugador.equipo.nombre = :nombre and jugador.posicion = :posicion")
    List<Jugador> findByNombrEquipoAndPosicion(@Param("nombre") String nombre, @Param("posicion") String posicion);



}

