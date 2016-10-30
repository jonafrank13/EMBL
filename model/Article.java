package model;

/**
*@author:jonafrank
*@description: POJO class for the Article Object
**/

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

/*
<Article>
	<ArticleTitle>Title	1</ArticleTitle>
	<AuthorList>
		<Author>
			<LastName>Public</LastName>
			<ForeName>J	Q</ForeName>
			<Initials>JQ</Initials>
		</Author>
		<Author>
			<LastName>Doe</LastName>
			<ForeName>John</ForeName>
			<Initials>J</Initials>
		</Author>
	</AuthorList>
</Article>
*/

public class Article
{
	private String articleTitle;
	private List<Author> authorList = new ArrayList<Author>();

	public void setArticleTitle(String articleTitle)
	{
		this.articleTitle = articleTitle;
	}

	public String getArticleTitle()
	{
		return this.articleTitle;
	}

	public void addAuthor(Author author)
	{
		this.authorList.add(author);
	}

	public List<Author> getAuthorList()
	{
		return this.authorList;
	}

	public Set<String> getAuthorSet()
	{
		Set<String> authorSet = new HashSet<String>();

		for(Author author : authorList)
		{
			authorSet.add(author.getFullName());
		}

		return authorSet;
	}
}