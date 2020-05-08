package jbr.springjdbc.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class SpringJdbcUtil {

  public static void main(String[] args) throws Exception {
  }

  public static <T> String buildInClause(List<T> values, boolean quoteRequired, String index) {
    StringBuilder stringBuilder = new StringBuilder("((" + index + ",");
    if (quoteRequired) {
      stringBuilder.append("'" + StringUtils.join(values, "'),(" + index + ",'"));
      stringBuilder.append("'),");
    } else {
      stringBuilder.append(StringUtils.join(values, "),(") + index + ",");
      stringBuilder.append(")");
    }

    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    stringBuilder.append(")");

    return stringBuilder.toString();
  }

  private static void generateProductInserQuery() throws Exception {
    List<String> products = new ArrayList<>();

    for (int i = 1; i < 20001; i++) {
      String str = "INSERT INTO springjdbc.product VALUES('" + i + "','name" + i + "','category" + i + "','description"
          + i + "','price" + i + "');";
      products.add(str);
    }
    Files.write(Paths.get("insert.sql"), products);

  }

  private static void generateProductId() throws Exception {
    List<String> ids = new ArrayList<>();

    for (int i = 1; i < 20001; i++) {
      ids.add(String.valueOf(i));
    }
    Files.write(Paths.get("product-id.data"), ids);
  }
}
