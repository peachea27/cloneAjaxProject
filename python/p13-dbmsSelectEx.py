import pymysql

try :
   dbConnection = pymysql.connect(host="127.0.0.1",port=3306, user='root',password="yona",db="lyh",charset='utf8')
except :
    print("DB접속에러")
else :
    print(dbConnection)
    cursor = dbConnection.cursor() #Statement객체와 같은 역할
    sql = "select * from member where userId=%s and userPwd=sha1(md5(%s))"
    cursor.execute(sql, ('tosimi','1234'))
    result = cursor.fetchone()
    print(result)

    sql = "select * from member"
    cursor.execute(sql)
    result = cursor.fetchall()
    for row in result :
        print(row[0], end=", ")
        print(row[1], end=", ")
        print(row[2])
    dbConnection.close()
