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
public class CollectionsWizardTest {
    
    @Test
    public void testDP() {
      CollectionsListDataProvider cdp = new CollectionsListDataProvider();
        String[] result = cdp.getCollections(new SearchParams());
        assertNotNull(result);
    }
    
    @Test
    public void EnumStringTest() {
      for (CollType type:CollType.values()) {
          System.out.println(type.toString());
      }
    }
    
    @Test
    public void classNameToStringTest() {
        System.out.println(className(CollectionsWizardTest.class));
    }
    
    private String className(Class<? extends Object> cl) {
       return cl.getName();
    }

    @Test
    public void searchParamTest(){
        SearchParams sp = SearchParams.newInstance(new CollType[]{CollType.ALLOW_DUPLICATES, CollType.ALLOW_NULL});
        SearchParams collection = SearchParams.newInstance(new CollType[]{CollType.ALLOW_DUPLICATES, CollType.ALLOW_NULL, CollType.INTERFACE});
        assertEquals(true, collection.isAllSet(sp));
    }

    @Test
    public void searchParamTest2(){
        SearchParams sp = SearchParams.newInstance(new CollType[]{});
        SearchParams collection = SearchParams.newInstance(new CollType[]{CollType.ALLOW_DUPLICATES, CollType.ALLOW_NULL, CollType.INTERFACE});
        assertEquals(true, collection.isAllSet(sp));
    }

    @Test
    public void searchParamTest3(){
        SearchParams sp = SearchParams.newInstance(new CollType[]{CollType.ALLOW_DUPLICATES, CollType.ALLOW_NULL});
        SearchParams collection = SearchParams.newInstance(new CollType[]{CollType.ALLOW_DUPLICATES});
        assertEquals(false, collection.isAllSet(sp));
    }
}
