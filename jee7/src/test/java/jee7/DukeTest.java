package jee7;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.rmi.MarshalledObject;

import org.junit.Before;
import org.junit.Test;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jee7.com.jaxB.Duke;

public class DukeTest {
/**
 * 
 * @author MathieuDev4J
 * @since 1.0
 * 
 */
	private JAXBContext jaxbContext;

	/**
	 * 
	 * @see org.junit.BeforeClass
     * @see org.junit.After, org.junit.Before
	 * @throws JAXBException
	 * 
	 */
    @Before
	public void init() throws JAXBException {
		this.jaxbContext=JAXBContext.newInstance(Duke.class);
		
	}
	/**
	 * <h3>Fonctionne avec maven dependencies 
	 * {@link} jakarta.xml.bind-4.0.0.jar
	 * junit-4.13.2.jar
	 * jaxb-runtime-4.0.5.jar
	 * 
	 * @throws IOException 
	 * 
	 */
	
	@Test
	public void serialisation() throws JAXBException {

		Duke duke= new Duke("java",22);
		Marshaller marshaller=this.jaxbContext.createMarshaller();
	     // on choisit UTF-8 pour encoder ce fichier
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true) ;
	     // et l'on demande à JAXB de formatter ce fichier de façon 
	     // à pouvoir le lire à la console
		marshaller.marshal(duke, System.out);    
		//rshaller.marshal(duke, new File("duke.xml"));
		
		
	}
	@Test
	public void serialisation2() throws JAXBException {
		File f= new File("C:\\Users\\ASUS\\eclipse-workspace\\interview\\jee7\\src\\test\\resources\\b.xml");
		try {
			Duke dukeExpected=new Duke("java", 22);
			FileInputStream file= new FileInputStream(f);
			this.jaxbContext=JAXBContext.newInstance(Duke.class);
			Unmarshaller unmarshaller= this.jaxbContext.createUnmarshaller();	
				Duke d=(Duke)unmarshaller.unmarshal(file);
				System.out.println(d.toString());
				assertEquals(d.toString(), dukeExpected.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
