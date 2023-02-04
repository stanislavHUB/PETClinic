package webUi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import webUi.model.NamedEntity;

@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity {
}
