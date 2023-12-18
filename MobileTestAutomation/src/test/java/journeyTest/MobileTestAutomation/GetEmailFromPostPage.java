package journeyTest.MobileTestAutomation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GetEmailFromPostPage {

	@FindBy(how = How.ID, using = "com.myc.journeydemo:id/search_src_text")
	private WebElement searchTextBox;

	@FindBy(how = How.ID, using = "com.myc.journeydemo:id/tv_title")
	private WebElement postClick;

	@FindBy(how = How.ID, using = "com.myc.journeydemo:id/tv_email")
	private List<WebElement> emailList;

	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public void setSearchTextBox(WebElement searchTextBox) {
		this.searchTextBox = searchTextBox;
	}

	public WebElement getPostClick() {
		return postClick;
	}

	public void setPostClick(WebElement postClick) {
		this.postClick = postClick;
	}

	public List<WebElement> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<WebElement> emailList) {
		this.emailList = emailList;
	}

}
