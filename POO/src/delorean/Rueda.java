package delorean;

public class Rueda {
    private boolean inflada;

    public Rueda(){
        this.inflada=true;
    }

    public void inflar(){
        this.inflada=true;
    }

    public void desinflar(){
        this.inflada=false;
    }

    public boolean isInflada() {
        return inflada;
    }
}
