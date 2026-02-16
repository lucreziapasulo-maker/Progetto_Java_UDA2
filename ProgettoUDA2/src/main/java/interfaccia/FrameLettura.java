package interfaccia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import static java.awt.Component.LEFT_ALIGNMENT;
import static java.awt.Component.TOP_ALIGNMENT;

import javax.swing.JTextArea;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author lu242 Frame dove verrà visualizzata la ricetta cercata. Questo frame
 * e ad ogni ricerca verrà creato un nuovo frame
 */
public class FrameLettura extends JFrame {

    // Componenti
    static JTextArea areaLettura = new JTextArea();
    JPanel panelButton = new JPanel();
    JScrollPane panelScroll = new JScrollPane(areaLettura);

    public FrameLettura() {
        this.setVisible(true);
        this.setSize(700, 1000);
        this.setResizable(true);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Metodi per formattare i vari elementi
        formattaAreaTesto();
        formattaPanel();

    }

    public JTextArea getAreaTesto() {
        return areaLettura;
    }

    public static String getTesto() {
        return areaLettura.getText();
    }

    public void formattaAreaTesto() {

        // Setto il font più grande
        float sizeF = 20f;
        Font font = areaLettura.getFont().deriveFont(sizeF);
        areaLettura.setFont(font);

        // Visualizzo il contenuto adattato alla finestra
        areaLettura.setLineWrap(true); // a capo in base alla grandezza del contenitore
        areaLettura.setWrapStyleWord(true); // a capo in base alle parole

        // Forzo la visualizzazione del testo dall'alto
        SwingUtilities.invokeLater(() -> areaLettura.setCaretPosition(0));
    }

//     TODO: bottone per modificare la ricetta e salvarla
    public void formattaPanel() {

        // Aggiungo la textArea al contenitore di default
        panelScroll.setVerticalScrollBarPolicy(panelScroll.VERTICAL_SCROLLBAR_ALWAYS);
        panelScroll.setHorizontalScrollBarPolicy(panelScroll.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.add(panelScroll);

        // Aggiungo al frame un panel con un pulsante
        panelButton.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(panelButton, BorderLayout.SOUTH);

    }
}
