package Web;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({CatalogTest.class, ProductPageTest.class, SearchFieldTest.class})
public class AllTests {
}
