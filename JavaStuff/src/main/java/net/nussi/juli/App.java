package net.nussi.juli;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ActionListener {
    static int step = 0;
    static int timer = 0;



    static App app = new App();
    static JFrame frame = new JFrame();
    static JLabel label = new JLabel();
    static JPanel panel = new JPanel();


    public static void main(String[] args) throws InterruptedException {



        Button button =new Button("Button");
        button.addActionListener(app);
        button.setVisible(true);


        label.setText("Step: " + step);
        button.setBackground(Color.RED);

        panel.add(button);
        panel.add(label);
        frame.add(panel);
        frame.setSize(300,100);
        frame.setVisible(true);




        while (true) {

            switch (step) {
                case 1: //WARTEN
                    timer++;
                    if(timer > 2000) {
                        step = 2;
                        button.setBackground(Color.green);
                    }
                    break;
                case 3: //WARTEN
                    timer++;
                    if(timer > 2000) {
                        step = 0;
                        button.setBackground(Color.RED);
                    }
                    break;
                default: //RESET TIMER
                    timer = 0;
                    break;
            }



            label.setText("Step: " + step + "   Timer: " + timer);
            Thread.sleep(1);
        }

    }

    public void actionPerformed(ActionEvent e) {


        switch (step) {
            case 0: //AUS
                step = 1;
                break;
            case 1: //WARTEN
                step = 0;
                break;
            case 2: //EIN
                step = 3;
                break;
            case 3: //WARTEN
                step = 2;
                break;
        }





        System.out.println("Step: " + step + "   Timer: " + timer);
    }

}
