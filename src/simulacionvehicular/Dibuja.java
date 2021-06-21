package simulacionvehicular;
import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.lang.Math;
public class Dibuja extends javax.swing.JPanel {
    CaracterizaVehiculo cv=new CaracterizaVehiculo();
     public void borraG(Graphics g) throws InterruptedException{
        int[] xpoints= new int[4];
        int[] ypoints= new int[6];        
        xpoints[0]=0;
        xpoints[1]=1220;
        xpoints[2]=1220;
        xpoints[3]=0;
        ypoints[0]=0;
        ypoints[1]=0;
        ypoints[2]=1000;
        ypoints[3]=1000;
        g.setColor(Color.white);
        g.fillPolygon(xpoints,ypoints , 4); 

    }
     public void borraD(Graphics g) throws InterruptedException{
        int[] xpoints= new int[4];
        int[] ypoints= new int[6];        
        xpoints[0]=0;
        xpoints[1]=500;
        xpoints[2]=500;
        xpoints[3]=0;
        ypoints[0]=0;
        ypoints[1]=0;
        ypoints[2]=2500;
        ypoints[3]=2500;
        g.setColor(Color.white);
        g.fillPolygon(xpoints,ypoints , 4); 

    }

    public void datosGen(Graphics g, int [][]gen, String nomExp, int numGen) throws InterruptedException{
        g.setColor(Color.black); 
            g.drawString("Generacion:"+numGen+"  Experimento: "+nomExp, 10, 20);
            
            g.drawString("Num  |    Parejas "+nomExp, 10, 35);
            
            int poss=30;
            
            for (int i=0;i<100;i++){
                if(i%2==0){
                    g.drawLine(10, 20+poss, 500, 20+poss);
                    poss=poss+15;
                }
                g.drawString("N°: "+i+" | "
                    +gen[i][0]
                    +gen[i][1]
                    +gen[i][2]
                    +gen[i][3]
                    +gen[i][4]
                    +gen[i][5]
                    +gen[i][6]
                    +gen[i][7]
                    +gen[i][8]
                    +gen[i][9]
                    +gen[i][10]
                    +gen[i][11]
                    +gen[i][12]
                    +gen[i][13]
                    +gen[i][14]
                    +gen[i][15]
                    +gen[i][16]
                    +gen[i][17]
                    +gen[i][18]
                    +gen[i][19]
                    ,10, 20+poss);
                poss=poss+15;               
            }
            
    }

    
     public void datos(Graphics g, float []x, float []y, String datox, String datoy) throws InterruptedException{
        g.setColor(Color.black); 
        g.drawLine(10, 10, 400, 10);
        g.drawString("("+datox+")", 13, 23);
        g.drawString("("+datoy+")", 103, 23);
        g.drawLine(10, 35, 400, 35);
        DecimalFormat decimales = new DecimalFormat("0.0000"); 
        for (int i=0;i<100;i++){
            g.drawLine(10, 10, 10, 20+15*(i+2));
            g.drawLine(400, 10, 400, 20+15*(i+2));
            g.drawLine(100, 10, 100, 20+15*(i+2));
            g.setColor(Color.black); 
            g.drawLine(10, 20+15*(i+2), 400, 20+15*(i+2));
            g.drawString(" "+x[i], 13, 18+15*(i+2));
            
                g.setColor(Color.blue);
            
            g.drawString(" "+decimales.format(y[i]), 103, 18+15*(i+2));
        }
     }

    void graficaCarretera(Graphics g, int[] coordenadaX, int[] coordenadaY, int limite) {
        limite++;
        g.setColor(Color.GRAY);
        for (int i=0;i<limite;i++){
            g.fillOval(coordenadaX[i], coordenadaY[i],4 , 4);
        }
    }

    void graficaEstado(Graphics g, int[] coordenadaX, int[] coordenadaY, int limite, int[][] vehiculos, int numVehiculos) {
        limite++;
        int poss, col, tam;
        DecimalFormat d = new DecimalFormat("0.0"); 
        for (int i=0;i<numVehiculos&&vehiculos[i][1]<limite;i++){// Vehiculos (Tipo[1000], posición[1000], velocidad[1000], estado[1000], color[1000])
            poss=vehiculos[i][1];
            col=vehiculos[i][3];
            tam=cv.propiedad[vehiculos[i][0]][4];
             //0 Negro colición
            //1 Naranja, frenado de emergencia
            //2 Rojo, fremando
            //3 verde, acelera 
            //4 azul, mantiene 
            if(col==4){g.setColor(Color.blue);//6 negro Frena arriba del limite de velocidad
            }else if(col==3){g.setColor(Color.green);//5 azul, mantiene en +-3m/s el limite de velocidad 
            }else if(col==2){g.setColor(Color.red);//4 verde, mantiene debajo del limite
            }else if(col==1){g.setColor(Color.orange);//3 Amarillo, acelera 
            }else{g.setColor(Color.BLACK);//0 Negro colición
            }
            g.drawString(d.format(vehiculos[i][2]*3.6)+"km/h",coordenadaX[poss], coordenadaY[poss]-2);
            g.drawString(i+"",coordenadaX[poss], coordenadaY[poss]+13);
            
            for (int j=0;j<tam;j++){
                g.fillOval(coordenadaX[poss+j], coordenadaY[poss+j]+1, 2, 2);
            }
                
        }
    }
}

