import wfdb


class Downloader:
    def __init__(self):
        return


    def download(self):
        wfdb.io.dl_database\
            (db_dir='mitdb',dl_dir=DOWNLOAD_DIRECTORY,
            records='all', annotators='all', keep_subdirs=True, overwrite=False);
