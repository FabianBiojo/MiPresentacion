package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIEstudiante extends JFrame
{
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private JTextArea textoExpectativa;
    private Titulos titulo;
    private ImageIcon imagen;
    private JLabel labelImagen;
    private Escucha escucha;

    public GUIEstudiante()
    {
        initGUI();
        //default window configuration
        this.setTitle("Mi Presentacion");
        this.setSize(600,540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIEstudiante miGUI = new GUIEstudiante();

            }
        });
    }

    private void initGUI()
    {
        //Set up container and layout
        //Create listener and control objects
        escucha = new Escucha();
        //Set up JComponents
        titulo = new Titulos("Hola soy Fabian Biojo, oprime los botones", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);

        miFoto = new JButton("Este soy yo");
        miFoto.addActionListener(escucha);
        miHobby = new JButton("Mi hobby");
        miHobby.addActionListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addActionListener(escucha);


        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones, BorderLayout.SOUTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco mas de mi...",
                                                              TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER,
                                                              new Font(Font.DIALOG, Font.BOLD+Font.ITALIC, 20),
                                                              Color.BLUE));
        this.add(panelDatos, BorderLayout.CENTER);
        labelImagen = new JLabel();
        textoExpectativa = new JTextArea(15, 10);

    }

    private class Escucha implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent objectEvent)
        {
            panelDatos.removeAll();
            if (objectEvent.getSource()==miFoto) {
                imagen = new ImageIcon(getClass().getResource("/recursos/miFoto1.jpg"));
                labelImagen.setIcon(imagen);
                panelDatos.add(labelImagen);
            }
            else {
                if (objectEvent.getSource()==miHobby) {
                    //JOptionPane.showMessageDialog(miHobby, "Diste click en mi hobby");
                    imagen = new ImageIcon(getClass().getResource("/recursos/miHobby1.jpg"));
                    labelImagen.setIcon(imagen);
                    panelDatos.add(labelImagen);
                }
                else {
                    //JOptionPane.showMessageDialog(miHobby, "Diste click en creo que");
                    textoExpectativa.setText("\n\nAdquirir los principios basicos de diseño\n" +
                                           "para la programacion de interfaces graficas,\n" +
                                           "ademas aprender el lenguaje Java, ya que su \n" +
                                           "variedad de usos es muy amplia y es uno de los\n" +
                                           "lenguajes de programacion mas utilizados a\n" +
                                           "nivel mundial.");
                    textoExpectativa.setBackground(null);
                    textoExpectativa.setFont(new Font(Font.SERIF, Font.PLAIN+Font.ITALIC, 25));
                    panelDatos.add(textoExpectativa);
                }
            }
            revalidate();
            repaint();
        }
    }
}
