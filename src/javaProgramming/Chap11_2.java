package javaProgramming;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyFrame extends JFrame{
    JTextField jt=new JTextField(10);
    JComboBox jc=new JComboBox();
    public MyFrame() {
        setTitle("JTextField and JComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        jt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField j=(JTextField)e.getSource();
                String temp=j.getText();
                j.setText("");
                jc.addItem(temp);
            }
        });

        c.add(jt);
        c.add(jc);

        setSize(300,300);
        setVisible(true);
    }
}

public class Chap11_2 {
    public static void main(String[] args) {
        new MyFrame();
    }
}
