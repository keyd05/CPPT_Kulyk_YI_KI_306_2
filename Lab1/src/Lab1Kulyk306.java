import java.io.*;
import java.util.*;

/**
 * Клас Lab1Kulyk306 містить метод main, який дозволяє користувачеві
 * ввести розмір квадрата та символ для його заповнення, після чого
 * квадрат буде виведений на екран та збережений у файл.
 */
public class Lab1Kulyk306
{
    /**
     * Запитує в користувача розмір квадрата та символ для його заповнення,
     * малює квадрат та записує його у файл.
     *
     * @param args Аргументи командного рядка (не використовується).
     * @throws FileNotFoundException якщо файл для запису не вдається створити.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        // Створюємо сканер для зчитування даних з консолі
        Scanner scanner = new Scanner(System.in);

        // Запитуємо у користувача розмір квадрата
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

        // Створюємо об'єкт для запису даних у файл
        PrintWriter fout = new PrintWriter("MyFile.txt");

        // Заповнюємо квадрат символами
        for (int i = 0; i < nRows; ++i) {
            int arrIndx = 0;
            for (int j = 0; j < nRows; ++j) {
                // Заповнюємо квадрат за допомогою символу або пробілу
                if (j % (nRows/3) < (nRows/6)) {
                    fout.print(' ');
                    System.out.print(' ');
                }
                else {
                    arr[i][arrIndx] = symbol;
                    fout.print(arr[i][arrIndx]);
                    System.out.print(arr[i][arrIndx]);

                    arrIndx++;
                }
            }
            // Додаємо новий рядок у файл і на екран
            fout.print("\n");
            System.out.println();
        }

        // Закриваємо файл після запису
        fout.flush();
        fout.close();
    }
}
