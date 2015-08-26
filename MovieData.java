package MainClasses;

import java.util.Hashtable;
import java.util.Map;

public class MovieData {
	
	private Map<String, Object> infoMap;
	
	MovieData()
	{
		infoMap = new Hashtable<String , Object>();
		setMapInfo();
	}


	private void setMapInfo()
	{		
		infoMap.put("title", "1");
		infoMap.put("year", "2");
		infoMap.put("rated", "3");
		infoMap.put("released", "4");
		infoMap.put("runtime", "5");
		infoMap.put("genre", "6");
		infoMap.put("director", "7");
		infoMap.put("writer", "8");
		infoMap.put("actors", "9");
		infoMap.put("plot", "10");
		infoMap.put("language", "11");
		infoMap.put("country", "12");
		infoMap.put("awards", "13");
		infoMap.put("poster", "14");
	}


	public Map<String, Object> GetInfo() {
		return infoMap;
	}


	public void SetInfo(Map<String, Object> listInfo) {
		this.infoMap = listInfo;
	}
}