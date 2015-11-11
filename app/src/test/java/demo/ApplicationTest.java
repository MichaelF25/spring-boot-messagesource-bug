package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest({"server.port=0"})
public class ApplicationTest {

    @Value("${local.server.port}")
    private int httpPort;

    @Test
    public void testUS() {
        given().port(httpPort)
                .when()
                .get("/us")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testDE() {
        given().port(httpPort)
                .when()
                .get("/de")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}
