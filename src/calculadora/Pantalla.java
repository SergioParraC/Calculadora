package calculadora;

import javax.swing.JLabel;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Pantalla {
    private JLabel pantalla;
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
    private DecimalFormat df = new DecimalFormat("0.##########", symbols); 
    public Pantalla (JLabel pantalla)
    {
        this.pantalla = pantalla;
    }
    public void añadirTextoPantalla(String texto)
    {
        String valor = pantalla.getText();
        pantalla.setText(valor + texto);
    }
    public double obtenerUltimoNumero() 
    {
        String expresion = pantalla.getText();
        String regex = "([0-9]+\\.?[0-9]*)$";  // último número (entero o decimal)

        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(expresion);

        if (matcher.find()) {
            return Double.parseDouble(matcher.group(1));
        }
    return 0.0;
    }
    public void ponerRespuesta(double numero)
    {
        String texto = df.format(numero);
        pantalla.setText(texto);
    }
    public void errorDivisionPorCero()
    {
        JOptionPane.showMessageDialog(null, "Error: división por cero", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    public void limpiarPantalla()
    {
        pantalla.setText("");
    }
    public String obtenerUltimoCaracter() {
        String expresion = pantalla.getText();

        if (expresion == null || expresion.isEmpty()) {
            return ""; // devuelve vacío si no hay nada en pantalla
        }

        return String.valueOf(expresion.charAt(expresion.length() - 1));
    }
}
