    import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
  import javax.swing.JFrame;
  import javax.swing.JLabel;
  import javax.swing.JTextArea;
  public class Aim_Run {

    public static void main(String args[]){
      boolean done = false;
      JFrame f = new JFrame("Jon's Aim Simulator");
      JFrame intro = new JFrame("Welcome!");
      Aim a = new Aim();
      f.setSize(800, 600);
      TimerT t = new TimerT();
      a.add(t);
      f.add(a);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JTextArea text = new JTextArea("\n\t\t     Jon's Aim Simulator");
      text.setFont(new Font ("Comic Sans MS", Font.BOLD, 20));
      JLabel lab1 = new JLabel("<html> <pre> Click on the shapes in the fastest time to get the lowest score! <br/><br/><br/> -                 Exit this screen to start!                   -</html>" , JLabel.CENTER);
      text.setSize(800,100);
      intro.setSize(800,600);
      lab1.setSize(60,60);
      intro.add(text);
      intro.add(lab1);
      intro.setVisible(true);
      f.setResizable(false);
      while (!done) {
        System.out.print("");
        if (a.totalTargets == 0) {
          t.stop();
          a.update(t.counter);
          while (!a.reset) { 
            System.out.print("");
            }
          t.counter = 30000.00;
          t.start();
          }
        if (a.reset) {
          t.counter = 30000.00;
          t.start();
        }
        if (a.hit) {
          t.start();
          a.hit = false;
        }
     }
 }

  }

