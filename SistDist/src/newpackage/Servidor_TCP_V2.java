/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author JKM😎ᓚᘏᗢ AND BRENOX1000😁
 */
public class Servidor_TCP_V2 {
    
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket socketDoServidor = new ServerSocket(5566);
            System.out.println("Aguardando requisição de arquivo de arquivo ...");
            while(true){
                Socket socketDeConexao = socketDoServidor.accept();
                BufferedReader bufferEntrada = new BufferedReader(new InputStreamReader(socketDeConexao.getInputStream()));
                
                String diretorioDoServidor = "C:\Users\thiag\Downloads\SistDist\src\newpackage\dir";
                
                String requisicao = diretorioDoServidor + bufferEntrada.readLine();
                System.out.println(requisicao);
                
                File novoArquivo = new File(requisicao);
                
                PrintWriter bufferDeSaida = new PrintWriter(socketDeConexao.getOutputStream(), true);
                
                BufferedOutputStream bf = new BufferedOutputStream(socketDeConexao.getOutputStream());
                
                if(novoArquivo.exists() == true){
                    bufferDeSaida.println("1");

                    System.out.println("ele existe");
                    
                    byte[] arquivoEmByte = new byte[(int) novoArquivo.length()];
                    FileInputStream fis = new FileInputStream(novoArquivo);
                    fis.read(arquivoEmByte);
                    fis.close();
                    
                    TratamentoDeArquivosServidorV2 arquivoASerEnviado = new TratamentoDeArquivosServidorV2();
                    
                    arquivoASerEnviado.setNome(requisicao);
                    arquivoASerEnviado.setConteudo(arquivoEmByte);
                    
                    byte[] bytea = serializarArquivo(arquivoASerEnviado);
                    bf.write(bytea);
                    bf.flush();
                    
                } else if (novoArquivo.exists() == false){
                    bufferDeSaida.println("0");
                    System.out.println("ele n existe");
                }
                
                //bufferEntrada.close();
                //bufferDeSaida.close();
                //bf.close();
                //socketDeConexao.close();
                //socketDoServidor.close();
                
            }
        } catch (IOException e) {
        }
        
    }
    
    
    
    private static byte[] serializarArquivo(TratamentoDeArquivosServidorV2 arquivo){
        try {
           ByteArrayOutputStream bao = new ByteArrayOutputStream();
           ObjectOutputStream ous;
           ous = new ObjectOutputStream(bao);
           ous.writeObject(arquivo);
           return bao.toByteArray();
        } catch (IOException e) {
        }

        return null;
    }
    
}
