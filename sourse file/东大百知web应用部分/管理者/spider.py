
import requests
import pymysql
from bs4 import BeautifulSoup
import bs4
import re
import string


#db =pymysql.connect(host='localhost:3306',user='root',password='000000',db='web',charset="utf8")

#cursor.execute("DROP TABLE IF EXISTS COLOR")
#sql = """create table webinfo(
                #id int(11) not null auto_increment primary key,
                #name varchar(255) not null,
                #urlName varchar(255) not null"""



 
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
        #name = eval(plt[i].split(':')[1])
        ulist.append([a['href'],a['title']])


def printGoods(ulist):
    tplt = "{:2}\t{:8}\t{:16}"
    print(tplt.format("序号", "名称", "地址"))

    count = 0
    conn = pymysql.connect(host='localhost', user='root', password='000000', db='web',charset="utf8")

    cur = conn.cursor()

    sqlc = '''
                create table testOne(
                id int(11) not null auto_increment primary key,
                name varchar(255) not null,
                urlName varchar(255) not null
                '''

    ##try:
      ##  A = cur.execute(sqlc)
      ##  conn.commit()
      ##  print('成功1')
    ##except:
       ## print("错误1")
    for g in ulist:
        count = count + 1
        b=tplt.format(count, g[1], g[0])
        print(b)
        sqla = '''
        insert into testOne(name,urlName)
        values(%s,%s);
       '''
        try:
            B = cur.execute(sqla,(g[1],g[0]))
            conn.commit()
            #print('成功2')
        except:
            print("错误2")

        # save_path = 'D:/taobao.txt'
        # f=open(save_path,'a')
        #
        # f.write(b+'\n')
        # f.close()

    conn.commit()
    cur.close()
    conn.close()


def main():
    
    uinfo = []
    url = 'http://www.graduate.neu.edu.cn/dongda/qgtk/index.jhtml'
    html = getHTMLText(url)
    fillUnivList(uinfo,html)
    for page in range(2,6):
        url = 'http://www.graduate.neu.edu.cn/dongda/qgtk/index' + '_' + str(page) + '.jhtml'
        html = getHTMLText(url)
        fillUnivList(uinfo,html)
    print(uinfo)
    print('\n')
    print('\n')
    printGoods(uinfo)

    
main()
