package KI.Kulyk.Lab4;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) {
        try
        {
            PrintWriter fout = new PrintWriter("MyFile.txt");

            try
            {
                //Scanner in = new Scanner(System.in);
                //System.out.print("Введіть X: ");
                double x = Math.PI / 16; //in.nextDouble();

                double result = (Math.sin(x) * Math.sin(8 * x)) / Math.cos(8 * x);

                fout.print("\nРезультат обчислення y = sin(x) / ctg(8x) при х = " + x + ": " + result);
                System.out.print("\nРезультат обчислення y = sin(x) / ctg(8x) при х = " + x + ": " + result);

            }
            finally
            {
                fout.flush();
                fout.close();
            }
        }
        catch (CalcException e) {
            System.out.print(e.getMessage());

        }
        catch (IOException e) {
            System.out.print("Помилка відкриття файлу");
        }
    }
}
