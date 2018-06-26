/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaractor;

/**
 *
 * @author Andrew
 */
public class Actor {
    
    /*
    private void campoBuscadorReleased(){
    resultado.setText("");
    String cadenaResultados = "";
            
    
        for(int=0;i <listado.size();i++){
            if(listado.get(i).empiezaPor(campoBusqueda.getText())){
              cadenaResultados += listado.get(i).toString + "/n/n";
             }
    
         resultado.setText(cadenaResultados):
        }
    }
   */ 

    private boolean empiezaPor(String apellido, String campo){
        if(campo.isEmpty()|| campo.length()<apellido.length()){
        return false;
        }
        for (i=0;i<campo.lenght();i++){
            if(campo.charAt(i)!= apellido.charAt(i)){
            return false;
            }
        }  
        return true;
    }

}
