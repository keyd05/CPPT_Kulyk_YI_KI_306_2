import java.io.*;
import java.util.*;

public class Lab1Kulyk306
{
   public static void main(String[] args) throws FileNotFoundException
   {
       Scanner scanner = new Scanner(System.in);

       System.out.print("Введіть розмір квадрата: ");
        int nRows = scanner.nextInt();
        if (nRows < 3) return;

        System.out.print("Введіть символ для заповнення: ");
        char symbol = scanner.next().charAt(0);

        char[][] arr = new char[nRows][nRows];
        PrintWriter fout = new PrintWriter("MyFile.txt");

        for (int i = 0; i < nRows; ++i) {
            for (int j = 0; j < nRows; ++j) {
                if (j % (nRows/3) < (nRows/6)) {
                    arr[i][j] = ' ';
                }
                else {
                    arr[i][j] = symbol;
                }
                fout.print(arr[i][j]);
                System.out.print(arr[i][j]);
            }

            fout.print("\n");
            System.out.println();
        }

        fout.flush();
        fout.close();
    }
}
