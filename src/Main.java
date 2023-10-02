
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        new CurrencyConverter();
    }

    public static double curr_dollar() {
        String path = System.getProperty("user.dir") + "\\src\\dollar_curr.txt";
        System.out.println(path);
        double curr_dol = -1;
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            curr_dol = Double.parseDouble(bufferedReader.readLine());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return curr_dol;




    }
}