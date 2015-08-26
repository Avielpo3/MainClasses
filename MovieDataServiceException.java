package MainClasses;

public class MovieDataServiceException extends Exception {

	private static final long serialVersionUID = 1L;


	public MovieDataServiceException (String msg )
	{
		super(msg);
	}
	
	public MovieDataServiceException (String msg ,Throwable cause )
	{
		super(msg , cause);
	}
	
	public MovieDataServiceException (Throwable cause )
	{
		super(cause);
	}
	 
}
