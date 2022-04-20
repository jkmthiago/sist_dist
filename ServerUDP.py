from socket import *

respostas_corretas = [("V", "V", "V", "F"), ("V", "F", "V", "F"), ("F", "V", "V", "F"), ("V", "V", "F", "F"), ("V", "V", "F", "F")]

def main():

    serverPort = 4040
    serverSocket = socket(AF_INET, SOCK_DGRAM)
    serverSocket.bind(('', serverPort))
    print("Servidor aguardando...")

    while 1:

        message, clientAddress = serverSocket.recvfrom(2048)
        message = message.decode().split(";")
        print("Recebido", (message[3] + ": " + message[0] + ";" + message[1] + ";" + message[2]).encode())

        x = 0
        y = 0

        for i in message[2]:

            if i == "V":
                x += 1
            else:
                y += 1



        modifiedMessage = (message[3] + ": " + message[0] + ";" + str(x) + ";" + str(y)).encode()
        serverSocket.sendto(modifiedMessage, clientAddress)


if __name__ == '__main__':
    main()