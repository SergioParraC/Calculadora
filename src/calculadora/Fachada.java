package calculadora;

public class Fachada {
    Fundacionales fund = new Fundacionales();
    public double sumar(double num1, double num2)
    {
        return fund.sumar(num1, num2);
    }
    public double restar(double num1, double num2)
    {
        return fund.restar(num1, num2);
    }
    public double multiplicar(double num1, double num2)
    {
        return fund.multiplicar(num1, num2);
    }
    public double dividir(double num1, double num2)
    {
        return fund.dividir(num1, num2);
    }
}
