/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg2;

import java.util.GregorianCalendar;
import java.util.Calendar;
/**
 *
 * @author ferna
 */

public class Empleado {
    
    static int generador=0;
    private int numero = 0;
    private String nombre;
    private float sueldo = 0;
    private int sueldoMaximo;
    private GregorianCalendar fecha_alta;
    int fecha_alta_dia=0;
    int fecha_alta_mes=0;
    int fecha_alta_anio=0;
    static Empleado inic = null;
    static Empleado actual = null;
    Empleado siguiente=null;
    static Empleado primero=null;
    Empleado anterior=null;
    static int contador=1;

    public Empleado(String nombre, float sueldo, int sueldoMaximo) {
        this.nombre = nombre;
        this.sueldoMaximo = sueldoMaximo;
        this.sueldo = sueldo;
        /*this.fecha_alta_dia=fecha_alta.get(Calendar.DAY_OF_MONTH);
        this.fecha_alta_mes=fecha_alta.get(Calendar.MONTH);
        this.fecha_alta_anio=fecha_alta.get(Calendar.YEAR);*/
        fecha_alta=new GregorianCalendar();
        this.numero=contador;
        contador++;
        this.siguiente=null;
        if(inic==null){
            inic=this;
            primero=this;
            actual=inic;
        }
        else{
            this.siguiente=inic;
            inic=this;
            actual.anterior=inic;
            actual=inic;
        }
    }
    
    static Empleado getActual(){
        return actual;
    }
    
    public GregorianCalendar getfecha(){
        return fecha_alta;
    }
    
     public String getnombre(){
        return this.nombre;
    }
     public float getsueldo(){
        return this.sueldo;
    }
     public int getsueldo_max(){
        return this.sueldoMaximo;
    }
    public int getnum(){
        return this.numero;
    }
    
    public static void avanzar(){
        
       
           actual=actual.siguiente; 
        
    }
    
    public static boolean esprimero(){
        return (actual.siguiente==null);
    }
    
    public static void retroceder(){
        
           actual=actual.anterior; 
    }
    
    public static boolean esultimo(){
        
        return (actual.anterior==null);
    }
    
    public static void inicio(){
        actual=primero;
    }

    public static void fina(){
        actual=inic;
    }
    @Override
    public String toString() {
        return "Empleado{" + "numero=" + numero + ", nombre=" + nombre + ", sueldo=" + sueldo + ", sueldoMaximo=" + sueldoMaximo + '}';
    }

    
}

