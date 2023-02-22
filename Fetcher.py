import os
import sys
import zipfile
import wget

from Const import FILES_ARCHIVE_NAME, FILES_DIR, FILES_URL


class Fetcher:
    def __init__(self):
        return

    def __bar_progress(self, current, total):
        progress_message = "Downloading: %d%% [%d / %d] bytes" % (current / total * 100, current, total)
        sys.stdout.write("\r" + progress_message)
        sys.stdout.flush()

    def __hasFile(self, fileName):
        return os.path.isfile(fileName)

    def download(self):
        if self.__hasFile(FILES_DIR):
            print('Files already exists!')
        elif self.__hasFile(FILES_ARCHIVE_NAME):
            with zipfile.ZipFile(FILES_ARCHIVE_NAME, 'r') as zip_ref:
                zip_ref.extractall(FILES_DIR)
            print('Files unzipped')

        else:
            wget.download(FILES_URL, FILES_ARCHIVE_NAME, self.__bar_progress)
            self.download()
        print('Files ready')
