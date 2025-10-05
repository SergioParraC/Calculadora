package calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Teclado {
    private JLabel valor;
    private JButton botonSuma;
    private JButton botonResta;
    private JButton botonMultiplicar;
    private JButton botonDivision;
    private JButton botonEnter;
    private JButton botonEliminar;
    private JButton botonPunto;
    private Pantalla pantalla;
    
    public Teclado(JComponent root, JLabel valor,
                   JButton botonSuma, JButton botonResta,
                   JButton botonMultiplicar, JButton botonDivision,
                   JButton botonEnter, JButton botonEliminar,
                   JButton botonPunto) 
    {
        this.valor = valor;
        this.botonSuma = botonSuma;
        this.botonResta = botonResta;
        this.botonMultiplicar = botonMultiplicar;
        this.botonDivision = botonDivision;
        this.botonEnter = botonEnter;
        this.botonEliminar = botonEliminar;
        this.botonPunto = botonPunto;
        this.pantalla = new Pantalla(valor);

        configurarKeyBindings(root);
    }

    private void configurarKeyBindings(JComponent root) {
        InputMap inputMap = root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = root.getActionMap();

        // 🔹 Números 0–9
        for (char c = '0'; c <= '9'; c++) {
            char num = c;
            inputMap.put(KeyStroke.getKeyStroke(num), "num" + num);
            actionMap.put("num" + num, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pantalla.añadirTextoPantalla(String.valueOf(num));
                }
            });
        }

        // 🔹 Operadores
        inputMap.put(KeyStroke.getKeyStroke('+'), "suma");
        actionMap.put("suma", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonSuma.doClick();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke('-'), "resta");
        actionMap.put("resta", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonResta.doClick();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke('*'), "multiplicar");
        actionMap.put("multiplicar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonMultiplicar.doClick();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke('/'), "division");
        actionMap.put("division", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonDivision.doClick();
            }
        });

        // 🔹 Enter
        inputMap.put(KeyStroke.getKeyStroke("ENTER"), "enter");
        actionMap.put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonEnter.doClick();
            }
        });

        // 🔹 Backspace
        inputMap.put(KeyStroke.getKeyStroke("BACK_SPACE"), "borrar");
        actionMap.put("borrar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonEliminar.doClick();
            }
        });
        inputMap.put(KeyStroke.getKeyStroke("BACK_SPACE"), "borrar");
        actionMap.put("borrar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonEliminar.doClick();
            }
        });
        inputMap.put(KeyStroke.getKeyStroke('.'), "punto");
        actionMap.put("punto", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonPunto.doClick();
            }
        });
    }
}
