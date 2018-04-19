/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel  implements ActionListener {

    private final int DELAY = 100;
    private final int VELOCIDAD = 90;
    private final int ANGULO = 45;

    private Timer timer;
    private int x, y;
    private double vx, vy;
    private double t;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        setBackground(Color.WHITE);
        this.x= 100;
        this.y = 100;
        this.t = 0;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g.fillRect(x, y, 50, 50);
    }

    /**
     * 
     Vx = V cos θ
     Vy = V sen θ
     Con estos datos, ya podemos calcular la posición de las coordenadas X e Y en cada instante, sabiendo cuál era la posición inicial 
    ( Xi y Yi ) con la siguiente fórmula:

     X = Xi + Vxt
     Y = Yi + Vy t + ½ gt2
     
     * Siendo t el número de segundos transcurridos desde el inicio del disparo, y g la constante de gravitacion a utilizar, 
     * (por ejemplo en la Tierra es de 9.8  m/s2). 
   
     * @param e 
     */
   
    @Override
    public void actionPerformed(ActionEvent e) {
        vx =  VELOCIDAD* Math.cos(Math.toRadians(ANGULO));
        vy =  VELOCIDAD * Math.sin(Math.toRadians(ANGULO));
        
        this.x = (int)(this.x + vx*t);
        this.y = (int)(this.y + vx*t + (0.5*-9.8)*t*t);
        t += 0.01;
        repaint();
    }
}