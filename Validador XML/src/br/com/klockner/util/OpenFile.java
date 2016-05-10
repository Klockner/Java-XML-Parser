/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.klockner.util;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author klockner
 */
public class OpenFile {
    
    public Document createDoc(String xmlFileName) {
        try {  
            File xmlFile = new File(xmlFileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            //optional, but recommended
            doc.getDocumentElement().normalize();
            
            return doc;
        } catch (Exception e) {
            System.out.println("Erro ao abrir o documento xml: " + e.getMessage());
            return null;
        }
    }
}
