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
public class Prova2 {
    private final OpenFile openFile;
    private final Document doc;
    private String tamanho;
    private final String tituloProva;
    
    public Prova2(String xmlFileName, String tituloProva) {
        openFile = new OpenFile();
        doc = openFile.createDoc(xmlFileName);
        this.tituloProva = tituloProva;
    }
    
    public void initParse() {
        System.out.println(tituloProva);
        System.out.println("-----------------------------");
        
        NodeList nodeList = doc.getElementsByTagName("ProdutoDeModa");
        boolean isPlusSize = false;
        
        //Percorre os nodes da árvore de "ProdutoDeModa"
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                if (element.getElementsByTagName("Categoria").item(0).getTextContent().equalsIgnoreCase("calça")) {
                    
                    for (int j = 0; j < element.getElementsByTagName("Tamanho").getLength(); j++) {
                        isPlusSize = false;
                        tamanho = element.getElementsByTagName("Tamanho").item(j).getTextContent();

                        if (tamanho.matches("G|GG|GGG")) {
                            isPlusSize = true;
                        }
                    }
                    if (isPlusSize) {
                        System.out.println("Elemento: " + nNode.getNodeName());
                        System.out.println("SKU: " + element.getElementsByTagName("SKU").item(0).getTextContent());
                        System.out.println("Nome: " + element.getElementsByTagName("Nome").item(0).getTextContent());
                        System.out.println("Categoria: " + element.getElementsByTagName("Categoria").item(0).getTextContent());
                    }
                }
            }
            System.out.println();
        }
    }
}
