import os

import wfdb

from Const import DOWNLOAD_DIRECTORY


class Downloader:
    def __init__(self):
        return

    def __hasFile(self, fileName):
        return os.path.isdir(fileName)

    def download(self):
        if self.__hasFile(DOWNLOAD_DIRECTORY):
            print('Files already exists!')
        else:
            wfdb.io.dl_database \
                (db_dir='mitdb', dl_dir=DOWNLOAD_DIRECTORY,
                 records='all', annotators='all', keep_subdirs=True, overwrite=False)