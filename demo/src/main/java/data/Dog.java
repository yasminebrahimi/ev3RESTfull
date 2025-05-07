package data;

public class Dog {
  private int id;
  private String breed;
  private float weight;

  public Dog() {
    super();
  }

  public Dog(int id, String breed, float weight) {
    this.id = id;
    this.breed = breed;
    this.weight = weight;
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

  public String toString() {
    return this.id + "/" + this.breed + "/" + this.weight;
  }

}
