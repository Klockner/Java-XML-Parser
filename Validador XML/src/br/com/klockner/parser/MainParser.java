/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.klockner.parser;

import br.com.klockner.provas.Prova2;

/**
 *
 * @author Gabriel
 */
public class MainParser {
    public static void main(String[] args) throws Exception {
        String fileXml = "Produtos.xml";
        
//        Prova1 prova1 = new Prova1(fileXml, "Vestidos são Moda Feminina?");
//        prova1.initParse();
        
        Prova2 prova2 = new Prova2(fileXml, "Encontrar calças tamanho plus size");
        prova2.initParse();
    
        //ReadXMLFile readXml = new ReadXMLFile();
        
        //readXml.parseRecursivo(fileXml);
        //readXml.parseRecursivoDois(fileXml);
        
        //ParseTag parseTag = new ParseTag();
        //parseTag.parseXml(fileXml);
        
    }
}
