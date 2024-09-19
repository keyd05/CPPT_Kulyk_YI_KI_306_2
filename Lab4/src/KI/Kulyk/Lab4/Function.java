package KI.Kulyk.Lab4;

import java.io.FileWriter;
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
        if (x == 0 || x == Math.PI/16 || x == 3*Math.PI/16) {
            throw new ArithmeticException("Ділення на нуль: ctg(8x) не може дорівнювати нулю.");
        }

        double result = Math.sin(x) * Math.tan(8*x);

        try {
            writeResultToFile(x, result);
            System.out.println("Результат записано у файл!");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Записує результат обчислення у файл.
     *
     * @param result Результат обчислення.
     * @throws IOException якщо виникає помилка запису у файл.
     */
    public static void writeResultToFile(double inputX, double result) throws IOException {
        try (FileWriter writer = new FileWriter("MyFile.txt")) {
            writer.append("Результат обчислення y = sin(x) / ctg(8x) при х = " + inputX + ": " + result);
        }
    }
}
