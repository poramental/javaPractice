import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends JFrame implements ActionListener {

    private final JFrame a = new JFrame("Калькулятор валют");
    public final JButton calc = new JButton("посчитать");
    private final JTextField input = new JTextField();
    private final JTextField resRub = new JTextField();
    private final JTextField resDol = new JTextField();
    public final JLabel resultRubLabel = new JLabel("Результат в российских рублях: ");
    public final JLabel resultDolLabel = new JLabel("Результат в долларах: ");
    public final JLabel input_label = new JLabel("введите выражение ( например: 80.75$ - 50.76р): ");
    public JButton return_back = new JButton("Вернуться назад");

    Calculator(){
        a.setBounds(150, 1, 1500, 1000);
        a.setVisible(true);
        a.setLayout(null);

        Font font_one = new Font("Arial",Font.PLAIN,24);
        Font font_two = new Font("Arial",Font.PLAIN,32);

        input.setBounds(455,100,800,70);
        input.setFont(font_two);

        return_back.setBounds(10,600,300,70);
        return_back.setFont(font_one);

        resRub.setBounds(455,500,370,70);
        resRub.setFont(font_one);

        resDol.setBounds(860,500,370,70);
        resDol.setFont(font_one);

        resultDolLabel.setBounds(860,400,370,70);
        resultDolLabel.setFont(font_one);

        resultRubLabel.setBounds(455,400,370,70);
        resultRubLabel.setFont(font_one);

        input_label.setBounds(455,100,800,70);
        input_label.setFont(font_two);


        calc.setBounds(455,700,800,70);
        calc.setFont(font_two);

        input.setBounds(455,200,800,70);
        input.setFont(font_two);

        a.add(input);
        a.add(input_label);
        a.add(resRub);
        a.add(resDol);
        a.add(return_back);
        a.add(calc);
        a.add(resultDolLabel);
        a.add(resultRubLabel);
        calc.addActionListener(this);
        return_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.setVisible(false);
                new Middle_Stage_dollar();
            }
        });
    }

    private boolean isDOLLARinExpression(String expr){

        return expr.contains("$");
    }

    private boolean isRUBinExpression(String expr){
        return expr.contains("р");
    }

    private String whatIsOperation(String expr) throws Exception{
        if(expr.contains("+"))
            return "+";
        if(expr.contains("-"))
            return "-";
        else
            throw new Exception("nep vvod");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String expr = input.getText();
        double dollar = 0;
        double rub = 0;
        double resultRub;
        double resultDollar;
        if(isDOLLARinExpression(expr)){
            System.out.println(expr);
            Matcher m = Pattern.compile("([0-9.]+?)\\$").matcher(expr);
            while(m.find()){
                String dollarStr = m.group().strip();
                try {
                    dollar += Double.parseDouble(dollarStr.strip().replaceAll("\\$", ""));
                }
                catch (Exception ex) {
                    System.out.println("nepravilno vvedeno");
                }
            }

        }

        if(isRUBinExpression(expr)){
            Matcher m = Pattern.compile("([0-9.]+?)р").matcher(expr);
            while(m.find()){
                String rubStr = m.group();
                try {
                    rub += Double.parseDouble(rubStr.strip().replaceAll("р", ""));
                }
                catch (Exception ex) {
                    System.out.println("nepravilno vvedeno");
                }
            }
        }
        try {
            if (whatIsOperation(expr) == "+"){
                resultRub = Convert_dollar_to_ruble.toRub(dollar) + rub;
                resultDollar = Convert_ruble_to_dollar.toDollar(rub) + dollar;
            }else{
                if(expr.indexOf("$") > expr.indexOf("р")) {
                    resultRub = rub - Convert_dollar_to_ruble.toRub(dollar);
                    resultDollar = Convert_ruble_to_dollar.toDollar(rub) - dollar;
                }else{
                    resultRub = Convert_dollar_to_ruble.toRub(dollar) - rub;
                    resultDollar = dollar - Convert_ruble_to_dollar.toDollar(rub);
                }
            }
            resRub.setText(resultRub +"");
            resDol.setText(resultDollar +"");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
