package Pojo;

import java.util.List;

public class Courses {

	
	private List<WebAutomation> webAutomation;
	private List<Api> Api;
	private List<Mobile> Mobile;
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<Api> getApi() {
		return Api;
	}
	public void setApi(List<Pojo.Api> api) {
		this.Api = api;
	}
	public List<Mobile> getMobile() {
		return Mobile;
	}
	public void setMobile(List<Pojo.Mobile> mobile) {
		this.Mobile = mobile;
	}
	
	
}
