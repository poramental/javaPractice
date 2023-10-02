import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.IIOException;
import javax.swing.*;

public class Convert_ruble_to_dollar extends JFrame implements  ActionListener{
    private final JFrame a = new JFrame("Конвертер рос.рубли в доллары");
    public final JButton convert = new JButton("Конвертировать");
    public JButton return_back = new JButton("Вернуться назад");
    private final JTextField input = new JTextField();
    private final JTextField res = new JTextField();
    public final JLabel input_label = new JLabel("Введите количество российских рублей: ");
    public final JLabel result = new JLabel("Результат в долларах: ");

    Convert_ruble_to_dollar(){
        a.setBounds(150, 1, 1500, 1000);
        a.setVisible(true);
        a.setLayout(null);

        Font font_one = new Font("Arial",Font.PLAIN,24);
        Font font_two = new Font("Arial",Font.PLAIN,32);

        input_label.setBounds(455,100,800,70);
        input_label.setFont(font_two);

        input.setBounds(455,200,800,70);
        input.setFont(font_one);

        result.setBounds(455,400,800,70);
        result.setFont(font_two);

        res.setBounds(455,500,800,70);
        res.setFont(font_one);

        convert.setBounds(455,700,800,70);
        convert.setFont(font_one);

        return_back.setBounds(10,600,300,70);
        return_back.setFont(font_one);

        a.add(input_label);
        a.add(input);
        a.add(result);
        a.add(res);
        a.add(convert);
        a.add(return_back);

        convert.addActionListener(this);

        return_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.setVisible(false);
                new Middle_Stage_dollar();
            }
        });
    }

    public static double toDollar(double rub) {
        return rub / Main.curr_dollar();
    }
    @Override
    public void actionPerformed(ActionEvent event)  {
        String input_text = input.getText();
        double rub = Double.parseDouble(input_text);
        double dollar = rub / Main.curr_dollar();
        res.setText(String.format("%.2f российских рублей = %.2f долларов", rub, dollar));
    }
}
