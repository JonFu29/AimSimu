import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TimerT extends JPanel{
JLabel promptLabel, timerLabel;
Double counter = 30000.00;
JTextField tf;
JButton button, buttonEnd;
Timer timer;
boolean click = false;

public TimerT(){  
  timerLabel = new JLabel("Waiting...", (SwingConstants.CENTER));
  add(timerLabel);
      
  timerLabel.setFont(new Font ("Comic Sans MS", Font.BOLD, 20));
  timerLabel.setText("Score: " + counter);
  
  TimeClass tc = new TimeClass(counter);
  timer = new Timer(1,tc);
}

public void restart() {
  timer.restart();
}

public void stop() {
  timer.stop();
}

public void start() {
  timer.start();
}


public class TimeClass implements ActionListener {
  
  public TimeClass(Double count) {
    counter = count;
  }
  
  public void actionPerformed(ActionEvent tc) { 
    counter --;
    if (counter >= 1) {
       timerLabel.setText("Your Score: " + counter);
    } else {
      timer.stop();
      timerLabel.setText("Time Up!");
    }
  }
}
public static void main (String args[]) {
  TimerT gui =  new TimerT();
  gui.setSize(500,100);
  gui.setVisible(true);
  
}
}
