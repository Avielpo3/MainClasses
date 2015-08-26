package MainClasses;

import java.awt.EventQueue;
import XmlWebService.OMDBGUI;


public class Program
{

	/**
	 * Here the program start's , Creating a frame for the user ,
	 * and initialize the program.
	 * @param args
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try
				{			
					OMDBGUI frame = new OMDBGUI();
					frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		}
				);
	}
}
