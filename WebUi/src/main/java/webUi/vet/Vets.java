package webUi.vet;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import webUi.entity.Vet;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Vets {
    private List<Vet> vets;

    @XmlElement
    public List<Vet> getVetList() {
        if (vets == null) {
            vets = new ArrayList<>();
        }
        return vets;
    }
}
