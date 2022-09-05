package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages {
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	private WebElement Loginbtn;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement txtusername;
	@FindBy(xpath="//input[@type='password']")
	private WebElement txtpassword;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement clicklogin;
	public WebElement getLoginbtn() {
		return Loginbtn;
	}
	public void setLoginbtn(WebElement loginbtn) {
		Loginbtn = loginbtn;
	}
	public WebElement getTxtusername() {
		return txtusername;
	}
	public void setTxtusername(WebElement txtusername) {
		this.txtusername = txtusername;
	}
	public WebElement getTxtpassword() {
		return txtpassword;
	}
	public void setTxtpassword(WebElement txtpassword) {
		this.txtpassword = txtpassword;
	}
	public WebElement getClicklogin() {
		return clicklogin;
	}
	public void setClicklogin(WebElement clicklogin) {
		this.clicklogin = clicklogin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
