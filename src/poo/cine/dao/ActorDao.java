/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cine.dao;

import poo.cine.Actor;

/**
 *
 * @author Alumno
 */
public interface ActorDao {
    
    public Actor buscarPorNombre (String nombre);
    
    public void guardar (Actor actor);
}
