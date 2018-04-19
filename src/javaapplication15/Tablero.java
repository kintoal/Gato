/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 * Jpanel dado que voy a pintar en el Canvas
 * ActionListener: Para poder ejecutar el escenario cada ciertos milisegundos
 */
public class Tablero extends JPanel implements ActionListener{
    private Timer timer ;
    private int x;
    private int y;
    private Image tanque;
    private int posicionTanque;
    private int secuencia;
    private int numero ; 
    
    public Tablero(){
        //Lanza un evento de tipo ActionListener cada 25 Milisegundo
        //Se hace referencia a this porque la misma clase (Tablero) procesa el evento
        this.timer = new Timer(25, this);
        this.x=0;
        this.y=0;
        this.numero=0;
        this.secuencia = 0;
        this.posicionTanque= 1;
        this.tanque = this.loadImage(this.posicionTanque + ".png");
        
        
        //Registrar evento del Teclado
        setFocusable(true); //Debe estar en modo Focus para que puede detectar el evento
        addKeyListener(new EventosTeclado()); //Inner class que procesa los eventos del teclado
        this.timer.start(); //Inicio con el escenario
    }
        
    //Inner class Que captura los eventos del teclado
     private class EventosTeclado extends KeyAdapter {
        //Cuando se suelta una tecla
         @Override
        public void keyReleased(KeyEvent e) {
//           int key = e.getKeyCode();
//           if (key == KeyEvent.VK_SPACE) {
//            System.out.println("VK_SPACE"); //Se  va usar posteriormente 
//           }
        }
        //Cuando se presiona una tecla
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_RIGHT){
             if(posicionTanque!=18)
               posicionTanque++;
            }
            
            if(key == KeyEvent.VK_LEFT){
             if(posicionTanque!=0)
              posicionTanque--;
            }
            
            
            
            
        }
    }
    
    //Metodo donde se pintan los objetos 
     @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       
   
       Image fondo = loadImage("fondo.png");
        g.drawImage(fondo,-x, 0, null);
    
       
       this.tanque = this.loadImage(this.posicionTanque + ".png");
       g.drawImage(tanque, x, 250, this);
       g.drawRect(x, 350, 185, 100);
       
       if(this.numero % 10 == 0){
       
            
       if(this.secuencia == 5){
         this.secuencia = 0;
       }else{
         this.secuencia++;
       }
       }
       Image gato = loadImage("cats.gif");
       g.drawImage(gato, 10+x, 300, 142+x, 450, 132*this.secuencia, 0, 132*(this.secuencia)+132, 80, this);
       
    }

    //Metodo que se ejecuta cada vez que se lanza un ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Repaint");
        this.numero++;
        this.x++;
        repaint();
    }

     public Image loadImage(String imageName) {
       ImageIcon ii = new ImageIcon(imageName);
       Image image = ii.getImage();
       return image;
    }
     

}
