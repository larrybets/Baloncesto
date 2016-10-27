package com.example.service;

import com.example.domain.Jugador;
import com.example.respository.EquipoRepository;
import com.example.respository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DAM on 20/10/16.
 */
//  Combinar los apartados B y E: es decir, la consulta ha de devolver los jugadores que hayan conseguido un número total de canastas mayor o igual a un parámetro, y además que he nacido en una fecha anterior a una fecha especificada como parámetro.


@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    public void testJugador() {

        Jugador jugador1 = new Jugador("larry", "1991", 144, 33, 89, "ala");
        jugadorRepository.save(jugador1);
        Jugador jugador2 = new Jugador("Pepe", "1999", 122, 50, 78, "pivot");
        jugadorRepository.save(jugador2);
        Jugador jugador3 = new Jugador("carlos", "1993", 134, 56, 98, "defensa");
        jugadorRepository.save(jugador3);
        Jugador jugador4 = new Jugador("jose", "1993", 156, 87, 90, "pivot");
        jugadorRepository.save(jugador4);
        Jugador jugador5 = new Jugador("ivan", "1994", 122, 11, 89, "ala");
        jugadorRepository.save(jugador5);

        System.out.println(jugadorRepository.findBynombre("Pepe"));

        System.out.println("jugadores que han conseguido  mayor o igual de canastas ");
        System.out.println(jugadorRepository.findBycanastasTotalesGreaterThanEqual(130));

        /////
// Buscar jugadores que hayan efectuado un número de asistencias dentro de un rango especificado como parámetro (El rango se específica mediante un valor mínimo y un valor máximo).

        System.out.println("jugadores con asitencias medias de 10 a 50 ");
        System.out.println(jugadorRepository.findByasistenciasTotalesBetween(10, 60));

        //    Buscar jugadores que pertenezcan a una posición específica, por ejemplo: base / pivot
        System.out.println("Jugadores que juegan de pivot");
        System.out.println(jugadorRepository.findByposicion("pivot"));

        //    Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro.

        System.out.println("jugadores que hayan nacido antes de 1992 ");
        System.out.println(jugadorRepository.findBynacimientoLessThan("1992"));

        // agrupar los jugadores por la posicion del campo y devolver para cada grupo la siguiente infor:
        // media de canastas asistencias t rebotes




        // Lo mismo que el punto anterior pero devolviendo
        // la media el maximo y el niminimo de canastas asistencias y rebotes
        System.out.println("");
    }

}

