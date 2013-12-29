package Enviroment;

public class BasisEnvironment {

	private static volatile BasisEnvironment instance = null;

	public static BasisEnvironment getInstance() {
		if (instance == null) {
			synchronized (BasisEnvironment.class) {
				if (instance == null) {
					instance = new BasisEnvironment();
				}
			}
		}
		return instance;
	}

	double outdoorLightRatio;
	double indoorLightRatio;
	SecurityProperties securityProperties;
	RefrigeratorEnvironment refrigiratorEnvironment;

	private BasisEnvironment() {
	}

	public double getOutdoorLightRatio() {
		return outdoorLightRatio;
	}

	public void setOutdoorLightRatio(double outdoorLightRatio) {
		this.outdoorLightRatio = outdoorLightRatio;
	}

	public double getIndoorLightRatio() {
		return indoorLightRatio;
	}

	public void setIndoorLightRatio(double indoorLightRatio) {
		this.indoorLightRatio = indoorLightRatio;
	}

	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}
	
	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}

	public RefrigeratorEnvironment getRefrigiratorEnvironment() {
		return refrigiratorEnvironment;
	}

	public void setRefrigiratorEnvironment(
			RefrigeratorEnvironment refrigiratorEnvironment) {
		this.refrigiratorEnvironment = refrigiratorEnvironment;
	}
	
	

}
