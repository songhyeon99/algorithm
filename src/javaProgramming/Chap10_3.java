package javaProgramming;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFramess extends JFrame{
    public MyFramess() {
        setTitle("Left키로 문자열 교체");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        JLabel j=new JLabel("Love Java");
        c.add(j);
        c.setFocusable(true);
        c.requestFocus();
        c.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if(e.getKeyCode()==KeyEvent.VK_LEFT) {
                    String text=j.getText();
                    if(text.equals("Love Java")) {
                        j.setText("avaJ evoL");
                    }
                    else {
                        j.setText("Love Java");
                    }
                }
            }
        });

        setSize(300,300);
        setVisible(true);
    }
}

public class Chap10_3 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MyFramess();
    }
}
