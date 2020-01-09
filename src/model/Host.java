package model;
// model/Host.java
import java.io.Serializable;

public class Host implements Serializable {

	/**
	 * 		P8Admin: Host model data type
	 */
	private static final long serialVersionUID = 1L;
	private static int count=1;
	
	private int id;
	private String churchName;
	private String churchStreet;
	private String churchCity;
	private String churchState;
	private String churchPostalCode;
	private String contactName;
	private String contactEmail;
	private String contactPhone;
	
	public Host(String chName, String chStreet, String chCity, String chState, String chPostalCode,
			String coName, String coEmail, String coPhone) {
		this.churchName = chName;
		this.churchStreet = chStreet;
		this.churchCity = chCity;
		this.churchPostalCode = chPostalCode;
		this.contactName = coName;
		this.contactEmail = coEmail;
		this.contactPhone = coPhone;
		
		this.id = count;
		count++;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Host.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChurchName() {
		return churchName;
	}

	public void setChurchName(String churchName) {
		this.churchName = churchName;
	}

	public String getChurchStreet() {
		return churchStreet;
	}

	public void setChurchStreet(String churchStreet) {
		this.churchStreet = churchStreet;
	}

	public String getChurchCity() {
		return churchCity;
	}

	public void setChurchCity(String churchCity) {
		this.churchCity = churchCity;
	}

	public String getChurchState() {
		return churchState;
	}

	public void setChurchState(String churchState) {
		this.churchState = churchState;
	}

	public String getChurchPostalCode() {
		return churchPostalCode;
	}

	public void setChurchPostalCode(String churchPostalCode) {
		this.churchPostalCode = churchPostalCode;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
