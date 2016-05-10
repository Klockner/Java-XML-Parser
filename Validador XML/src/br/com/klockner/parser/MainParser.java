/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.klockner.parser;

/**
 *
 * @author Gabriel
 */
public class MainParser {
    public static void main(String[] args) throws Exception {
        String fileXml = "Produtos.xml";
    
        ReadXMLFile readXml = new ReadXMLFile();
        //readXml.parseXml(fileXml);
        
        //readXml.parseRecursivo(fileXml);
        
        readXml.parseRecursivoDois(fileXml);
        
        
    }
}
