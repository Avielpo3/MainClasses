package MainClasses;

public class MovieDataServiceFactory  {

	/**
	 * Singleton pattern is a design pattern that restricts the instantiation of a class to one object.
	 * The singleton pattern must be carefully constructed in multi-threaded applications.
	 * This class is Singleton and Thread-Safe.
	 */

	/**
	 * The program  always need's OMDB_INSTANCE.
	 */
	public final static MovieDataServiceFactory OMDB_INSTANCE = new MovieDataServiceFactory();

	/**
	 * To make sure that the object cannot be instantiated any other way,
	 * the constructor is made private. 
	 * Private constructor. Prevents instantiation from other classes.
	 */
	private MovieDataServiceFactory(){}

	/**
	 * 
	 * @param data
	 * @return IMovieDataService
	 */
	public static IMovieDataService GetMovieDataService (MovieDataServiceFactory dataServiceFactory)
	{
			if(dataServiceFactory == OMDB_INSTANCE )
			{
				// Only 1 ,we don't have to check.
			}
			
			return new MovieDataService();
	}

}


