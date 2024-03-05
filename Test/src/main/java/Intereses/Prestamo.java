package Intereses;

public class Prestamo {

        public float calcularCuotaMes(float capital, int tiempo, CalcularInteres c){
                float importeTotal;
                importeTotal=capital+c.calculoInteres(capital,tiempo);
                return importeTotal/tiempo;

        }
}
