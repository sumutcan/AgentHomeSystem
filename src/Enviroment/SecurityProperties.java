package Enviroment;

public class SecurityProperties {
	
	boolean frontDoorIsClean;
	boolean backDoorIsClean;
	boolean window1IsClean;
	boolean window2IsClean;
	boolean window3IsClean;
	boolean window4IsClean;
	boolean publicNetworkIsClean;
	boolean privateNetworkIsClean;
	
	
	public SecurityProperties()
	{
		frontDoorIsClean = true;
		backDoorIsClean = true;
		window1IsClean = true;
		window2IsClean = true;
		window3IsClean = true;
		window4IsClean = true;
		publicNetworkIsClean = true;
		privateNetworkIsClean = true;
	}
	
	public boolean isFrotDoorIsClean() {
		return frontDoorIsClean;
	}

	public void setFrotDoorIsClean(boolean frotDoorIsClean) {
		this.frontDoorIsClean = frotDoorIsClean;
	}

	public boolean isBackDoorIsClean() {
		return backDoorIsClean;
	}

	public void setBackDoorIsClean(boolean backDoorIsClean) {
		this.backDoorIsClean = backDoorIsClean;
	}

	public boolean isWindow1IsClean() {
		return window1IsClean;
	}

	public void setWindow1IsClean(boolean window1IsClean) {
		this.window1IsClean = window1IsClean;
	}

	public boolean isWindow2IsClean() {
		return window2IsClean;
	}

	public void setWindow2IsClean(boolean window2IsClean) {
		this.window2IsClean = window2IsClean;
	}

	public boolean isWindow3IsClean() {
		return window3IsClean;
	}

	public void setWindow3IsClean(boolean window3IsClean) {
		this.window3IsClean = window3IsClean;
	}

	public boolean isWindow4IsClean() {
		return window4IsClean;
	}

	public void setWindow4IsClean(boolean window4IsClean) {
		this.window4IsClean = window4IsClean;
	}

	public boolean isPublicNetworkIsClean() {
		return publicNetworkIsClean;
	}

	public void setPublicNetworkIsClean(boolean publicNetworkIsClean) {
		this.publicNetworkIsClean = publicNetworkIsClean;
	}

	public boolean isPrivateNetworkIsClean() {
		return privateNetworkIsClean;
	}

	public void setPrivateNetworkIsClean(boolean privateNetworkIsClean) {
		this.privateNetworkIsClean = privateNetworkIsClean;
	}
	
}
