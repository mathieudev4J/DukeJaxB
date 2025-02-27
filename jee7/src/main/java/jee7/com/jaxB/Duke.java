package jee7.com.jaxB;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
/**
 * @see jakarta.xml.bind.annotation.XmlAccessorType
 * @see jakarta.xml.bind.annotation.XmlAttribute
 * @see jakarta.xml.bind.annotation.XmlAccessOrder
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Duke {

	private String language;
	private int age;
	/**
	 * @param language
	 * @param age
	 */
	public Duke(String language, int age) {
	
		this.language = language;
		this.age = age;
	}
	public Duke() {
		super();
	}
	/**
	 * @ see java.lang.Object
	 * 
	 */
	@Override
	public String toString() {
		return "Duke [language=" + getLanguage() + ", age=" + getAge() + "]";
	}
	/**
	 * @return the language
	 */
	protected String getLanguage() {
		return language;
	}
	/**
	 * @return the age
	 */
	protected int getAge() {
		return age;
	}
	/**
	 * @param language the language to set
	 */
	protected void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @param age the age to set
	 */
	protected void setAge(int age) {
		this.age = age;
	}
}
