# Запитуємо у користувача розмір квадрата
n_rows = int(input("Введіть розмір квадрата: "))

# Якщо розмір квадрата менший за 6, програма завершується
if n_rows < 6:
    print("Введіть кількість більшу за 5")
    exit()

# Запитуємо у користувача символ для заповнення квадрата
symbol = input("Введіть символ для заповнення: ")

if len(symbol) == 0:
    print("Некорректний символ. Відсутній символ.")
    exit()
elif len(symbol) > 1:
    print("Некорректний ввід. Забагато символів.")
    exit()

symbol = symbol[0]

# Створюємо двовимірний масив для зберігання символів квадрата
arr = []
for i in range(n_rows):
    if n_rows % 6 == 0:
        arr.append([symbol] * (n_rows // 2))
    else:
        arr.append([symbol] * ((n_rows // 6 + 1) * 3))

# Заповнюємо квадрат символами
for i in range(n_rows):
    arr_indx = 0
    for j in range(n_rows):
        # Заповнюємо квадрат за допомогою символу або пробілу
        if j % (n_rows // 3) < (n_rows // 6):
            print(' ', end='')
        else:
            print(arr[i][arr_indx], end='')
            arr_indx += 1
    # Додаємо новий рядок на екран
    print()

