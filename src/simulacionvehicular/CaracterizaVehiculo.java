
package simulacionvehicular;
public class CaracterizaVehiculo {
public static final int aVelMax=33;     //Velocidad maxima en m/s = n120km/h
public static final int bVelMax=44;     //Velocidad maxima en m/s 160km/h
public static final int cVelMax=55;     //Velocidad maxima en m/s 200km/h
//Capacidad de aceleración en m/s^2
public static final int aCapMax=7;   
public static final int bCapMax=8;   
public static final int cCapMax=9;   

int        propiedad[][]= new int[3][5]; // (tipo[], caracteristica[])

public CaracterizaVehiculo(){
        //Vehiculo tipo A de carga biarticulado
        this.propiedad[0][0]=33;   //Velocidad maxima en m/s = n120km/h
        this.propiedad[0][1]=7;    //Capacidad de aceleración en m/s^2
        this.propiedad[0][2]=2;    //Aceleracion/Desaceleracion normal en m/s^2
        this.propiedad[0][3]=7;    //Frenado de emergencia en m/s^2
        this.propiedad[0][4]=16;   //Longitud del vehiculo en metros
        //Vehiculo tipo B de transporte simple
        this.propiedad[1][0]=44;   //Velocidad maxima en m/s 160km/h
        this.propiedad[1][1]=8;    //Capacidad de aceleración en m/s^2
        this.propiedad[1][2]=3;    //Aceleracion/Desaceleracion normal en m/s^2
        this.propiedad[1][3]=10;    //Frenado de emergencia en m/s^2
        this.propiedad[1][4]=8;   //Longitud del vehiculo en metros
        //Vehiculo tipo C particular o privado
        this.propiedad[2][0]=55;   //Velocidad maxima en m/s 200km/h
        this.propiedad[2][1]=9;    //Capacidad de aceleración en m/s^2
        this.propiedad[2][2]=4;    //Aceleracion/Desaceleracion normal en m/s^2
        this.propiedad[2][3]=12;    //Frenado de emergencia en m/s^2
        this.propiedad[2][4]=4;   //Longitud del vehiculo en metros
      
    }
    
}
