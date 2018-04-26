import requests
from bs4 import BeautifulSoup
import bs4
import re
import string
 
def getHTMLText(url):
    try:
        r = requests.get(url, timeout=30)
        r.raise_for_status()
        r.encoding = r.apparent_encoding
        return r.text
    except:
        return ""
 
def fillUnivList(ulist,html):
    soup = BeautifulSoup(html, "html.parser")
    for a in soup.find('div',class_='msgUnit_list').find('ul').find_all('a'):
        #if isinstance(tr, bs4.element.Tag):
        #print(a['href'])
        #print(a['title'])
        ulist.append([a['href'],a['title']])

     
def main():
    uinfo = []
    url = 'http://www.graduate.neu.edu.cn/dongda/qgtk/index.jhtml'
    html = getHTMLText(url)
    fillUnivList(uinfo,html)
    # printUnivList(uinfo, 20) # 20 univs
    print(uinfo)
main()
