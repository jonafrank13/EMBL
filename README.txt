Hi,

Invoke Runner class to generate the output.

a) The solution outline goes as follows

	1) Parse the XML as a stream to facilitate large dataset in future.
	2) First get the "SET" of unique Authors in the list of Articles.
	3) Now initialize the count matrix with the size of the Authors "SET".
	4) Iterate through the list of Articles now and get the set of Authors for the articles
	5) Now iterate through the matrix of authors and increment the count for the corresponding Author combination in the Array.
	6) Print the results

	-The solution can support multiple authors (more than 2 in each article)
	-In-case optimization in terms of speed and memory is required, the conversion to POJO can be dropped and the matrix can be updated on the fly while parsing the XML stream.


b) The TestSuite can be done as follows
	
	1) Different XML inputs can be initially be generated to test all the edge cases eg : No specific tag, No author list, Malformed XML etc
	2) The POJO classes can be tested using their Getters and Setters to check functionality and edge cases again.
	3) Exception handling can be tested (Not implemented owing to time constraints - Handling can be done for Null Pointer, Array OutofBounds , FileNotFound <basic> and for Memory , Streams <Advanced> etc)
	4) Each function can be tested for a given input vs calculated output
	5) The test suite will contain End to End and functional (Unit tests), Starting from the Macroscopic view to the microscopic functionality.


c) When scaling to such a large dataset, In-memory consumption needs to be reduced. If the POJO classes are dropped, (Added here in my solution for structure and In-case processing is required using the field values<For easily scaling it>) ; The updation of the count matrix can be done on the fly, while parsing the XML document. What can be done is that the matrix can be dynamically grown to support new authors, Initialize the matrix with the Authors from the first Article, increment the count to 1 each, Next when the new article is encountered , The Matrix can be updated for the count of existing authors or expanded to support new Authors, This can be done by creating a wrapper to the Native Array implementation or using the ArrayList implementation directly. Ideally this problem can be solved easily if the XML is converted to JSON and indexed using "ElasticSearch" which natively provides an aggregation function with it's REST api. Technically all these records will be distributed across several nodes in a cluster, All these records can be streamed to the processing server where this program will be run, As we are parsing the XML data as a stream already, the 1st step for scaling it is covered, Next instead of maintaining the List of Articles in memory, As stated earlier we can process the data on the fly while processing the stream by dynamically updating the count matrix (Expand in-case of a new author/Update cell in case of a existing author), This solution is given mainly to showcase the structuring of code.