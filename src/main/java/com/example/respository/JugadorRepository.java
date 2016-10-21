package com.example.respository;

import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DAM on 20/10/16.
 */
public interface JugadorRepository extends JpaRepository<Jugador, Long> {


    // finBy(nombre variable)nombre

    Jugador findBynombre(String nombre);
}
