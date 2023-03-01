def open_file():
    # в методе askopenfile задаем начальную директорию и тип файлов для отображения
    file = filedialog.askopenfile(initialdir=DOWNLOAD_DIRECTORY, mode='r', filetypes=[('Data Files', '*.dat')])

    # если файл был успешно выбран
    if file:
        # получаем его абсолютный путь
        filepath = os.path.abspath(file.name)

        # для построения графика нужен путь к файлу без расширения
        dataForPlotting = filepath.replace('.dat', '')