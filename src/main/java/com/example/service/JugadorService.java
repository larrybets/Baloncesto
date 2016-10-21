package com.example.service;

import com.example.domain.Jugador;
import com.example.respository.EquipoRepository;
import com.example.respository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DAM on 20/10/16.
 */

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    public void testJugador() {

        Jugador jugador1 = new Jugador("larry", "27/02/1991", 144, 33, 89, "ala");
        jugadorRepository.save(jugador1);
        Jugador jugador2 = new Jugador("Pepe", "26/01/1999", 122, 50, 78, "pivot");
        jugadorRepository.save(jugador2);
        Jugador jugador3 = new Jugador("carlos", "25/11/1993", 134, 56, 98, "defensa");
        jugadorRepository.save(jugador3);
        Jugador jugador4 = new Jugador("jose", "23/03/1993", 156, 87, 90, "pivot");
        jugadorRepository.save(jugador4);
        Jugador jugador5 = new Jugador("ivan", "22/06/1994", 122, 11, 89, "ala");
        jugadorRepository.save(jugador5);

        System.out.println(jugadorRepository.findBynombre("Pepe"));

    }

}

