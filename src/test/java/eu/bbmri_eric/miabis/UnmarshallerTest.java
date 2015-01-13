/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.bbmri_eric.miabis;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import static junit.framework.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 *
 * @author David van Enckevort <david@allthingsdigital.nl>
 */
public class UnmarshallerTest {
    @Test
    public void sampleCollection() throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance("eu.bbmri_eric.miabis");

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        try (final InputStream xml = getClass().getResourceAsStream("miabis.xml")) {
            assertNotNull(xml);
            JAXBElement<Miabis> miabis = unmarshaller.unmarshal(new StreamSource(xml), Miabis.class);
            assertNotNull(miabis);
            assertFalse(miabis.getValue().getSamplecollectionOrDiseaseOrContact().isEmpty());

        }

    }
}
