
/**
*@author:jonafrank
*@description: Utility for parsing the custom XML
**/

import model.Article;
import model.Author;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;

public class XMLParser 
{
  public static List<Article> parseXML(String fileName) 
  {
    Article       article  = null;
    Author        author   = null;
    List<Article> articles = new ArrayList<>();

    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    
    try 
    {
      XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));//Reading file as a stream to facilitate scaling
      
      while(xmlEventReader.hasNext())
      {
        XMLEvent xmlEvent = xmlEventReader.nextEvent();
        
        if (xmlEvent.isStartElement())
        {
          StartElement startElement = xmlEvent.asStartElement();
          
          if(startElement.getName().getLocalPart().equals("Article"))                                     //If the event is a start of Article tag => create a new Article Object
          {
            article = new Article();
          }
          else if(startElement.getName().getLocalPart().equals("ArticleTitle"))                           //Add Article title to the Article POJO
          { 
            xmlEvent = xmlEventReader.nextEvent();
            article.setArticleTitle(xmlEvent.asCharacters().getData());
          }
          else if(startElement.getName().getLocalPart().equals("Author"))                                 //If the event is a start of Author tag => create a new Author Object
          {
            author = new Author();
          }
          else if(startElement.getName().getLocalPart().equals("LastName"))                               //Add the corresponding data to the POJO
          {
            xmlEvent = xmlEventReader.nextEvent();
            author.setLastName(xmlEvent.asCharacters().getData());
          }
          else if(startElement.getName().getLocalPart().equals("ForeName"))
          {
            xmlEvent = xmlEventReader.nextEvent();
            author.setFirstName(xmlEvent.asCharacters().getData());
          }
          else if(startElement.getName().getLocalPart().equals("Initials"))
          {
            xmlEvent = xmlEventReader.nextEvent();
            author.setInitials(xmlEvent.asCharacters().getData());
          }
        }
        if(xmlEvent.isEndElement())
        {
           EndElement endElement = xmlEvent.asEndElement();
           
           if(endElement.getName().getLocalPart().equals("Article"))                                      //If the event is the end of an Article add Object to list of Articles
           {
              articles.add(article);
           }
           else if(endElement.getName().getLocalPart().equals("Author"))
           {
              article.addAuthor(author);
           }

        }  
      }    
    }
    catch (FileNotFoundException | XMLStreamException e) 
    {
        e.printStackTrace();
    }

    return articles;
  }
}