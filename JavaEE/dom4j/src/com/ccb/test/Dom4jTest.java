package com.ccb.test;


import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {
    @Test
    public void test1(){
        SAXReader saxReader = new SAXReader();
        try {
            Document dom = saxReader.read("xml/books.xml");
            Element rootElement = dom.getRootElement();
            //System.out.println(rootElement);
            List<Element> books = rootElement.elements("book");
            for(Element book : books){
                //System.out.println(book.asXML());
                System.out.println(book.element("name").getText());
                System.out.println(book.elementText("price"));
                System.out.println(book.attributeValue("sn"));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
