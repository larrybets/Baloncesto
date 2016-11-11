package com.example.service;

import com.example.domain.Equipo;
import com.example.domain.Jugador;
import com.example.respository.EquipoRepository;
import com.example.respository.JugadorRepository;
import org.hibernate.boot.model.source.spi.SingularAttributeSourceToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

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

        Equipo hospi = new Equipo("Hospi", "Hospitalet", "27/02/1990");
        equipoRepository.save(hospi);
        Jugador larry = new Jugador("larry", "1991", 156, 33, 89, "alero");
        larry.setEquipo(hospi);
        jugadorRepository.save(larry);
        Jugador pepe = new Jugador("Pepe", "1999", 156, 50, 78, "alero");
        pepe.setEquipo(hospi);
        jugadorRepository.save(pepe);
        //////////
        Equipo cornella = new Equipo("Cornella", "Cornella de Llobregat", "28/09/1993");
        equipoRepository.save(cornella);
        Jugador carlos = new Jugador("carlos", "1993", 156, 56, 98, "defensa");
        carlos.setEquipo(cornella);
        jugadorRepository.save(carlos);
        //////////
        Equipo castellbisbal = new Equipo("CastellBisbal", "Castell Bisbal", "03/09/2000");
        equipoRepository.save(castellbisbal);
        Jugador jose = new Jugador("jose", "1993", 156, 87, 90, "pivot");
        jose.setEquipo(castellbisbal);
        jugadorRepository.save(jose);
        //////////
        Equipo aese = new Equipo("AESE", "Hospitalet", "09/02/2001");
        equipoRepository.save(aese);
        Jugador ivan = new Jugador("ivan", "1994", 122, 11, 89, "alero");
        ivan.setEquipo(aese);
        jugadorRepository.save(ivan);

        Equipo nandobase = new Equipo("NandoBase", "El Prat", "19/04/2009");
        equipoRepository.save(nandobase);


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

        // agrupar los jugadores por la posicion del campo y devolver para cada grupo
        // la siguiente infor:
        // media de canastas asistencias t rebotes

        showStatistics(jugadorRepository.AvgAndMaxAndMinPricesPerposicion());
        showStatistics(jugadorRepository.AvgAndMaxAndMinPricesPerposicion());

        System.out.println("************* EQUIPASO SOSIO ");
        // Consulta los equipos existentes en una localidad determinada.
        System.out.println("Equipos existentes de Hospitalete");
        System.out.println(equipoRepository.findByLocalidad("Hospitalet"));

        // Devuelve todos los jugadores de un equipo, a partir del nombre completo del equipo.
        System.out.println("jugadores del Hospi");
        System.out.println(equipoRepository.findByNombreEquipo("Hospi"));

        // Devuelve todos los jugadores de un equipo, que además jueguen en la misma posición (parámetro adicional de la consulta), por ejemplo, alero.
        System.out.println("Jugadores que juegan en un equipo, y son alero");
        System.out.println(equipoRepository.findByNombrEquipoAndPosicion("Hospi", "alero"));
        // Devuelve el jugador que más canastas ha realizado de un equipo determinado como parámetro.
        System.out.println("Jugador que mas canastas ha realizado de hospi");
        showStatisticsBestPlayer(equipoRepository.JugadorMaxCanastasEquipo("Hospi", new PageRequest(0,1)));

        System.out.println("********************************");
    }


    private void showStatistics(List<Object[]> statisticsList) {
        for (Object[] statistic : statisticsList) {
            System.out.println("Posicion: " + statistic[0]);
            System.out.println("AVG asistencias = " + statistic[1] + " puntos");
            System.out.println("AVG canastas= " + statistic[2] + " puntos");
            System.out.println("AVG REBOTES = " + statistic[3] + " puntos" + System.lineSeparator());
        }

    }

    private void showStatistics2(List<Object[]> statisticsList) {
        for (Object[] statistic : statisticsList) {
            System.out.println("Posicion: " + statistic[0]);
            System.out.println("AVG asistencias = " + statistic[1] + " puntos");
            System.out.println("AVG canastas= " + statistic[2] + " puntos");
            System.out.println("AVG REBOTES = " + statistic[3] + " puntos" + System.lineSeparator());
        }
    }

    private void showStatistics3(List<Object[]> statisticsList) {
        for (Object[] statistic : statisticsList) {
            System.out.println("nombre " + statistic[0]);
            System.out.println("Max canastas = " + statistic[1] + " puntos" + System.lineSeparator());
        }

    }
    private void showStatisticsBestPlayer(Page<Jugador> jugadorPage) {
        jugadorPage.getContent().forEach(jugador->{
            System.out.println(jugador);

        });
    }

}



