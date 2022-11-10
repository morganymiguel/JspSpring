package kr.or.ddit.enumpkg;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

public enum BrowserType {
	TRIDENT("IE"), EDG("엣지"), CHROME("크롬"), SAFARI("사파리"), FIREFOX("파이어폭스"), OTHER("기타");
	
	private BrowserType(String browserName) {
		this.browserName = browserName;
	}

	private String browserName;
	
	public String getBrowserName() {
		return browserName;
	}
	
	public static BrowserType searchBrowser(HttpServletRequest req){
 		String agent = req.getHeader("User-Agent");
 		agent = Objects.toString(agent, "").toUpperCase();
		
		BrowserType searched = BrowserType.OTHER;
		for(BrowserType tmp : BrowserType.values()){
			if(agent.indexOf(tmp.name())>-1){
				searched = tmp;
				break;
			}
		}
		
		return searched;
	}
	
	public static String searchBrowserName(HttpServletRequest req) {
		return searchBrowser(req).getBrowserName();
	}
}










