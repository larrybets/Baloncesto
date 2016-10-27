package com.example.respository;

import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by DAM on 20/10/16.
 */
public interface JugadorRepository extends JpaRepository<Jugador, Long> {


    // finBy(nombre variable)nombre

    Jugador findBynombre(String nombre);
    List<Jugador> findBycanastasTotalesGreaterThanEqual(Integer canastasTotales);
    List<Jugador> findByasistenciasTotalesBetween(Integer min, Integer max);
    List<Jugador> findByposicion(String posicion);
    List<Jugador> findBynacimientoLessThan(String nacimiento);
List<Jugador>
}
