package webUi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import webUi.model.NamedEntity;

@Entity
@Table(name = "types")
public class PetType extends NamedEntity {
}
