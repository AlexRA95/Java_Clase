package EjA3;

public class ejAtributoA3 {

    public static void main(String[] args) {
        Rectangulo rec1=new Rectangulo(0,0,5,5);
        Rectangulo rec2=new Rectangulo(7,9,2,3);



        int perimetro1=(Math.abs(rec1.x2-rec1.x1)+Math.abs(rec1.y2-rec1.y1))*2;
        int perimetro2=(Math.abs(rec2.x2-rec2.x1)+Math.abs(rec2.y2-rec2.y1))*2;
        int area1=Math.abs(rec1.x2-rec1.x1)*Math.abs(rec1.y2-rec1.y1);
        int area2=Math.abs(rec2.x2-rec2.x1)*Math.abs(rec2.y2-rec2.y1);

        System.out.printf("\n El rectangulo definido por las coordenadas ( %d , %d ) y ( %d , %d ) tiene un perimetro %d y un area %d ",rec1.x1,rec1.y1,rec1.x2,rec1.y2,perimetro1,area1);

        System.out.printf("\n El rectangulo definido por las coordenadas ( %d , %d ) y ( %d , %d ) tiene un perimetro %d y un area %d ",rec2.x1,rec2.y1,rec2.x2,rec2.y2,perimetro2,area2);


        System.out.println("");

        rec1.x1=15;
        rec1.y1=1;
        rec1.x2=0;
        rec1.y2=15;

        rec2.x1=17;
        rec2.y1=4;
        rec2.x2=4;
        rec2.y2=6;

         perimetro1=(Math.abs(rec1.x2-rec1.x1)+Math.abs(rec1.y2-rec1.y1))*2;
         perimetro2=(Math.abs(rec2.x2-rec2.x1)+Math.abs(rec2.y2-rec2.y1))*2;
         area1=Math.abs(rec1.x2-rec1.x1)*Math.abs(rec1.y2-rec1.y1);
         area2=Math.abs(rec2.x2-rec2.x1)*Math.abs(rec2.y2-rec2.y1);

        System.out.println("");

        System.out.printf("\n El rectangulo definido por las coordenadas ( %d , %d ) y ( %d , %d ) tiene un perimetro %d y un area %d ",rec1.x1,rec1.y1,rec1.x2,rec1.y2,perimetro1,area1);

        System.out.printf("\n El rectangulo definido por las coordenadas ( %d , %d ) y ( %d , %d ) tiene un perimetro %d y un area %d ",rec2.x1,rec2.y1,rec2.x2,rec2.y2,perimetro2,area2);



    }

}
