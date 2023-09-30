# Получение данных
def get_info():
    with open("info.txt", "r") as f:
        for line in f.readlines():
            Xi = [int(x) for x in line.split()]
            N = len(Xi)
        f.close()
        return Xi, N


# Формула
def equation(B, n, Xi):
    return sum([1 / (B - i + 1) for i in range(1, n + 1)]) - (n * sum(Xi)) / (
            (B + 1) * sum(Xi) - sum([(i + 1) * Xi[i] for i in range(n)]))


# Производная
def derivative(B, n, Xi):
    return -1 * sum([1 / (B - i + 1) ** 2 for i in range(1, n + 1)]) + (sum(Xi) ** 2 * n) / (
            sum(Xi) * (B + 1) - sum([(i + 1) * Xi[i] for i in range(n)])) ** 2


# Вычисление K
def K(B, n, Xi):
    K = n / ((B + 1) * sum(Xi) - sum((i + 1) * Xi[i] for i in range(1, n)))
    return K


# Вычисление Xn+1
def Xn1(n, B, K):
    return 1 / (K * (B - n))


# Вычисление tk
def tk(n, B, K):
    tk = 0
    for i in range(1, int(B) - n + 1):
        tk += 1 / i
    return (1 / K) * tk


# Ввод параметров
accuracy = 0.0001
Xi, n = get_info()
counter = 0
b0 = 26
b1 = 26.5
counter = 0
# Основной цикл нахождения B
while (abs(b1 - b0) > accuracy) or counter > 50:
    b1, b0, b_1 = b0 - equation(b0, n, Xi) / derivative(b0, n, Xi), b1, b0
    counter += 1

# Вывод данных
print("Общее количество ошибок в программе B =", round(b1, 4), "итераций понадобилось", counter, sep=" ", end="\n")
K = K(b1, n, Xi)
print("Коэффициент пропорциональности K =", round(K, 4), end="\n")
Xn = Xn1(n, b1, K)
print("Среднее время Xn+1 =", round(Xn, 4), end="\n")
tK = tk(n, b1, K)
print("Время до окончания тестирования tk =", round(tK, 4), end="\n")
