import java.io.*;
import java.util.*;

public class second
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір квадрата: ");
        int nRows = scanner.nextInt();

        // Якщо розмір квадрата менший за 6, програма завершується
        if (nRows < 6) {
            System.out.print("Введіть кількість більшу за 5");
            return;
        }

        // Запитуємо у користувача символ для заповнення квадрата
        System.out.print("Введіть символ для заповнення: ");
        String input = scanner.next();
        if(input.length() == 0) {
            System.out.print("Некорректний символ. Відсутній символ.");
            return;
        }
        else if(input.length() > 1) {
            System.out.print("Некорректний ввід. Забагато символів.");
            return;
        }
        char symbol = input.charAt(0);

        // Створюємо двовимірний масив для зберігання символів квадрата
        char[][] arr = new char[nRows][];
        for (int i = 0; i < arr.length; i++){
            if(nRows % 6 == 0) {
                arr[i] = new char[nRows/2];
            }
            else {
                arr[i] = new char[(nRows/6 + 1) * 3];
            }
        }

        PrintWriter fout = new PrintWriter("MyFile.txt");

        for (int i = 0; i < nRows; ++i) {
            int ArrIndx = 0;
            int rem = nRows % 6;
            for (int j = 0; j < rem; j++)
            {
                arr[i][j] = ' ';
                fout.print(arr[i][j]);
                System.out.print(arr[i][j]);
            }

            for (int j = rem; j < nRows; ++j) {
                if ((j-rem) / (nRows/6) % 2 == 0) {
                    fout.print(' ');
                    System.out.print(' ');
                }
                else {
                    arr[i][ArrIndx] = symbol;
                    fout.print(arr[i][ArrIndx]);
                    System.out.print(arr[i][ArrIndx]);
                    ArrIndx++;
                }
            }

            fout.print("\n");
            System.out.println();
        }

        fout.flush();
        fout.close();
    }
}
