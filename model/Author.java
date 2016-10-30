package model;

/**
*@author:jonafrank
*@description: POJO class for the Author Object
**/

/*
<Author>
	<LastName>Public</LastName>
	<ForeName>J	Q</ForeName>
	<Initials>JQ</Initials>
</Author>
*/

public class Author
{
	private String lastName;
	private String firstName;
	private String initials;

	public void setLastName(String lastName)
	{
		this.lastName = lastName.trim();
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName.trim();
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setInitials(String initials)
	{
		this.initials = initials.trim();
	}

	public String getInitials()
	{
		return this.initials;
	}

	public String getFullName()
	{
		return this.lastName+" "+this.firstName+" "+this.initials;
	}
}