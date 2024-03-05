package cosasClase.ejExamnes;

import java.util.ArrayList;

public class Comida {

    private final int calorias;

    public int getCalorias() {
        return calorias;
    }

    public int getGrasas() {
        return grasas;
    }

    public int getColesterol() {
        return colesterol;
    }

    public int getAzucar() {
        return azucar;
    }

    public String getNombre() {
        return nombre;
    }

    private final int grasas;
    private final int colesterol;
    private final int azucar;
    private final String nombre;

    public Comida(String nombre,int calorias, int colesterol, int grasas, int azucar){
        this.nombre=nombre;
        this.calorias=calorias;
        this.colesterol=colesterol;
        this.grasas=grasas;
        this.azucar=azucar;
    }

    public double media(){
        return ((this.grasas + this.colesterol + this.azucar) /3.0);
    }

    public static Comida masSano(ArrayList<Comida> lista){
        Comida mas= lista.get(0);
        for (Comida i: lista) {
                if (mas.media()>i.media()){
                    mas = i;
                }
        }
        return mas;
    }

    public int nutriScoreNum(){
        return (this.calorias-(this.azucar+this.grasas*this.colesterol));
    }

    public static String nutriScoreClasi(Comida objt){
        String solu;

        if (objt.nutriScoreNum() >= 10) {
            solu = "A";
        } else if (objt.nutriScoreNum() >= 5) {
            solu = "B";
        } else if (objt.nutriScoreNum() >= 2) {
            solu = "C";
        } else if (objt.nutriScoreNum() >= 0) {
            solu = "D";
        } else {
            solu = "E";
        }

        return solu;

    }

    public int energia(){
        return this.calorias-this.azucar;
    }

    public static Comida masEnergia(ArrayList<Comida> lista){
        Comida mas=lista.get(0);
        for (Comida i: lista
             ) {
            if (mas.energia()<i.energia()){
                mas=i;
            }
        }
        return mas;
    }

    public static Comida menosEnergia(ArrayList<Comida> lista){
        Comida menos=lista.get(0);
        for (Comida i: lista
        ) {
            if (menos.energia()>i.energia()){
                menos=i;
            }
        }
        return menos;
    }

}
