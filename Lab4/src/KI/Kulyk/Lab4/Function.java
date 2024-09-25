package KI.Kulyk.Lab4;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Клас, що реалізує обчислення виразу y = sin(x) / ctg(8x)
 */
public class Function {

    /**
     * Обчислює значення виразу y = sin(x) / ctg(8x).
     *
     * @param x Значення аргументу x.
     * @return Результат обчислення виразу.
     * @throws ArithmeticException якщо вираз не може бути обчислений (наприклад, через ділення на нуль).
     */
    public static double Calculate(double x) throws ArithmeticException {
        try {
            PrintWriter file = new PrintWriter(new FileWriter("MyFile.txt", true));

            if (Math.cos(8 * x) == 0) {
                throw new ArithmeticException("y не визначений при x=" + x);
            }

            double result = (Math.sin(x) * Math.sin(8 * x)) / Math.cos(8 * x);
            file.println("Результат обчислення y = sin(x) / ctg(8x) при х = " + x + ": " + result);
            System.out.println("Результат записано у файл!");
        }
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Помилка відкриття файлу!");
        }
    }

}
