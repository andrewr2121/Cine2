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
import poo.cine.dao.CalificacionesDao;
import poo.cine.dao.CalificacionesDaoHibernateImpl;
import poo.cine.dao.GenerosDao;
import poo.cine.dao.GenerosDaoHibernateImpl;
import poo.cine.dao.PaisesDao;
import poo.cine.dao.PaisesDaoHibernateImpl;
import poo.cine.dao.PeliculasDao;
import poo.cine.dao.PeliculasDaoHibernateImpl;
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
  
    
    private final ActorDao generosDao;


    public GestorActor(SessionFactory sessionFactory) {
               
        // creamos las instancias de los objetos de acceso a datos
        this.ActorDao = new ActorDaoHibernateImpl(sessionFactory);

    }
    
    public void run () {
        // obtenemos los objetos para completar las listas de seleccion
        List<Actor> actores = ActorDao.obtenerTodos();
        
        // creamos una instancia del formulario y lo mostramos
        PantallaAdministracionActores panelactores = new PantallaAdministracionActores(actores, calificaciones, paises, this);
        panelactores.setVisible(true);
    }
    
    public List<Personaje> obtenerElenco () {
        // mockup del resultado de la llamada al caso de uso "Registrar Elenco"
        Sexo masculino = new Sexo("Masculino");
        Actor ricardo = new Actor(false, "Darín", "Ricardo", masculino);
        Rol protagonista = new Rol("Protagonista");
        
        List<Personaje> personajes = new ArrayList<>();                
        personajes.add(new Personaje("Bombita", ricardo, protagonista));
        
        return personajes;
    }

    public Pelicula buscarPeliculaPorNombre(String nombre) {
        return peliculasDao.buscarPorNombre(nombre);
    }
    
    public void guardarPelicula (Pelicula pelicula) {
        peliculasDao.guardar(pelicula);
    }
}
    
}
