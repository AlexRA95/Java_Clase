package Gimnasio;

public enum Bono {

        EURO30(20,30.0),EURO25(15,25.0),EURO20(10,20.0);

        private int sesiones;
        private double precio;

        Bono(int sesiones, double precio) {
                this.sesiones = sesiones;
                this.precio = precio;
        }

        public int getSesiones() {
                return sesiones;
        }

        public double getPrecio() {
                return precio;
        }

}
