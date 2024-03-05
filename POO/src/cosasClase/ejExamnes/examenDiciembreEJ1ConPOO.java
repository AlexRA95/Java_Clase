package cosasClase.ejExamnes;

import java.util.ArrayList;

public class examenDiciembreEJ1ConPOO {

    public static void main(String[] args) {
        ArrayList<Comida> alimentos = new ArrayList<>();
        alimentos.add(new Comida("Fruta",50,1,0,15));
        alimentos.add(new Comida("Zumo",24,0,0,18));
        alimentos.add(new Comida("Pizza",200,10,59,7));
        alimentos.add(new Comida("Cereales",304,36,8,12));

        System.out.println("El alimento más sano es: " + Comida.masSano(alimentos).getNombre());

        for (Comida i: alimentos
             ) {
            System.out.printf("\nAlimento-> %S Clasificación-> %S\n",i.getNombre(),Comida.nutriScoreClasi(i));
        }

        System.out.printf("\nMAYOR aporte energetico -> %S - %d KJ\n",Comida.masEnergia(alimentos).getNombre(),Comida.masEnergia(alimentos).energia());
        System.out.printf("\nMAYOR aporte energetico -> %S - %d KJ\n",Comida.menosEnergia(alimentos).getNombre(),Comida.menosEnergia(alimentos).energia());


    }

}
