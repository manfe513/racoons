from Downloader import Downloader

# 1 - ЗАГРУЗКА ФАЙЛОВ
Downloader().download()

# 2 - СОЗДАНИЕ ОКНА ПРОГРАММЫ (tinker)
# создаем экземпляр окна tkinter
win = Tk();

# задаем его размеры
win.geometry("700x350");

label = Label(win, text="Click the Button to browse the Files", font=('Georgia 13'));

label.pack(pady=10);

# добавить кнопку на окно (для открытия диалога выбора файла)
ttk.Button(win, text="Browse", command=open_file).pack(pady=20)

win.mainloop()

# 3 - ПОЛУЧЕНИЕ ДАННЫХ ДЛЯ ОТРИСОВКИ
def open_file():
    # в методе askopenfile задаем начальную директорию и тип файлов для отображения
    file = filedialog.askopenfile(initialdir=DOWNLOAD_DIRECTORY, mode='r', filetypes=[('Data Files', '*.dat')])

    # если файл был успешно выбран
    if file:
        # получаем его абсолютный путь
        filepath = os.path.abspath(file.name)

        # для построения графика нужен путь к файлу без расширения
        dataForPlotting = filepath.replace('.dat', '')


# 4 - ОТРИСОВКА ГРАФИКА