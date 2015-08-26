package MainClasses;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import XmlWebService.MovieID;
import XmlWebService.MoviePlot;
import XmlWebService.MovieTitle;
import XmlWebService.YearOfRelese;

public class MovieDataService implements IMovieDataService {

	private String m_myUrlString = null;
	private InputStream m_inputStream = null;
	private HttpURLConnection m_myConnectionRef = null;
	private MovieData movieData;
	private BufferedImage image = null;
	
	MovieDataService()
	{
		//TODO C'tor if needed.
	}

	@Override
	public MovieData GetMovieData(String urlAddress) throws MovieDataServiceException {
		
		try 
		{
			//Connect to server:
			URL serverUrlAddress = new URL(urlAddress); // Take's the string from above and make it an URL address.
			
			m_myConnectionRef = (HttpURLConnection)serverUrlAddress.openConnection(); //Get reference For connection re-use.
			m_myConnectionRef.setRequestMethod("GET"); // Set request to HTTP , Get mode.
			m_myConnectionRef.connect();//Creating a connection.
			m_inputStream = m_myConnectionRef.getInputStream(); // Get inputStream from http Server.
			
			//Building the document with DocumentBuilderFactory (Xml to DOM):
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Static method , creating a new instance of DocumentBuilderFactory
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			org.w3c.dom.Document doc = documentBuilder.parse(m_inputStream);			
			doc.getDocumentElement().normalize();
			NodeList sonNodes = doc.getElementsByTagName("*"); // Get all Elements , there are 2 elements, 'movie' or an 'Error'.
			String movieOrError = sonNodes.item(1).getNodeName(); //Get's into String the answer if the movie found (or not).
			
			//Choose if Error or not:
			if (movieOrError == "error") 
			{
				throw new MovieDataServiceException("Sorry , I could not find the movie you seeked , Try again");
			}
			
			//there are no error , Make actions on the object we created:
			NodeList elementsList = doc.getElementsByTagName(movieOrError);
			Node node = elementsList.item(0);
			Element element = (Element)node;
			movieData = new MovieData();			
			
			//Get all movie data.
			for ( Entry<String, Object> entry : movieData.GetInfo().entrySet() )
			{
				entry.setValue(element.getAttribute(entry.getKey()));
			}
			
			//Try get a picture
			try
			{
				serverUrlAddress = new URL((String)movieData.GetInfo().get("poster"));
				image = ImageIO.read(serverUrlAddress);
				movieData.GetInfo().put("poster", image);
			}
			catch (MalformedURLException e) 
			{
				//TODO
			} 
		
			
			//Return as object all the data.
			return movieData; 
			
		}

		
		
		//Throw's my Exception in every RunTime Exception.
		catch (MalformedURLException e) 
		{
			throw new MovieDataServiceException( "The URL is invalid or not found ", e) ;
		} 

		catch (IOException e) 
		{
			throw new MovieDataServiceException( "The URL is valid , but didnt succsed to connect the HTTP", e) ;
		} 

		catch (ParserConfigurationException e)
		{
			throw new MovieDataServiceException( "Problem has accured when parsing the XML file", e) ;
		} 

		catch (SAXException e)
		{
			throw new MovieDataServiceException( "SAX problem , cannot parsse the XML", e) ;
		}
		
		//finally block , close all resources.
		finally 
		{
			if (inputStream() != null )
			{
				try {
					inputStream().close();
				}
				
				catch (IOException e)
				{
					throw new MovieDataServiceException(e) ;
				}
			}
			if (myConnectionRef() != null )
			{
				myConnectionRef().disconnect();
			}
		}
	}

	@Override
	public MovieData getMovieData(MovieTitle movietitle)
			throws MovieDataServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YearOfRelese getYearOfRelese(MovieTitle movietitle)
			throws MovieDataServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public YearOfRelese getYearOfRelese(MovieID movieId)
			throws MovieDataServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MoviePlot getPlot(MovieTitle movieTitle, MoviePlot plotKind)
			throws MovieDataServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MoviePlot getPlot(MovieID movieID, MoviePlot plotKind)
			throws MovieDataServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	


	public InputStream inputStream() {
		return m_inputStream;
	}

	public void inputStream(InputStream m_inputStream) {
		this.m_inputStream = m_inputStream;
	}

	public HttpURLConnection myConnectionRef() {
		return m_myConnectionRef;
	}

	public void myConnectionRef(HttpURLConnection m_myConnectionRef) {
		this.m_myConnectionRef = m_myConnectionRef;
	}

	public String myUrlstring() {
		return m_myUrlString;
	}

}

