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
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 *
 * @author <a href="mailto:david.van.enckevort@dtls.nl">David van Enckevort</a>
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
            assertFalse(miabis.getValue().getSamplecollection().isEmpty());
            for (Object o : miabis.getValue().getSamplecollection()) {
                if (o instanceof SampleCollection) {
                    SampleCollection sc = (SampleCollection) o;
                    assertNotNull(sc.getDiseases(), "Diseases should not be null");
                    assertFalse(sc.getDiseases().isEmpty(),"Diseases should not be empty.");
                    Disease disease = sc.getDiseases().get(0);
                    assertNotNull(disease.getId(), "The disease ID should not be null");
                    assertEquals(disease.getTerm(), "birth", "The disease term should match \"birth\"");

                }
            }
        }

    }
}
