/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author Candelaria
 */
public class Funcion {

    private int diaSemana;
    private int duracion;
    private Date horaInicio;
    private int numero;
    private Pelicula pelicula;
    private Sala sala;
    private List<Entrada> entradas;

    /**
     * Constructor por Defecto
     */
    public Funcion() {
        entradas = new ArrayList<Entrada>();
    }
    
    /**
     * Este constructor no incluye los atributos referenciales de la clase Funcion
     * 
     * @param diaSemana
     * @param duracion
     * @param fechaHabilitacion
     * @param horaInicio
     * @param numero
     * @param pelicula
     * @param sala 
     */
    public Funcion(int diaSemana, int duracion, Date horaInicio, int numero, Pelicula pelicula, Sala sala) {
        this.diaSemana = diaSemana;
        this.duracion = duracion;
        this.horaInicio = horaInicio;
        this.numero = numero;
        this.pelicula = pelicula;
        this.sala = sala;
    }
    
    /**
     * Calculamos la cantidad de butacas disponibles en base a la cantidad
     * total de la sala y las entradas vendidas para esta Función
     * 
     * @return cantidad de butacas disponibles
     */
    public int calcularDisponibilidad() {
        // TODO completar
        return sala.getCapacidad() - entradas.size();
    }
    
    /**
     * Obtenemos la capacidad de la Sala en cantidad de butacas
     * 
     * @return cantidad total de butacas de la Sala
     */
    public int capacidadSala() {
        // TODO implementar
        return sala.getCapacidad();
    }
    
    /**
     * 
     * @return 
     */
    public boolean estaEnCurso() {
        // TODO implementar
        GregorianCalendar fechaInicioGre, fechaFinGre;
        fechaInicioGre = new GregorianCalendar();
        fechaInicioGre.setTime(horaInicio);
        fechaFinGre = (GregorianCalendar) fechaInicioGre.clone();
        fechaFinGre.add(Calendar.MINUTE, duracion);
        return !(fechaInicioGre.before(GregorianCalendar.getInstance())
                && fechaFinGre.after(GregorianCalendar.getInstance()));
    }
    
    /**
     * Consultamos si queda al menos una Entrada disponible para esta función
     * 
     * @return 
     */
    public boolean hayLugar() {
        // TODO implementar
        return (capacidadSala()>this.entradas.size());
    }
    
    /**
     * Devolvemos una representación en texto del día y hora de esta función
     * 
     * @return 
     */
    public String mostrarDiaHora() {
    String horario;
    SimpleDateFormat df;
     df = new SimpleDateFormat("E H:mm",Locale.US);
     horario = df.format(horaInicio);
        return "Esta funcion es del dia" + horario ;
    }

    // A continuación se listan todos los métodos de seteo
    // de cada atributo de la clase
    
    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }
    /**
     * Recorremos las Funciones y armamos una cadena de texto con la 
     * representación de cada una de ellas.
     * 
     * @return cadena de texto con las funciones
     */
    @Override
    public String toString() {
        // TODO recorrer funciones y mostrar sus datos
        
        return "Dia de la semana:" + this.diaSemana + "Duracion de la pelicula:"+ this.duracion + "Hora de inicio:"+ this.horaInicio + 
                "Numero:" + this.numero + "Pelicula a estrenar:" + this.pelicula + "Corresponde a la sala x"+ this.sala;
    }
      
}
