import ssl

from Fetcher import Fetcher

ssl._create_default_https_context = ssl._create_unverified_context

Fetcher().download()
