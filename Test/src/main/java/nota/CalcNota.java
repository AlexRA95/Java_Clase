package nota;
public class CalcNota {

    public int calcularNota(int bien, int mal, int blanca)
    {
        int nota;
        boolean error;
        int i;

        nota=0;
        error = false;

        if ( (bien + mal + blanca) != 10 )
        {
            error = true;
            nota = -1;
        }
        if ( (bien>10) )
        {
            error = true;
            nota = -2;
        }
        if ( (mal>10) )
        {
            error = true;
            nota = -3;
        }
        if ( (blanca>10) )
        {
            error = true;
            nota = -4;
        }
        if (!error)
        {
            nota = bien;
            nota = nota - mal;
        }
        return nota;
    } /* calcularNota */

}
