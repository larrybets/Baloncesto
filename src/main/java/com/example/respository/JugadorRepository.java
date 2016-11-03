package com.example.respository;

import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by DAM on 20/10/16.
 */
public interface JugadorRepository extends JpaRepository<Jugador, Long> {


    // finBy(nombre variable)nombre

    List<Jugador> findBynombre(String nombre);

    List<Jugador> findBycanastasTotalesGreaterThanEqual(Integer canastasTotales);

    List<Jugador> findByasistenciasTotalesBetween(Integer min, Integer max);

    List<Jugador> findByposicion(String posicion);

    List<Jugador> findBynacimientoLessThan(String nacimiento);

    @Query("SELECT jugador.posicion, AVG(jugador.asistenciasTotales), AVG(jugador.canastasTotales), AVG(jugador.rebotesTotales) " +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")

    List<Object[]> AvgAndMaxAndMinPricesPerposicion();

    @Query("SELECT jugador.posicion, AVG(jugador.asistenciasTotales), MIN(jugador.asistenciasTotales), MAX(jugador.asistenciasTotales), " +
           " AVG(jugador.canastasTotales), MIN(jugador.canastasTotales), MAX(jugador.canastasTotales), " +
           " AVG(jugador.rebotesTotales), MIN(jugador.rebotesTotales), MAX(jugador.rebotesTotales) " +
            "FROM Jugador jugador " +
                    "GROUP BY jugador.posicion ")

    List<Object[]> AvgAndMaxAndMinPricesPerPosicionResumen();


}
