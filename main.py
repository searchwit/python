# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
from PyPDF2 import PdfFileReader
from nltk.tokenize import word_tokenize
import nltk
import pandas as pd
import os


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.

def read_excel(path):
    df = pd.read_excel(path, sheet_name=0)
    print(type(df))
    print(df.head(2))
    df_last_col = df["Country"]
    # df_col = df_last_col.sort_values("Year")
    # print(df_col.head(10))
    print(df_last_col.head(10))
    # s = set(df_last_col)
    word_list = df_last_col.drop_duplicates().to_list()
    s = set(word_list)
    print(s)
    return s

def get_info(path):
    with open(path, 'rb') as f:
        pdf = PdfFileReader(f)
        info = pdf.getDocumentInfo()
        number_of_pages = pdf.getNumPages()

    print(info)
    print(number_of_pages)
    author = info.author
    creator = info.creator
    producer = info.producer
    subject = info.subject
    title = info.title

def text_extractor(path):
    with open(path, 'rb') as f:
        pdf = PdfFileReader(f)
        number_of_pages = pdf.getNumPages()
        # get each page
        for index in range(0, number_of_pages):
           page = pdf.getPage(index)
           print(page)
           print('=========================')
           text = page.extractText()
           print(text)
           word_list = word_tokenize(text)
           print(word_list)
           print('********************************')

def tick_count(path, path_excel):
    count_dict = {}
    tick_set = read_excel(path_excel)
    with open(path, 'rb') as f:
        pdf = PdfFileReader(f)
        number_of_pages = pdf.getNumPages()
        # get each page
        for index in range(0, number_of_pages):
           page = pdf.getPage(index)
           print(page)
           print('=========================')
           text = page.extractText()
           print(text)
           word_list = word_tokenize(text)
           print(word_list)
           print('********************************')
           word_list.append("Germany")
           word_list.append("Canada")
           for word_token in word_list:
               if(word_token in tick_set) :
                   print(word_token)
                   if (word_token in count_dict):
                       count_dict[word_token] +=1
                   else:
                       count_dict[word_token] = 1
           print(count_dict)

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    path="c:/test/test.pdf"
    # print_hi('PyCharm')
    # get_info(path)
    # text_extractor(path)
    path2="c:/test/test2.xlsx"
    # read_excel(path2)
    tick_count(path, path2)

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
