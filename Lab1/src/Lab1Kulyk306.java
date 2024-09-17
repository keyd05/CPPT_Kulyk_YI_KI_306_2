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
        if (nRows < 6) return;

        // Запитуємо у користувача символ для заповнення квадрата
        System.out.print("Введіть символ для заповнення: ");
        char symbol = scanner.next().charAt(0);

        // Створюємо двовимірний масив для зберігання символів квадрата
        char[][] arr = new char[nRows][nRows];

        // Створюємо об'єкт для запису даних у файл
        PrintWriter fout = new PrintWriter("MyFile.txt");

        // Заповнюємо квадрат символами
        for (int i = 0; i < nRows; ++i) {
            for (int j = 0; j < nRows; ++j) {
                // Заповнюємо квадрат за допомогою символу або пробілу
                if (j % (nRows/3) < (nRows/6)) {
                    arr[i][j] = ' ';
                }
                else {
                    arr[i][j] = symbol;
                }
                // Записуємо символ у файл та виводимо на екран
                fout.print(arr[i][j]);
                System.out.print(arr[i][j]);
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
