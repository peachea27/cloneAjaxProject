import pymysql

try :
   dbConnection = pymysql.connect(host="127.0.0.1",port=3306, user='root',password="yona",db="lyh",charset='utf8')
except :
    print("DB접속에러")
else :
    print(dbConnection)
    cursor = dbConnection.cursor()

    sql = "insert into hboard(title, writer, content) values(%s, %s, %s)"
    result = cursor.execute(sql, ('파이썬 DB insert', 'tosimi', ',인서트 잘되나요'))
    print(result)
    if result == 1 :
        dbConnection.commit()
    
    dbConnection.close()