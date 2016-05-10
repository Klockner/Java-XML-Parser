/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.klockner.validador;

/**
 *
 * @author Gabriel
 */
public class Main {
    
    public static void main(String[] args) throws Throwable {
        String fileXml = "Produtos.xml";
        String fileXsd = "Produto.xsd";
        
        boolean isValido = Valida.validate(fileXml, fileXsd);
        if (isValido) {
            System.out.println("Documento XML válido");
        } else {
            System.out.println("Documento XML inválido");
        }
    }
}
