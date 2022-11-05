import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

  @Test
  void learning(){
    String responseFromService = "[{\"id\":1000,\"name\": \"Pencil\",\"quantity\":5},{\"id\":1001,\"name\": \"Pen\",\"quantity\":15},{\"id\":1002,\"name\": \"Eraser\",\"quantity\":10}]";
    DocumentContext parse = JsonPath.parse(responseFromService);
    int length = parse.read("$.length()");
    assertThat(length).isEqualTo(3);

    List<Integer> ids = parse.read("$..id");
    assertThat(ids).containsExactly(1000,1001,1002);
    System.out.println(parse.read("$.[1]").toString());
    System.out.println(parse.read("$.[0:1]").toString());
    System.out.println(parse.read("$.[?(@.name=='Eraser')]").toString());
    System.out.println(parse.read("$.[?(@.quantity==5)]").toString());

  }

}
