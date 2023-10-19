/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ferna
 */
public class aplicacion extends JFrame {

//Valores para los campos de texto
    private String nombre;
    private String aux;
    private float sueldo;
    private int sueldo_max;
    private int numero;
    private GregorianCalendar fecha;
    public boolean crear;
    String bsig="Siguiente";
    String bant="Atras";
    JButton button_anterior = new JButton(bsig);

    JButton button_siguiente = new JButton(bant);
    JButton button_crear = new JButton("Crear");

    //Etiquetas para identificar los campos de texto
    private JLabel nombreLabel;
    private JLabel sueldoLabel;
    private JLabel sueldo_maxLabel;
    private JLabel fechaLabel;
    private JLabel numLabel;

    //Cadenas para las etiquetas
    private static String nombreString = "Nombre: ";
    private static String sueldoString = "El sueldo es: ";
    private static String sueldo_maxString = "El sueldo maximo es: ";
    private static String fechaString = "La fecha de alta es: ";
    private static String numString = "El numero de empleado es: ";

    //Text fields para introducir números
    private TextField nombreField;
    private TextField sueldoField;
    private TextField sueldo_maxField;
    private TextField fechaField;
    private TextField numField;

    private boolean focusIsSet = false;

    public Empleado avanzar(Empleado e) {
        Empleado.retroceder();
        e = Empleado.getActual();
        return e;
    }

    public void avanza() {

        
            button_siguiente.setEnabled(true);
            Empleado.retroceder();
            System.out.println("Avanza");
            Empleado aux = Empleado.getActual();
            numero = aux.getnum();
            sueldo_max = aux.getsueldo_max();
            sueldo = aux.getsueldo();
            nombre = aux.getnombre();
            fecha = aux.getfecha();
            nombreField.setText("" + nombre);
            sueldoField.setText("" + sueldo);
            sueldo_maxField.setText("" + sueldo_max);
            fechaField.setText("" + fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR));
            numField.setText("" + numero);
            if (Empleado.esultimo()) {
            button_anterior.setEnabled(false);
            button_siguiente.setEnabled(true);
        
        }

    }

    public void retrocede() {
         
            button_anterior.setEnabled(true);
            Empleado.avanzar();
            System.out.println("Retrocede");

            Empleado aux = Empleado.getActual();
            numero = aux.getnum();
            sueldo_max = aux.getsueldo_max();
            sueldo = aux.getsueldo();
            nombre = aux.getnombre();
            fecha = aux.getfecha();
            nombreField.setText("" + nombre);
            sueldoField.setText("" + sueldo);
            sueldo_maxField.setText("" + sueldo_max);
            fechaField.setText("" + fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR));
            numField.setText("" + numero);
            System.out.println(crear);
        if (Empleado.esprimero()) {
            button_siguiente.setEnabled(false);
            button_anterior.setEnabled(true);
        }
    }

    public void creacion() {
        System.out.println("Creacion");
        nombreField.setEditable(true);
        sueldoField.setEditable(true);
        sueldo_maxField.setEditable(true);
        crear = true;
        System.out.println(crear);
        button_siguiente.setEnabled(true);
        button_anterior.setEnabled(true);
        nombreField.setText("");
            sueldoField.setText("");
            sueldo_maxField.setText("");
            button_anterior.setText("Confirmar");
            button_siguiente.setText("Cancelar");
           
    }

    public void confirmar() {
        System.out.println("confirmar");
        nombre = nombreField.getText();
        System.out.println(nombre);

        aux = sueldoField.getText();
        sueldo = Float.parseFloat(aux);
        System.out.println(sueldo);
        aux = sueldo_maxField.getText();

        sueldo_max = Integer.parseUnsignedInt(aux);
        System.out.println(sueldo_max);
        Empleado.fina();
        new Empleado(nombre, sueldo, sueldo_max);
        //System.out.println(nombre+sueldo+sueldo_max);
        nombreField.setEditable(false);
        sueldoField.setEditable(false);
        sueldo_maxField.setEditable(false);
        crear = false;
        Empleado.inicio();
        Empleado aux = Empleado.getActual();
        this.numero = aux.getnum();
        this.sueldo_max = aux.getsueldo_max();
        this.sueldo = aux.getsueldo();
        this.nombre = aux.getnombre();
        this.fecha = aux.getfecha();
        nombreField.setText("" + nombre);
            sueldoField.setText("" + sueldo);
            sueldo_maxField.setText("" + sueldo_max);
            fechaField.setText("" + fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR));
            numField.setText("" + numero);
            button_anterior.setText("Siguiente");
            button_siguiente.setText("Anterior");
    }

    public void no_confirmar() {
        nombreField.setEditable(false);
        sueldoField.setEditable(false);
        sueldo_maxField.setEditable(false);
        crear = false;
        nombreField.setText("" + nombre);
            sueldoField.setText("" + sueldo);
            sueldo_maxField.setText("" + sueldo_max);
            fechaField.setText("" + fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR));
            numField.setText("" + numero);
            button_anterior.setText("Siguiente");
            button_siguiente.setText("Anterior");
    }

    public aplicacion() {
        super("Menu");

        new Empleado("fer", 1000, 1500);
        new Empleado("pablo", 1500, 200);
        new Empleado("jose", 1760, 2000);
        new Empleado("pepe", 1809, 1991);
        Empleado.inicio();
        Empleado e = Empleado.getActual();
        this.numero = e.getnum();
        this.sueldo_max = e.getsueldo_max();
        this.sueldo = e.getsueldo();
        this.nombre = e.getnombre();
        this.fecha = e.getfecha();

        //Crea las etiquetas.
        nombreLabel = new JLabel(nombreString);
        sueldoLabel = new JLabel(sueldoString);
        sueldo_maxLabel = new JLabel(sueldo_maxString);
        fechaLabel = new JLabel(fechaString);
        numLabel = new JLabel(numString);

        //Campo que nos muestra el doble del numero introducido
        nombreField = new TextField(10);
        nombreField.setEditable(false);
        sueldoField = new TextField(10);
        sueldoField.setEditable(false);
        sueldo_maxField = new TextField(10);
        sueldo_maxField.setEditable(false);
        fechaField = new TextField(10);
        fechaField.setEditable(false);
        numField = new TextField(10);
        numField.setEditable(false);

        button_siguiente.setEnabled(false);
        // Asignarle una tecla.
        System.out.println(crear);
        button_anterior.addActionListener(new ActionListener() {  // Evento de boton.
            @Override
            public void actionPerformed(ActionEvent x) {
                System.out.println(numero);
                System.out.println(crear);
                if (crear == true) {
                    confirmar();
                } else {
                    avanza();
                }
            }
        });

        // Asignarle una tecla.
        button_siguiente.addActionListener(new ActionListener() {  // Evento de boton.
            @Override
            public void actionPerformed(ActionEvent x) {
                if (crear == true) {
                    no_confirmar();
                } else {
                    retrocede();
                }
            }
        });

        button_crear.addActionListener(new ActionListener() {  // Evento de boton.
            @Override
            public void actionPerformed(ActionEvent x) {

                creacion();
            }
        });

        nombreField.setText("" + nombre);
        sueldoField.setText("" + sueldo);
        sueldo_maxField.setText("" + sueldo_max);
        fechaField.setText("" + fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR));
        numField.setText("" + numero);

        //Dispone la geometría de las etiquetas en un panel
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new GridLayout(0, 1));
        labelPane.add(nombreLabel);
        labelPane.add(sueldoLabel);
        labelPane.add(sueldo_maxLabel);
        labelPane.add(fechaLabel);
        labelPane.add(numLabel);

        //Dispone los campos de texto en otro panel
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new GridLayout(0, 1));
        fieldPane.add(nombreField);
        fieldPane.add(sueldoField);
        fieldPane.add(sueldo_maxField);
        fieldPane.add(fechaField);
        fieldPane.add(numField);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(1, 0));

        buttonPane.add(button_siguiente);
        buttonPane.add(button_crear);
        buttonPane.add(button_anterior);

 
        //Incluye los dos paneles en otro panel,
        //etiquetas a la izquierda
        //y campos de texto a la derecha.
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());
        contentPane.add(labelPane, BorderLayout.CENTER);
        contentPane.add(fieldPane, BorderLayout.EAST);
        contentPane.add(buttonPane, BorderLayout.SOUTH);
       
        

        setContentPane(contentPane);  //this.setContentPane(contentPane);
        // es set, o sea, machado el contenedor del objeto "Doble", hijo de JFrame

    }
}
