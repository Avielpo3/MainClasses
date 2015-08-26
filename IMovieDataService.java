package MainClasses;

import XmlWebService.MovieID;
import XmlWebService.MoviePlot;
import XmlWebService.MovieTitle;
import XmlWebService.YearOfRelese;

public interface IMovieDataService {
	/**
	 * This InterFace is containing all the methods that other developers
	 * or users will use to draw information from the Server.
	 * 
	 * The server that we use is OMDB (IMDB) to get info about movies/TV series.
	 * The following methods are available for now..
	 */


	/**
	 * Search movie by a valid id.
	 * @param movieId
	 * @return MovieData
	 * @throws MovieDataServiceException
	 */
	public MovieData GetMovieData(String urlAddress) throws MovieDataServiceException ;

	/**
	 * Search movie by title.
	 * @param movietitle
	 * @return MovieTitle
	 * @throws MovieDataServiceException
	 */
	public MovieData getMovieData (MovieTitle movietitle) throws MovieDataServiceException;

	/**
	 * Get Year of release for the movie by name.
	 * @param movietitle
	 * @return
	 * @throws MovieDataServiceException
	 */
	public YearOfRelese getYearOfRelese (MovieTitle movietitle) throws MovieDataServiceException;

	/**
	 * Get Year of release for the movie by ID.
	 * @param movieId
	 * @return
	 * @throws MovieDataServiceException
	 */
	public YearOfRelese getYearOfRelese (MovieID movieId) throws MovieDataServiceException;

	/**
	 * Get movie plot by title , and chose plot kind : SHORT / FULL.
	 * @param movieTitle
	 * @param plotKind
	 * @return MoviePlot
	 * @throws MovieDataServiceException
	 */
	public MoviePlot getPlot (MovieTitle movieTitle , MoviePlot plotKind ) throws MovieDataServiceException;

	/**
	 * Get movie plot by ID , and chose plot kind : SHORT / FULL.
	 * @param movieID
	 * @param plotKind
	 * @return
	 * @throws MovieDataServiceException
	 */
	public MoviePlot getPlot (MovieID movieID , MoviePlot plotKind ) throws MovieDataServiceException;


	
}
