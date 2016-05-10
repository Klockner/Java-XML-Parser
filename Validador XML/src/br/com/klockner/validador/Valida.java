/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.klockner.validador;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Gabriel
 */
public class Valida {
    /**
     * Método que faz a validação de arquivos XML.
     *
     * @param fullFileName
     * @param xsdFullFileName
     * @return
     * @throws Throwable
     */
    public static boolean validate(String fullFileName, String xsdFullFileName) throws Throwable {
        // Cria a factory.
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        // Habilita suporte a namespace. 
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setValidating(true);
        // Atributos para validação.
        documentBuilderFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        documentBuilderFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", xsdFullFileName);
        // Cria uma builder para obter o Document de um .xml
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        // Guarda os erros de validação. 
        ErrorHandler errorHandler = new ErrorHandler();
        documentBuilder.setErrorHandler(errorHandler);
        // Declara as variaveis a serem utilizadas.
        Document document = null;
        try {
            // Primeiro parse.
            document = documentBuilder.parse(fullFileName);
        } catch (SAXException e) {
            e.getMessage();
        }
        SchemaFactory schemaFactory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
        // carrega um WXS schema, representada por uma instacia Schema.
        Source schemaFile = new StreamSource(new File(xsdFullFileName));
        Schema schema = schemaFactory.newSchema(schemaFile);
        // Cria um objeto ValidationHandler que pode ser usado para validar uma instancia document.
        Validator validator = schema.newValidator();
        // Indica o objeto que irá tratar os error. Observe que ao encontrar
        // um erro, este é simplesmente guardado e processo de validação continua.
        try {
            // Efetua a validação propriamente.
            validator.validate(new DOMSource(document));
        } catch (Exception e) {
            // Se algum erro foi encontrado, apresenta-o.
            if (!errorHandler.handlerList.isEmpty()) {
                for (String error : errorHandler.handlerList) {
                    System.out.println(error);
                }
            }
            return false;
        }
        return true;
    }
}