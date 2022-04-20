import threading

from socket import *

serverName = '127.0.0.1'
serverPort = 4040
clientSocket = socket(AF_INET, SOCK_DGRAM)
clientSocket.connect((serverName, serverPort))



def main(mensagem, cliente):


    mensagem = mensagem.split(",")

    try:
        for i in mensagem:

            clientSocket.send((str(i)+";"+cliente).encode())
            modifiedSentence = clientSocket.recv(1024)

            print("Respostas ", modifiedSentence.decode())

    except Exception as e:
        print(" ")


if __name__ == '__main__':

    respostas_1 = threading.Thread(target=main, args=["1;4;VVVF,2;3;VFF,3;4;VVFV,4;4;VFFV,5;5;VFVFV", "John"])
    respostas_2 = threading.Thread(target=main, args=["1;4;VFVF,2;3;FVV,3;4;FVFF,4;4;VFVV,5;5;FVVFV", "Hugo"])
    respostas_3 = threading.Thread(target=main, args=["1;4;FFFV,2;3;VFV,3;4;VFFF,4;4;VVFV,5;5;FFVFV", "Claudia"])

    respostas_1.start()
    respostas_2.start()
    respostas_3.start()