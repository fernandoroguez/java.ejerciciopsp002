/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Ejercicio2 {
/**
 *
 * @author ferna
 */


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        final aplicacion app = new aplicacion();
        app.addWindowListener(new WindowAdapter() {
           
           
           @Override
           public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            //Pone el focus (foco de atencion)
           @Override
            public void windowActivated(WindowEvent e) {
                //app.setFocus();
            }
        });
        app.pack();
        app.setVisible(true);
    }

   /* private void setFocus() {
        if (!focusIsSet) {
            numeroField.requestFocus();
            focusIsSet = true;
        }
    }*/
    }
    
