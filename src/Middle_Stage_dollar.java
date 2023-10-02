import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Middle_Stage_dollar extends  JFrame{
    JFrame a = new JFrame("Выбор способа перевода");
    JLabel title = new JLabel("Выберите способ перевода валюты");
    JButton dollar_to_ruble = new JButton("Доллары в рос.рубли");
    JButton ruble_to_dollar = new JButton("рос.рубли в доллары");
    JButton return_back = new JButton("Вернуться назад");


    public Middle_Stage_dollar(){
        a.setLayout(null);
        a.setVisible(true);
        a.setBounds(150, 1, 1500, 1000);

        Font font_one = new Font("Arial",Font.PLAIN,24);
        Font font_two = new Font("Arial",Font.PLAIN,32);

        title.setBounds(550,100,600,70);
        title.setFont(font_two);
        a.add(title);

        dollar_to_ruble.setBounds(580,250,450,170);
        dollar_to_ruble.setFont(font_one);
        a.add(dollar_to_ruble);

        ruble_to_dollar.setBounds(580, 450, 450, 170);
        ruble_to_dollar.setFont(font_one);
        a.add(ruble_to_dollar);

        return_back.setBounds(10,600,300,70);
        return_back.setFont(font_one);
        a.add(return_back);

        dollar_to_ruble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.setVisible(false);
                new Convert_dollar_to_ruble();
            }
        });

        ruble_to_dollar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.setVisible(false);
                new Convert_ruble_to_dollar();
            }
        });

        return_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.setVisible(false);
                new CurrencyConverter();
            }
        });
    }
}
