import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;


public class Main {

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setSize(1600, 900);
        ventana.setTitle("Probando la libreria Swing en Java"); // titulo que se mostrara en nuestra ventana
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panelMenu =new JPanel();
        panelMenu.setLayout(new FlowLayout());
        //creamos la barra del menu y los diferentes campos que necesitamos
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuAcciones = new JMenu("Acciones");
        JMenu menuAyuda = new JMenu("Ayuda");
        //Ejercicio 6 añadimos items al menu
        JMenuItem itemVersion= new JMenuItem("Version");
        //Ejercicio 7 añadir cuadros de dialogo
        itemVersion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "La version del programa es la 1.0");
                System.out.println("El item version funciona");
            }
        });
        JMenuItem itemAcercade= new JMenuItem("Acerca de");
        itemAcercade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "En este programa simulamos una liga de futbol");
                System.out.println("El item Acerca de funciona");
            }
        });
        //menuBar.setBounds(0,0,1600,40);

        JPanel panel =new JPanel();
        //De esta manera creamos un borde al panel para poder separlo del margen izquierdo
        panel.setBorder(BorderFactory.createEmptyBorder(0,50,0,0));

        JButton botonNuevaLiga = new JButton("Nueva liga"); // instanciamos el campo y le indicampos entre los parentesis el contenido que debe mostrar
        //botonNuevaLiga.setSize(200, 40); //damos tamaño y posicion a los distintos campos
        botonNuevaLiga.setEnabled(true); // indicando true o false habilitamos o no el boton
        botonNuevaLiga.addActionListener(new ActionListener() { // nos muestra un mensaje por consola indicandonos que el boton funciona correctamente y realiza la accion
            @Override
            public void actionPerformed(ActionEvent e) {
                //Ejercicio 3 evento nueva liga
                System.out.println("Se esta creando una nueva liga");
            }
        });

        JButton botonJugarLiga = new JButton("Jugar liga");
        //botonJugarLiga.setSize( 200, 40);
        botonJugarLiga.setEnabled(true);
        botonJugarLiga.addMouseListener(new MouseAdapter() {// poniendo MouseAdapter conseguimos no tener que implementar todos los metodos de la interfaz

            //Ejercicio 4 Al pasar por encima del boton jugar liga nos muestra el siguiente mensaje por consola
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Al hacer click en este botón se simulará una liga al completo");
            }
        });

        JButton botonSiguienteJornada = new JButton("Siguiente Jornada");
        //botonSiguienteJornada.setSize( 200, 40);
        botonSiguienteJornada.setEnabled(true);
        botonSiguienteJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Ejercicio 5 asignamos evento con cuadro de dialogo que muestra un mensaje
                JOptionPane.showMessageDialog(null, "Se va a proceder a simular una jornada");
                System.out.println("El boton  salir funciona");
            }
        });

        JButton botonSimular = new JButton("Simulacion completada");
        //botonSimular.setSize( 200, 40);
        botonSimular.setEnabled(false);

        JButton botonSalir = new JButton("Salir");
        //botonSalir.setSize( 200, 40);
        botonSalir.setEnabled(true);
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ejercicio 2 añadimos la accion para que el boton salir cierre el programa
                System.exit(0);
                System.out.println("El boton  salir funciona");
            }
        });


        JPanel panelTabla =new JPanel();

        String cabecera [] ={"Equipo","Partido jugado","Victorias","Empates","Derrotas","Goles en contra","Goles a favor","Diferencia de goles","Puntos"} ;
        JTable tabla = new JTable();

        //Creacion del header de la tabla
        JTableHeader header = tabla.getTableHeader();
        tabla.setTableHeader(header);
        //header.setBounds(0, 0, 1000, 40);
        DefaultTableModel modeloTabla= new DefaultTableModel(cabecera,22);

        tabla.setModel(modeloTabla);

        //Ejercicio 1 Layout usando border
        BorderLayout borde =new BorderLayout(40,20);
        borde.setHgap(80);
        borde.setVgap(60);

        ventana.setLayout(borde);

        //añadimos a nuestra ventana los distintos elementos que vamos creando
        ventana.add(panelMenu,BorderLayout.NORTH);
        panelMenu.add(menuBar);
        //añadimos cada elemento a la menuBar
        menuBar.add(menuArchivo);
        menuBar.add(menuAcciones);
        menuBar.add(menuAyuda);
        menuAyuda.add(itemVersion);
        menuAyuda.add(itemAcercade);

        ventana.add(panel,BorderLayout.WEST);


        panel.add(botonNuevaLiga);
        panel.add(botonJugarLiga);
        panel.add(botonSiguienteJornada);
        panel.add(botonSimular);
        panel.add(botonSalir);
        ventana.add(panelTabla,BorderLayout.CENTER);
        panelTabla.add(tabla.getTableHeader());
        panelTabla.add(tabla);




        //hacemos que nuestra ventana sea visible indicando true
        ventana.setVisible(true);
        //Deshabilitamos la redimension de la ventana
        ventana.setResizable(false);

    }
}
