package simulacionvehicular;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.Socket;
import static java.sql.DriverManager.println;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PantallaPrincipal extends javax.swing.JFrame {
    Dibuja D=new Dibuja();
    BufferedImage datoSimulacion =  new BufferedImage(500, 2500, BufferedImage.TYPE_INT_RGB);
    BufferedImage grafico =  new BufferedImage(1200, 1000, BufferedImage.TYPE_INT_RGB);
    Graphics img;
    JFrame F1= new JFrame();
    CaracterizaVehiculo cv=new CaracterizaVehiculo();
    int numVehiculos=60;
    int generaciones=100;
    int limite=22;//11=40km/h, 22=80km/h 
    
    int densidad=100;
    int aleatoriedadHumana=10;
    int nGen=0;
    
    //tipo Convencional o Autonomo
    //velocidad en m/s
    //estado Acelerando maximo, acelerando, manteniendo, frenando, frenando de emergencia
    //distancia de seguridad con el de adelante
//***********************************************************************
    
    public PantallaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jScrollPane1 = new javax.swing.JScrollPane();
        jcontenedorGrafica = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jGrafico = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jcontenedorDatos = new javax.swing.JPanel();
        jDatos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        verGeneracion = new javax.swing.JButton();
        nuevoExperimento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nuevoExperimento1 = new javax.swing.JButton();
        nuevoExperimento2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setName("framePrincipal"); // NOI18N

        jGrafico.setText("+");

        javax.swing.GroupLayout jcontenedorGraficaLayout = new javax.swing.GroupLayout(jcontenedorGrafica);
        jcontenedorGrafica.setLayout(jcontenedorGraficaLayout);
        jcontenedorGraficaLayout.setHorizontalGroup(
            jcontenedorGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcontenedorGraficaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGrafico)
                .addContainerGap(734, Short.MAX_VALUE))
        );
        jcontenedorGraficaLayout.setVerticalGroup(
            jcontenedorGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcontenedorGraficaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcontenedorGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGrafico)
                    .addComponent(jLabel3))
                .addContainerGap(544, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jcontenedorGrafica);

        jcontenedorDatos.setPreferredSize(new java.awt.Dimension(500, 2500));

        jDatos.setText("+");
        jDatos.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jcontenedorDatosLayout = new javax.swing.GroupLayout(jcontenedorDatos);
        jcontenedorDatos.setLayout(jcontenedorDatosLayout);
        jcontenedorDatosLayout.setHorizontalGroup(
            jcontenedorDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcontenedorDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jcontenedorDatosLayout.setVerticalGroup(
            jcontenedorDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcontenedorDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jcontenedorDatos);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Datos");

        verGeneracion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verGeneracion.setText("Nuevo experimento");
        verGeneracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoExp(evt);
            }
        });

        nuevoExperimento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nuevoExperimento.setText("Ver anterior");
        nuevoExperimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAnimacion(evt);
            }
        });
        nuevoExperimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nuevoExperimentoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Simulación");

        nuevoExperimento1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nuevoExperimento1.setText("Ver siguiente");
        nuevoExperimento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoExperimento1verAnimacion(evt);
            }
        });
        nuevoExperimento1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nuevoExperimento1KeyPressed(evt);
            }
        });

        nuevoExperimento2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nuevoExperimento2.setText("Ver Animacion");
        nuevoExperimento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoExperimento2verAnimacion(evt);
            }
        });
        nuevoExperimento2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nuevoExperimento2KeyPressed(evt);
            }
        });

        jMenu9.setText("Experimento");

        jMenuItem8.setText("Abrir");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAbrir(evt);
            }
        });
        jMenu9.add(jMenuItem8);

        jMenuItem2.setText("Nuevo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNuevo(evt);
            }
        });
        jMenu9.add(jMenuItem2);

        jMenuItem10.setText("Guardar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardar(evt);
            }
        });
        jMenu9.add(jMenuItem10);

        jMenuItem9.setText("Cerrar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCerrar(evt);
            }
        });
        jMenu9.add(jMenuItem9);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(verGeneracion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nuevoExperimento2)
                        .addGap(114, 114, 114)
                        .addComponent(nuevoExperimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nuevoExperimento1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(verGeneracion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nuevoExperimento, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nuevoExperimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nuevoExperimento2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void vernGen() {                              
        String name="Gen"+nGen+".png";
        ImageIcon icon=new ImageIcon(name,"");
        jGrafico.setIcon(icon);        
        
    }         
    private void NuevoExp(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoExp
            img=grafico.getGraphics();
            numVehiculos=Integer.parseInt(JOptionPane.showInputDialog(F1,"¿Cuantos vehiculos desea generar?(max 100)"));
            generaciones=Integer.parseInt(JOptionPane.showInputDialog(F1,"¿Cuantas generaciones desea?"));
            int vehiculos[][][] = new int[generaciones][numVehiculos][4];   // Vehiculos (Tipo[1000], posición[1000], velocidad[1000], estado[1000])
    
            //Comienza construcción de escenario
            Random tipo = new Random();//Define el tipo 
            Random eDistA = new Random();//Define la distancia extra en funcion de la densidad
            Random estado = new Random();//Define el tipo 
            Random vel = new Random();//Define la velocidad 
            Random humano= new Random();
            int distanciaDeSeguridadMin=0; //Se calcula en base a la velocidad de los vehiculos lider y seguidor
            
            int puntero=0; //marca la posición de la creacion de vehiculos
            int velocidadSeguidor=0; //Define la velocidad del vehiculo Seguidor
            int velocidadAcercamiento=0;
            int aceleracionSeguidor=0;
            int distanciaSegura=0;
            int longitudLider=0;
            int extraDist=0;
            int tipovs=0, tipovl=0;
            int comportamientoHumano=0;
            //Definición del vehiculo lider 
              // Vehiculos (0Tipo[1000], 1posición[1000], 2velocidad[1000], 3estado[1000])
            vehiculos[0][0][0]=(int)0+ tipo.nextInt(3);  //Tipo
            vehiculos[0][0][1]=0;  //posición
            //vehiculos[0][0][2]=(int)0+ vel.nextInt(cv.propiedad[vehiculos[0][0][0]][0]); //velocidad
            vehiculos[0][0][2]=(int)10+ vel.nextInt(limite-5); //velocidad
            vehiculos[0][0][3]=4;
            //0 Negro colición
            //1 Naranja, frenado de emergencia
            //2 Rojo, fremando
            //3 verde, acelera 
            //4 azul, mantiene 
            System.out.println("T= "+vehiculos[0][0][0]+" posicion vehiculo "+0+": "+vehiculos[0][0][1]+ " Velocidad: "+vehiculos[0][0][2]+" Estado: "+vehiculos[0][0][3]);
                
            //Definicion de los vehiculos seguidores
            for (int i=1; i<numVehiculos; i++){
                vehiculos[0][i][0]=(int)0+ tipo.nextInt(3);  //Tipo
                tipovs=vehiculos[0][i][0];
                tipovl=vehiculos[0][i-1][0];
                vehiculos[0][i][3]=4; //En el estado inicial todos mantienen
            
                vehiculos[0][i][2]=(int)10+ vel.nextInt(limite-5); //se determina velocidad inicial
                
                velocidadSeguidor=vehiculos[0][i][2]; 
                longitudLider=cv.propiedad[tipovl][4]; 
                aceleracionSeguidor=cv.propiedad[tipovs][2];
                distanciaSegura= longitudLider+aceleracionSeguidor+velocidadSeguidor*(1+(velocidadSeguidor/(2*aceleracionSeguidor) ) );
                extraDist = (int)eDistA.nextInt(densidad);
                
                //posicion
                vehiculos[0][i][1]=vehiculos[0][i-1][1]+distanciaSegura+ extraDist;  //posición = posicionSeguidor + distancia segura + distanciaExtraRandom 
                
                System.out.println("T= "+tipovs+" posicion vehiculo "+i+": "+vehiculos[0][i][1]+ " Velocidad: "+vehiculos[0][i][2]+" Ll:"+longitudLider+" Estado: "+vehiculos[0][i][3]+" ExDist: "+extraDist);
               
            }//Aqui termina la definición del estado inicial //Y ya está correcto hasta aqui, ya no moverle 
            
            int nuevaP=0;
               //cierre del anillo 
                velocidadSeguidor=vehiculos[0][0][2]; 
                longitudLider=cv.propiedad[vehiculos[0][numVehiculos-1][0]][4]; 
                aceleracionSeguidor=cv.propiedad[vehiculos[0][0][0]][2];
                distanciaSegura= longitudLider+aceleracionSeguidor+velocidadSeguidor*(1+(velocidadSeguidor/(2*aceleracionSeguidor) ) );
                extraDist = (int)eDistA.nextInt(densidad);
                int limitep=vehiculos[0][numVehiculos-1][1]+distanciaSegura+ extraDist+1;  //posición =posicionSeguidor+longitud seguidor + distancia segura+ distanciaExtraRandom 
                System.out.println("tamaño final del anillo: "+limitep);
                
                
                
                
                
                // Formación de estados siguientes
                
                
                int nvel=0;
                        
                for(int j=1;j<generaciones;j++){
                    //Primer vehiculo del arreglo:
                
                    vehiculos[j][0][0]=vehiculos[j-1][0][0]; //Tipo, sigue siendo el mismo tipo
                    vehiculos[j][0][2]=vehiculos[j-1][0][2];//Se pasa la velocidad anterior para calcular la posicion siguiente
                    // Vehiculos (Tipo[1000], posición[1000], velocidad[1000], estado[1000])
                    nuevaP=vehiculos[j-1][0][1]-vehiculos[j-1][0][2]; //Posición mas velocidad //aqui menos porque va al reves
                    
                    if (nuevaP<0){ //si llega al fin del anillo
                        vehiculos[j][0][1]=nuevaP+limitep; //vuelve a empezar
                    }else{ // si no, sigue normal
                        vehiculos[j][0][1]=nuevaP;
                    }
                    //distancia de seguridad ->Queda pendiente hasta calcular el nuevo estado
                    //Cambio de estado->Igual queda pendiente
                    //formacion del resto de vehiculos siguientes   
                    for(int i=1;i<numVehiculos;i++){
                        vehiculos[j][i][0]=vehiculos[j-1][i][0]; //Tipo, sigue siendo el mismo tipo
                        vehiculos[j][i][2]=vehiculos[j-1][i][2];//Se pasa la velocidad anterior para calcular la posicion siguiente
                        nuevaP=vehiculos[j-1][i][1]-vehiculos[j][i][2]; //Posición mas velocidad
                        if (nuevaP<0){ //si llega al fin del anillo
                            vehiculos[j][i][1]=nuevaP+limitep; //vuelve a empezar
                        }else{ // si no, sigue normal
                            vehiculos[j][i][1]=nuevaP;
                        }
                        // Vehiculos (Tipo[1000], posición[1000], velocidad[1000], estado[1000])
                        //Nueva Distancia de seguridad
                        tipovs=vehiculos[j][i][0];
                        tipovl=vehiculos[j][i-1][0];
                        velocidadSeguidor=vehiculos[j][i][2]; 
                        longitudLider=cv.propiedad[tipovl][4]; 
                        aceleracionSeguidor=cv.propiedad[tipovs][2];
                        distanciaSegura= longitudLider+aceleracionSeguidor+velocidadSeguidor*(1+(velocidadSeguidor/(2*aceleracionSeguidor) ) );
                        //Cambio de estado
                        //reglaDeTransicion(int dS, int pL, int pS, int limit, int lL, int as, int vl, int vs)
                        vehiculos[j][i][3]=reglaDeTransicion(distanciaSegura, vehiculos[j][i-1][1],vehiculos[j][i][1], limitep, longitudLider, aceleracionSeguidor, limite, velocidadSeguidor);
                        System.out.println("TL= "+tipovl+" posicion vehiculo L"+i+": "+vehiculos[j-1][i][1]+ " Velocidad: "+vehiculos[j-1][i][2]+" Estado: "+vehiculos[j-1][i][3]);
                        System.out.println("TS= "+tipovs+" posicion vehiculo S"+i+": "+vehiculos[j][i][1]+ " Velocidad: "+vehiculos[j][i][2]+" Estado: "+vehiculos[j][i][3]);
                        System.out.println(" velS: "+velocidadSeguidor+" LongL: "+longitudLider+" aS: "+aceleracionSeguidor+" Ds: "+distanciaSegura);
                        //nueva velocidad
                        if(vehiculos[j][i][3]==3){//acelera
                            nvel=vehiculos[j][i][2]+cv.propiedad[tipovs][2];
                                /*if(nvel>limite+2){
                                    vehiculos[j][i][2]=vehiculos[j-1][i][2];
                                }else if(nvel<limite-2){
                                    vehiculos[j][i][2]=nvel;
                                }*/
                                vehiculos[j][i][2]=nvel;
                        }else if(vehiculos[j][i][3]==2){ //frena
                            nvel=vehiculos[j][i][2]-cv.propiedad[tipovs][2];
                            if(nvel<0) vehiculos[j][i][2]=0;
                            
                            vehiculos[j][i][2]=nvel;
                        }else if(vehiculos[j-1][i][3]==4){//mantiene
                            vehiculos[j][i][2]=vehiculos[j][i][2];
                        }
                    }
                    //distancia de seguridad que estaba pendiente
                        velocidadSeguidor=vehiculos[j][0][2]; 
                        longitudLider=cv.propiedad[vehiculos[j][numVehiculos-1][0]][4]; 
                        aceleracionSeguidor=cv.propiedad[vehiculos[j][0][0]][2];
                        distanciaSegura= longitudLider+aceleracionSeguidor+velocidadSeguidor*(1+(velocidadSeguidor/(2*aceleracionSeguidor) ) );
                        //Cambio de estado que estaba pendiente
                        vehiculos[j][0][3]=reglaDeTransicion(distanciaSegura, vehiculos[j][numVehiculos-1][1],vehiculos[j][0][1], limitep, longitudLider, aceleracionSeguidor, limite, velocidadSeguidor);
                            
                        //nueva velocidad
                        if(vehiculos[j][0][3]==3){//acelera
                            nvel=vehiculos[j][0][2]+cv.propiedad[tipovs][2];
                            
                            /*    if(nvel>limite+2){
                                    vehiculos[j][0][2]=vehiculos[j][0][2];
                                }else if(nvel<limite-2){
                                    vehiculos[j][0][2]=nvel;
                                }*/
                            vehiculos[j][0][2]=nvel;
                            
                        }else if(vehiculos[j][0][3]==2){ //frena
                            nvel=vehiculos[j][0][2]-cv.propiedad[tipovs][2];
                            if(nvel<0) vehiculos[j][0][2]=0;
                            
                            vehiculos[j][0][2]=nvel;
                        }else if(vehiculos[j-1][0][3]==4){//mantiene
                            vehiculos[j][0][2]=vehiculos[j][0][2];
                        }
                    
        }
            
        int coordenadaX[]=new int[20720];
        int coordenadaY[]=new int[20720];
        
        int y=20;
        for (puntero=0;puntero<1148;puntero++){
            coordenadaX[puntero]=puntero;
            coordenadaY[puntero]=y;
        }
        for (int j=0;j<5;j++){
         for (int i=1148;i<1172;i=i+2){
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
            puntero++;
            coordenadaX[puntero]=i+1;
            coordenadaY[puntero]=y;
         }//puntero=24
         for (int i=1172;i<1184;i++){
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
         }//puntero=1186
        
         for (int i=1184;i<1196;i++){
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
         }//puntero=1210
         for(int i=0;i<3;i++){
             puntero++;
             y++;
            coordenadaX[puntero]=1195;
            coordenadaY[puntero]=y;
         }
         for (int i=1195;i>1183;i--){
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
         }  //puntero=1234
         for (int i=1183;i>1171;i--){
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
         }//puntero=1246
         for (int i=1171;i>1147;i=i-2){
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
            puntero++;
            coordenadaX[puntero]=i-1;
            coordenadaY[puntero]=y;
         }//puntero=1270
 // Fin curva        
         for(int i=1147;i>47;i--){
            puntero++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
         }//puntero2370
         for(int i=47;i>23;i=i-2){
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
            puntero++;
            coordenadaX[puntero]=i-1;
            coordenadaY[puntero]=y;
         }//puntero = 2394
         for(int i=23;i>11;i--){
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
         }//puntero = 2406
         for(int i=11;i>-1;i--){
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
         } //puntero = 2430
         for(int i=0;i<3;i++){
            puntero++;
            y++;
            coordenadaX[puntero]=0;
            coordenadaY[puntero]=y;
         }
         for(int i=0;i<12;i++){
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
         }//puntero = 2454
         for(int i=12;i<24;i++){
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
         }//puntero = 2466
         for(int i=24;i<48;i=i+2){
            puntero++;
            y++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
            puntero++;
            coordenadaX[puntero]=i+1;
            coordenadaY[puntero]=y;
         }//puntero = 2490
         for(int i=48;i<1148;i++){
            puntero++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
         }
        }//Fin de curvas
        for(int i=1148;i<1199;i++){
            puntero++;
            coordenadaX[puntero]=i;
            coordenadaY[puntero]=y;
        }//Fin de camino
        
        img=grafico.getGraphics();
        try {
            for (int i=0;i<generaciones;i++){
                D.borraG(img);
                D.graficaCarretera(img,coordenadaX,coordenadaY, limitep);
                D.graficaEstado(img,coordenadaX,coordenadaY,limitep,vehiculos[i], numVehiculos);
                String name="Gen"+i+".png";
                ImageIO.write(grafico, "png", new File(name));
            }
            nGen=0;
            JOptionPane.showMessageDialog(null, generaciones +" estados han sido generados.");
        } catch (Exception ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }         
            
    }//GEN-LAST:event_NuevoExp

    private void verAnimacion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAnimacion
        nGen--;
       if(nGen>-1){
        String name="Gen"+nGen+".png";
        ImageIcon icon=new ImageIcon(name,"");
        jGrafico.setIcon(icon);   
       }else{
           nGen++;
          JOptionPane.showMessageDialog(null, "Ya es el estado inicial");
       }
                
             
    }//GEN-LAST:event_verAnimacion

    private void jCerrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCerrar
        // TODO add your handling code here:
    }//GEN-LAST:event_jCerrar

    private void jAbrir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAbrir
        
    }//GEN-LAST:event_jAbrir

    private void jGuardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardar
        // TODO add your handling code here:
    }//GEN-LAST:event_jGuardar

    private void jNuevo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNuevo
            
    }//GEN-LAST:event_jNuevo

    private void nuevoExperimento1verAnimacion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoExperimento1verAnimacion
        nGen++;
        if(nGen<generaciones){
        String name="Gen"+nGen+".png";
        ImageIcon icon=new ImageIcon(name,"");
        jGrafico.setIcon(icon);   
       }else{
           nGen--;
          JOptionPane.showMessageDialog(null, "Ya es el estado final");
       }
    }//GEN-LAST:event_nuevoExperimento1verAnimacion

    private void nuevoExperimento1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevoExperimento1KeyPressed
       nGen++;
        if(nGen<generaciones){
        String name="Gen"+nGen+".png";
        ImageIcon icon=new ImageIcon(name,"");
        jGrafico.setIcon(icon);   
       }else{
           nGen--;
          JOptionPane.showMessageDialog(null, "Ya es el estado final");
       }
    }//GEN-LAST:event_nuevoExperimento1KeyPressed

    private void nuevoExperimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevoExperimentoKeyPressed
        nGen--;
       if(nGen>-1){
        String name="Gen"+nGen+".png";
        ImageIcon icon=new ImageIcon(name,"");
        jGrafico.setIcon(icon);   
       }else{
           nGen++;
          JOptionPane.showMessageDialog(null, "Ya es el estado inicial");
       }
    }//GEN-LAST:event_nuevoExperimentoKeyPressed

    private void nuevoExperimento2verAnimacion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoExperimento2verAnimacion
        for (nGen=0;nGen<generaciones;nGen++){
            try {
                String name="Gen"+nGen+".png";
                ImageIcon icon=new ImageIcon(name,"");
                jGrafico.paint(jGrafico.getGraphics());
                jGrafico.setSize(icon.getIconWidth(), icon.getIconHeight());
                jGrafico.setIcon(icon);
                sleep(100);
                //System.out.println("img "+nGen);
            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        JOptionPane.showMessageDialog(null, "Ya finalizó la simulación");
       
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevoExperimento2verAnimacion

    private void nuevoExperimento2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevoExperimento2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevoExperimento2KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jDatos;
    private javax.swing.JLabel jGrafico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jcontenedorDatos;
    private javax.swing.JPanel jcontenedorGrafica;
    private javax.swing.JButton nuevoExperimento;
    private javax.swing.JButton nuevoExperimento1;
    private javax.swing.JButton nuevoExperimento2;
    private javax.swing.JButton verGeneracion;
    // End of variables declaration//GEN-END:variables

    private int reglaDeTransicion(int dS, int pL, int pS, int limit, int lL, int as, int vl, int vs) {
        int estado=4;
        pL=pL+lL;
        if (pL>limit)   pL=pL-limit;
        int dSL=pS-pL;
        if(dSL<0)   dSL=dSL+limit;
        
        if(dSL<dS){//Si la distancia entre cofre y parachoques es menor a la distancia de seguridad, frena
            estado=2;
        }else if(dSL>dS){
            if(vs<vl-1){
                estado=3;
            }
            else if(vs>vl+1){
                estado=2;
            }
        }
        return estado;
        //0 Negro colición
            //1 Naranja, frenado de emergencia
            //2 Rojo, fremando
            //3 verde, acelera 
            //4 azul, mantiene 
    }
}
