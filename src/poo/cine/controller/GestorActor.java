/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cine.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.hibernate.SessionFactory;
import poo.cine.Actor;
import poo.cine.Calificacion;
import poo.cine.Cine;
import poo.cine.Genero;
import poo.cine.PaisDeOrigen;
import poo.cine.Pelicula;
import poo.cine.Personaje;
import poo.cine.Rol;
import poo.cine.Sexo;
import poo.cine.dao.ActorDao;
import poo.cine.dao.ActorDaoHibernateImpl;
import poo.cine.ui.PantallaAdministracionActores;

/**
 *
 * @author Alumno
 */
public class GestorActor {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author joaquinleonelrobles
 */
  
    
    private final ActorDao actorDao;


    public GestorActor(SessionFactory sessionFactory) {
               
        // creamos las instancias de los objetos de acceso a datos
        this.actorDao = new ActorDaoHibernateImpl(sessionFactory);

    }
    
    public void run () {
                        
        // creamos una instancia del formulario y lo mostramos
        PantallaAdministracionActores panelactores = new PantallaAdministracionActores(this);
        panelactores.setVisible(true);
    }
    
    /*public List<Personaje> obtenerElenco () {
        // mockup del resultado de la llamada al caso de uso "Registrar Elenco"
        Sexo masculino = new Sexo("Masculino");
        Actor ricardo = new Actor(false, "Darín", "Ricardo", masculino);
        Rol protagonista = new Rol("Protagonista");
        
        List<Personaje> personajes = new ArrayList<>();                
        personajes.add(new Personaje("Bombita", ricardo, protagonista));
        
        return personajes;
    }
*/
    public Actor buscarActorPorNombre(String nombre) {
        return actorDao.buscarPorNombre(nombre);
    }
    
    public void guardarActor(Actor actor) {
        actorDao.guardar(actor);
    }
}
    

