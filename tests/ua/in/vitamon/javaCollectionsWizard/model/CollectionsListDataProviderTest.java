package ua.in.vitamon.javaCollectionsWizard.model;

import org.junit.Test;

import java.util.HashSet;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: Vit
 * Date: 28.01.12
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
public class CollectionsListDataProviderTest {
    
    @Test
    public void testDP() {
      CollectionsListDataProvider cdp = new CollectionsListDataProvider();
        String[] result = cdp.getCollections(new SearchParams());
        assertNotNull(result);
    }
    
    @Test
    public void EnumStringtest() {
      for (CollType type:CollType.values()) {
          System.out.println(type.toString());
      }
    }
    
    @Test
    public void classNametoStringtest() {
        System.out.println(className(CollectionsListDataProviderTest.class));
    }
    
    private String className(Class<? extends Object> cl) {
       return cl.getName();
    }
}
