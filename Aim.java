import  javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;

  public class Aim extends JPanel implements ActionListener, KeyListener, MouseListener {
    Timer t = new Timer (5,this);
    double highscore1 = 0.0, highscore2 = 0.0, highscore3 = 0.0, Hits = 0.0, mouseClicks = 0.0;
    double velx = 0, vely = 0, x = 380, y = 300;
    double currx = 0, curry = 0;
    int mousex = -1, mousey = -1, targetsHit = 0, totalTargets = 10, totalTargetsFinal = 10;
    int size1 = 60, size2 = 60;
    boolean check = false, calc = false, hit = false, first = false, reset = false;
    boolean d1 = true, d2 = false, d3 = false, move = false;
    
    public Aim(){
      t.start();
      addKeyListener(this);
      addMouseListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);

    }
    
  
    
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.fill(new Rectangle2D.Double(0,50,800,10));
      g2.fill(new Rectangle2D.Double(0,50,10,580));
      g2.fill(new Rectangle2D.Double(0,570,800,10));
      g2.fill(new Rectangle2D.Double(790,50,10,580));
      
      if (totalTargets > 0)
      g2.draw(new Ellipse2D.Double(x, y, size1, size2)); //x is left y is top

      
      g2.setColor(Color.RED);
      
      g2.drawString("Try to get the highest score possible! (Click 'R' to restart)" , 240, 80);
      g2.drawString("Hint: Click '1' , '2' or '3' to change the number of targets", 100, 560);
      
      String percent= String.format("%.3f", Hits/mouseClicks); 
      if (mouseClicks != 0)
        g2.drawString("Click (" + Hits + "/" + mouseClicks + "): " + percent, 50, 125);
      g2.drawString("Level 1 Score: " + highscore1, 625, 530);
      g2.drawString("Level 2 Score: " + highscore2, 625, 545);
      g2.drawString("Level 3 Score: " + highscore3, 625, 560);
      
    }
    
    public void update(double x) {
      if (d1 && highscore1 < x)
        highscore1 = x;
      else if (d2 && highscore2 < x)
        highscore2 = x;
      else if (d3 && highscore3 < x)
        highscore3 = x;
    }
    

    
    public void actionPerformed(ActionEvent e){
      repaint();
      
      if(x < 0 || x > 705)
        velx = -velx;
      if(y < 125 || y > 450)
        vely = -vely;
        
      x += velx;
      y += vely;
    }
    

    public void random(){      
      Random rGen = new Random();
      x = (rGen.nextInt(650)+70);
      y = (rGen.nextInt(250)+185);
    }
    
    public void randomM() {
      Random rGen = new Random();
      velx = (rGen.nextInt(5)-3);
      vely = (rGen.nextInt(5)-3);
    }
    
    public void keyPressed(KeyEvent e){
      int code = e.getKeyCode();
      
      if (code == KeyEvent.VK_1) {
        d1 = true;
        d2 = false;
        d3 = false;
        totalTargetsFinal = 10;
        totalTargets = 10;
        size1 = 60;
        size2 = 60;
      }
      
      if (code == KeyEvent.VK_2) {
        d2 = true;
        d1 = false;
        d3 = false;
        totalTargetsFinal = 25;
        totalTargets = 25;
        size1 = 30;
        size2 = 30;
      }
      
      if (code == KeyEvent.VK_3) {
        d3 = true;
        d1 = false;
        d2 = false;
        totalTargetsFinal = 35;
        totalTargets = 35;
        size1 = 15;
        size2 = 15;
      }
      
      if (code == KeyEvent.VK_R) {
        totalTargets = totalTargetsFinal;
        reset = true;
        random();
        reset = false;
      }
      
      if (code == KeyEvent.VK_M) {
        move = true;
        randomM();
      }
      
      if (code == KeyEvent.VK_S) {
        move = false;
        velx = 0;
        vely = 0;
      }

    }
    
    public void keyTyped(KeyEvent e){};
    public void keyReleased(KeyEvent e){};
    
    public void mouseClicked(MouseEvent e) {
      }



    @Override
    public void mousePressed(MouseEvent e) {
      mousex = e.getX();
      mousey = e.getY();
      currx = x;
      curry = y;
      if (mousex > currx) {
        if (mousex <= currx+size1) {
          if (mousey >= curry) {
            if (mousey <= curry+size2) {
              if (!first)
                 hit = true;
              first = true;
              totalTargets--;
              random();
              if (move)
                randomM();
              if (totalTargets != -1)
                Hits++;
            }
          }
        }
      }
      if (totalTargets != -1)
        mouseClicks++;
    }



    @Override
    public void mouseReleased(MouseEvent e) {
    }



    @Override
    public void mouseEntered(MouseEvent e) {
      // TODO Auto-generated method stub
      
    }



    @Override
    public void mouseExited(MouseEvent e) {
      // TODO Auto-generated method stub
      
    }

}