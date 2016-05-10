/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.klockner.provas;

import br.com.klockner.util.OpenFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author klockner
 */
public class Prova1 {
    private final OpenFile openFile;
    private final Document doc;
    private final String tituloProva;
    
    public Prova1(String xmlFileName, String tituloProva) {
        this.tituloProva = tituloProva;
        openFile = new OpenFile();
        doc = openFile.createDoc(xmlFileName);
    }
    
    public void initParse() {
        System.out.println(tituloProva);
        System.out.println("-----------------------------");
        
        //System.out.println("Elemento Raiz: " + doc.getDocumentElement().getNodeName());

        //Pega só os nós com "ProdutoDeModa"
        NodeList nodeList = doc.getElementsByTagName("ProdutoDeModa");
        
        //Percorre os nodes da árvore de "ProdutoDeModa"
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                if (element.getElementsByTagName("Categoria").item(0).getTextContent().equalsIgnoreCase("vestido")) {
                    System.out.println("Elemento: " + nNode.getNodeName());
                    System.out.println("SKU: " + element.getElementsByTagName("SKU").item(0).getTextContent());
                    System.out.println("Nome: " + element.getElementsByTagName("Nome").item(0).getTextContent());
                    System.out.println("Categoria: " + element.getElementsByTagName("Categoria").item(0).getTextContent());
                    System.out.println("Classificação: " + element.getElementsByTagName("Classificacao").item(0).getTextContent());
                    System.out.println("\nVESTIDO É " + element.getElementsByTagName("Classificacao").item(0).getTextContent());
                }
            }
        }
    }
}
