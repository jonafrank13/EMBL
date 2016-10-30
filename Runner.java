
/**
*@author:jonafrank
*@description: Simple runner class for the program
**/

import model.Article;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Runner
{
  public static void main(String[] args) 
  {
    String        FILENAME       = "data.xml";					 //Defining the file name for the xml
    List<Article> articles       = XMLParser.parseXML(FILENAME); //Calling the custom XML Parser
    Set<String>   authorSet      = new LinkedHashSet<String>();  //Holds the set of Authors for all Articles
    ArrayList<String> authorList = new ArrayList<String>();		 //Converted to list to access indexOf property 

    for(Article article : articles)
    {
      authorSet.addAll(article.getAuthorSet());					 //First we create the set of all authors			
    }

    int count[][] = new int[authorSet.size()][authorSet.size()]; //Initializing a 2D count array for the authors by Language specs its initialized to 0

    authorList = new ArrayList<String>(authorSet);				 //Converting the Set to List and destroying the set object
    authorSet  = null;

    for(Article article : articles)
    {
      Set<String> articleAuthorSet = article.getAuthorSet();	 //Getting the author set of each article

      for(String row : authorList)								 //Iterating the matrix and incrementing count for the corresponding element
      {
        for(String column : authorList)
        {
          if(articleAuthorSet.contains(row) && articleAuthorSet.contains(column))
          {
            count[authorList.indexOf(row)][authorList.indexOf(column)] = count[authorList.indexOf(row)][authorList.indexOf(column)] += 1; 
          }
        }
      }
    }

    System.out.print("\t");										 //Formatting and printing the output
    for(String author : authorList)
    {
      System.out.print(author+"\t");
    }
    System.out.println("");
    for(int i = 0 ; i < authorList.size() ; i++)
    {
      System.out.print(authorList.get(i)+"\t");
      for(int j=0 ; j < authorList.size() ; j++)
      {
        System.out.print(count[i][j]+"\t\t");
      }
      System.out.println("");
    }
  }
}