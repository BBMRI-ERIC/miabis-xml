/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.bbmri_eric.miabis;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author David van Enckevort <david@allthingsdigital.nl>
 */
public class MarshallerTest {
    private JAXBContext jc;
    private Marshaller marshaller;

    @Test
    public void testMarshalRoot() throws JAXBException {
        Miabis miabis = new Miabis();
        marshaller.marshal(miabis, System.out);
    }

    @Test
    public void testMarshalBiobank() throws JAXBException {
        Miabis miabis = new Miabis();
        Biobank biobank = new Biobank();
        biobank.setAcronym("TEST");
        biobank.setCountry("NL");
        biobank.setDescription("Test biobank");
        biobank.setName("Test");
        miabis.getBiobank().add(biobank);
        marshaller.marshal(miabis, System.out);
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        jc = JAXBContext.newInstance("eu.bbmri_eric.miabis");
        marshaller = jc.createMarshaller();
    }

    @AfterMethod
    public void afterMethod() throws Exception {
    }
}
