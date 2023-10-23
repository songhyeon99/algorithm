package javaProgramming;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class MyFrames extends JFrame{

    public MyFrames() {
        setTitle("JSlider Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        JSlider js=new JSlider(100, 200, 120);
        JLabel jl=new JLabel("120");
        js.setMajorTickSpacing(20);
        js.setPaintTicks(true);
        js.setPaintLabels(true);
        js.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider temp=(JSlider)e.getSource();
                jl.setText(Integer.toString(temp.getValue()));
            }
        });
        c.add(js);

        jl.setBackground(Color.green);
        jl.setOpaque(true);
        c.add(jl);

        setSize(300,300);
        setVisible(true);
    }
}

public class Chap11_5 {
    public static void main(String[] args) {
        new MyFrames();
    }
}