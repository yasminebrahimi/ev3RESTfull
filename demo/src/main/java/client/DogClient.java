package client;

import data.Dog;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;

public class DogClient {

  public static void main(String[] args) {
    String uri = "http://127.0.0.1:8080/demo/rest/lego/getonedog/1";

    Client c = ClientBuilder.newClient();
    WebTarget wt = c.target(uri);
    Builder b = wt.request();
    Dog d = b.get(Dog.class);
    String s = b.get(String.class);
    System.out.println("Object: " + d);
    System.out.println("JSON: " + s);
  }
}