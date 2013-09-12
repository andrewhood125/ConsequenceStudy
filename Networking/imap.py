import socket, ssl, base64
print 'I love computer networks!'
# Choose a mail server (e.g. Google mail server) and call it mailserver
mailserver = ('imap.gmail.com', 993)
# Create socket called clientSocket and establish a TCP connection with mailserver
sslSocket = ssl.wrap_socket(socket.socket(socket.AF_INET, socket.SOCK_STREAM),
ssl_version = ssl.PROTOCOL_SSLv23)
sslSocket.connect(mailserver)
#Fill in start 
recv = sslSocket.recv(1024)
print recv

#login to server
def login(user,passW):
    sslSocket.send('a001 login '+ user + ' ' + passW + '\r\n')
    printSSL()
    
def examine(selectionFolder):
    sslSocket.send('a002 Select' + ' ' + selectionFolder + '\r\n')
    printSSL()  

def listMail(box):
    sslSocket.send('a003 LIST "' + box + '" "*"\r\n')
    recv = sslSocket.recv(1024)
    printSSL()

def search(searchSTR):
    sslSocket.send('a004 SEARCH X-GM-RAW "' + searchSTR + '"\r\n')
    printSSL()
    
def fetch(fetNum):
    sslSocket.send('a005 FETCH ' + fetNum + '(FLAGS BODY[HEADER])\r\n')
    printSSL()
    
def create(newBox):
    sslSocket.send('a006 CREATE ' + newBox + '\r\n') 
    printSSL() 
    
def delete(killBox):  
    sslSocket.send('a007 DELETE ' + killBox + '\r\n') 
    printSSL()
    
def logout():
    print 'BYE!'
    sslSocket.send('a010 logout\r\n')
    printSSL()
    
def printSSL():
    recv = sslSocket.recv(1024)
    print recv

#    print 'What is your GMail Username?'
#    user = raw_input()
#    print 'What is your password?(If you trust me I guess?)'
#    passW = raw_input()  
user = "networkprojneal@gmail.com"
passW = "network3825" 	
 
login(user,passW)
listMail("Test")
examine("Test")
search("Test")
fetch("1")
create("testCreate2")
delete("testCreate")
logout()