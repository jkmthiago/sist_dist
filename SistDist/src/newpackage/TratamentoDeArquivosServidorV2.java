/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JKM😎ᓚᘏᗢ AND BRENOX1000😁
 * Lado Cliente
 */
public class TratamentoDeArquivosServidorV2 implements Serializable {
   
   /**
    * Por Que Serializar?
    * Dessa forma podemos criar uma cadeia de bytes usando
    * a implementação do seriável, além de manter cliente
    * e servidor atualizados em versões iguais e/ou 
    * compatíveis.
    */
   private static final long serialVersionUID = 20194060L;
   
   /**
    * Variáveis que irão indicar características ao arquivo a ser transformado em uma cadeia de bytes[].
    * 
    * OBS_01: Aquela que tiverem transient ao lado não são serializadas, ou seja, não fazem parte da cadeia
    *         de bytes.
    * 
    * OBS_02: Está senddo usado o typo byte pois todo e qualquer arquivo é nada mais que uma cadeia de 
    *         bytes, e como não temos como saber o tipo de arquivo a ser enviado, é mais fácil trans-
    *         formá-lo em cadeia de bytes e junto ser enviado algumas informações características.
    */
   
   private String nomeDoArquivo;
   private byte[] conteudo;
   
   /* Sequência de Gets e Sets                                 */
   /* Dessa forma podemos ou capturar ou indicar um novo valor */
   
   /**
    * Captura ou definição de nome
    * @return 
    */
   public String getNome() {
             return nomeDoArquivo;
   }
   public void setNome(String nome) {
             this.nomeDoArquivo = nome;
   }
   
   /**
    * Captura ou definição do conteúdo 
     * @return 
    */
   public byte[] getConteudo() {
             return conteudo;
   }
   public void setConteudo(byte[] conteudo) {
             this.conteudo = conteudo;
   }
       
}
