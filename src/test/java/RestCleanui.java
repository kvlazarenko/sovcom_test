import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestCleanui {

  @Test
  @DisplayName("Позитивное тестирование запроса Post c проверкой key/value")
  public void restTrue() {
    String url = "{\n" + " \"url\" :\"https://www.google.com/\" \n}";

    RestAssured.given()
            .when()
            .contentType(ContentType.JSON)
            .body(url)
            .post("https://cleanuri.com/api/v1/shorten")
            .then()
            .log()
            .all()
            .assertThat()
            .body("result_url", Matchers.is("https://cleanuri.com/qbG275"));
  }

  @Test
  @DisplayName("Негативное тестирование запроса Post c проверкой key/value")
  public void restFalse() {
    String url = "{\n" + " \"url\" :\"https://www.google.com/\" \n}";

    RestAssured.given()
            .when()
            .contentType(ContentType.JSON)
            .body(url)
            .post("https://cleanuri.com/api/v1/shorten")
            .then()
            .log()
            .all()
            .assertThat()
            .body("result_url", Matchers.is("https://cleanuri.com/"));
  }
}
