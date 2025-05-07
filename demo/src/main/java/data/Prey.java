package data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prey")
public class Prey {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, length = 100)
  private String breed;

  @Column(nullable = false, precision = 10, scale = 2)
  private float weight;

  /**
   * Indicates whether this prey is purebred (1) or not (0).
   */
  @Column(nullable = false)
  private int purebred;

  public Prey() {
    super();
  }

  public Prey(String breed, float weight, int purebred) {
    this.breed = breed;
    this.weight = weight;
    this.purebred = purebred;
  }

  public Prey(int id, String breed, float weight, int purebred) {
    this.id = id;
    this.breed = breed;
    this.weight = weight;
    this.purebred = purebred;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public float getWeight() {
    return weight;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

  public int getPurebred() {
    return purebred;
  }

  public void setPurebred(int purebred) {
    this.purebred = purebred;
  }

  @Override
  public String toString() {
    return id + ": " + breed + " (" + weight + " kg) - purebred=" + purebred;
  }
}
