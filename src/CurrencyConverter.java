import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame  {
    JFrame a = new JFrame("калькулятор валют");
    JButton convert = new JButton("конвертер");
    JButton calc = new JButton("калькулятор");

    JLabel title = new JLabel("Выберите валюту для конвертирования");

    public CurrencyConverter() {
        a.setLayout(null);
        a.setVisible(true);
        a.setExtendedState(JFrame.MAXIMIZED_BOTH);
        a.setBounds(150, 1, 1500, 1000);

        Font font_one = new Font("Arial",Font.PLAIN,24);
        Font font_two = new Font("Arial",Font.PLAIN,32);

        title.setBounds(500, 100, 600, 70);
        title.setFont(font_two);
        a.add(title);




        convert.setBounds(580,300 , 450, 170);
        convert.setFont(font_one);
        a.add(convert);
        calc.setBounds(580,500 , 450, 170);
        calc.setFont(font_one);
        a.add(calc);






        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.setVisible(false);
                new Middle_Stage_dollar();
            }
        });
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.setVisible(false);
                new Calculator();
            }
        });
    }
}
