package ru.mirea.lab6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  Main {
    public static void main(String[] args) {
        Simple frame = new Simple();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Simple extends JFrame {
    JButton button = new JButton(" Угадать ");
    JLabel label = new JLabel("Ваша задача угадать число от 0 до 20");
    JTextField input = new JTextField(20);
    private int counter = 0;
    int range = 20;
    int rand = (int) (Math.random() * range);

        public Simple() {
            super("Game");
            this.setBounds(500, 200, 300, 300);
            Container content = this.getContentPane();
            content.setLayout(new FlowLayout(FlowLayout.CENTER,1,10));
            add(label);
            add(input);
            add(button);

            button.setBackground(Color.BLACK);
            button.setForeground(Color.GREEN);

            button.addActionListener(new ButtonEventListener());
        }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                counter++;
                String massage = "";
                int a = Integer.parseInt(input.getText());
                if(counter == 3) {
                    if (a == rand)
                    {
                        massage += "Вы угадали :D" + "\n";
                    }else {
                        massage += "Вы не уадали :(" + "\n";
                    }
                }
                else {
                    if (a > rand) {
                        massage += "Загаданое число меньше" + "\n";
                    }else {
                        massage += "Загаданое число больше" + "\n";
                    }
                }
            JOptionPane.showMessageDialog(null, massage, "Ответ", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
//System.exit(0);