import os
import wfdb
import wfdb.io
from tkinter import *


class GraphDrawer:
    def __init__(self):
        return


    def drawGraph(self, file):
        # 3 - ПОЛУЧЕНИЕ ДАННЫХ ДЛЯ ОТРИСОВКИ

        # если файл был успешно выбран
        if file:
            # получаем его абсолютный путь
            filepath = os.path.abspath(file.name)

            # для построения графика нужен путь к файлу без расширения
            dataForPlotting = filepath.replace('.dat', '')

            # 4 - ОТРИСОВКА ГРАФИКА
            # номер нужен чтобы на графике отображался его номер (3 последнии цифры названия файла)
            recordNumber = dataForPlotting[-3:];

            # получить запись
            record = wfdb.rdrecord(record_name=dataForPlotting, sampto=3000);

            # получить аннотацию
            annotation = wfdb.rdann(record_name=dataForPlotting, extension='atr', sampto=3000);

            # построить график, используя полученные аннотацию и запись
            wfdb.plot_wfdb(record=record, annotation=annotation, plot_sym=True,
                           time_units='seconds', title='MIT-BIH Record {}'.format(recordNumber),
                           figsize=(10, 4), ecg_grids='all');

            # вывести данные об открытых файлах на панель окна
            Label(win, text="The File is located at : " + str(filepath), font=('Aerial 11')).pack()