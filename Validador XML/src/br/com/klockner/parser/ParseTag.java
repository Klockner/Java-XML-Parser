/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.klockner.parser;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author klockner
 */
public class ParseTag {
    
    public void parseXml(String xmlFileName) {
        try {
            File xmlFile = new File(xmlFileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            
            //optional, but recommended
            doc.getDocumentElement().normalize();

            System.out.println("Elemento Raiz: " + doc.getDocumentElement().getNodeName());
            
            NodeList nList = doc.getElementsByTagName("ProdutoDeModa");
            
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("\nElemento: " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    
                    System.out.println("SKU: " + element.getElementsByTagName("SKU").item(0).getTextContent());
                    System.out.println("Nome: " + element.getElementsByTagName("Nome").item(0).getTextContent());
                    System.out.println("Descrição: " + element.getElementsByTagName("Descricao").item(0).getTextContent());
                    System.out.println("Marca: " + element.getElementsByTagName("Marca").item(0).getTextContent());
                    System.out.println("Loja: " + element.getElementsByTagName("Loja").item(0).getTextContent());
                    System.out.println("Preco: " + element.getElementsByTagName("Preco").item(0).getTextContent());
                    System.out.println("Preco Promoção: " + element.getElementsByTagName("PrecoPromocao").item(0).getTextContent());
                    System.out.println("Número de parcelas: " + element.getElementsByTagName("NumeroDeParcelas").item(0).getTextContent());
                    System.out.println("Valor das parcelas: " + element.getElementsByTagName("ValorDaParcela").item(0).getTextContent());
                    System.out.println("URL: " + element.getElementsByTagName("URL").item(0).getTextContent());
                    System.out.println("URL da imagem: " + element.getElementsByTagName("URLImagem").item(0).getTextContent());
                    System.out.println("Preenchimento: " + element.getElementsByTagName("Preenchimento").item(0).getTextContent());
                    System.out.println("Cor: " + element.getElementsByTagName("Cor").item(0).getTextContent());
                    System.out.println("Textura: " + element.getElementsByTagName("Textura").item(0).getTextContent());
                    System.out.println("Tamanho: " + element.getElementsByTagName("Tamanho").item(0).getTextContent());
                    System.out.println("Classificação: " + element.getElementsByTagName("Classificacao").item(0).getTextContent());
                    System.out.println("Categoria: " + element.getElementsByTagName("Categoria").item(0).getTextContent());
                    System.out.println("Subcategoria: " + element.getElementsByTagName("Subcategoria").item(0).getTextContent());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Erro ao parsear o arquivo: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Erro no SAX: " + e.getMessage());
        }
    }
}
