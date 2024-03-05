public class posibilidadTrabajar {

    public static void posibilidadTrabajar (int edad, String sexo) {
        if (sexo.equalsIgnoreCase("M")) {
            if (edad < 0) {
                System.out.println("ERROR (EDAD INTRODUCIDA NEGATIVA)");
            } else if (edad < 16) {
                System.out.println("No se puede trabajar con " + edad + " años.");
            } else if (edad < 68) {
                System.out.println("Un hombre con " + edad + " años puede trabajar");
            } else {
                System.out.println("Un hombre con " + edad + " está jubilado");
            }
        } else if (sexo.equalsIgnoreCase("F")) {
            if (edad < 0) {
                System.out.println("ERROR (EDAD INTRODUCIDA NEGATIVA)");
            } else if (edad < 18) {
                System.out.println("No se puede trabajar con " + edad + " años.");
            } else if (edad < 66) {
                System.out.println("Una mujer con " + edad + " años puede trabajar");
            } else {
                System.out.println("Una mujer con " + edad + " está jubilada");
            }
        } else {
            System.out.println("ERROR (CARACTER INTRODUCIDO INVÁLIDO)");
        }
    } // posibilidadTrabajar

    public static void main(String[] args) {
        posibilidadTrabajar(-5,"ñ");
    }

}
