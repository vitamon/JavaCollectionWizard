package ua.in.vitamon.javaCollectionsWizard.model;

import com.googlecode.androidannotations.annotations.Enhanced;

import java.util.*;
import java.util.concurrent.*;

import static ua.in.vitamon.javaCollectionsWizard.model.CollType.*;

@Enhanced
public class CollectionsListDataProvider {
    private static final TreeMap<String, SearchParams> collections = new TreeMap<String, SearchParams>();

    static {
        //sets
        add(Set.class, INTERFACE);
        add(HashSet.class, ALLOW_NULL);
        add(LinkedHashSet.class, ALLOW_NULL);
        add(SortedSet.class, INTERFACE, SORTABLE);
        add(NavigableSet.class, INTERFACE, SORTABLE);
        add(TreeSet.class, SORTABLE);
        add(EnumSet.class, INTERFACE);
        add(ConcurrentSkipListSet.class, SORTABLE, THREAD_SAFE);
        add(CopyOnWriteArraySet.class, THREAD_SAFE);

        // lists
        add(List.class, INTERFACE, ALLOW_DUPLICATES);
        add(LinkedList.class, ALLOW_DUPLICATES, ALLOW_NULL);
        add(ArrayList.class, ALLOW_DUPLICATES, ALLOW_NULL);
        add(CopyOnWriteArrayList.class, ALLOW_DUPLICATES, THREAD_SAFE, ALLOW_NULL);

        // maps
        add(Map.class, INTERFACE);
        add(ConcurrentMap.class, INTERFACE, THREAD_SAFE);
        add(SortedMap.class, INTERFACE, SORTABLE);
        add(NavigableMap.class, INTERFACE, SORTABLE);
        add(ConcurrentNavigableMap.class, THREAD_SAFE, INTERFACE);
        add(ConcurrentSkipListMap.class, THREAD_SAFE, SORTABLE);
        add(TreeMap.class, SORTABLE);
        add(HashMap.class);
        add(LinkedHashMap.class);

        // Queues
        add(Queue.class, INTERFACE);
        add(BlockingQueue.class, INTERFACE);
        add(PriorityQueue.class, ALLOW_DUPLICATES, SORTABLE);
        add(ConcurrentLinkedQueue.class, ALLOW_DUPLICATES, THREAD_SAFE);
        add(ArrayBlockingQueue.class, ALLOW_DUPLICATES, THREAD_SAFE);
        add(PriorityBlockingQueue.class, ALLOW_DUPLICATES, THREAD_SAFE);
        add(SynchronousQueue.class, ALLOW_DUPLICATES, THREAD_SAFE);
        add(DelayQueue.class, ALLOW_DUPLICATES, THREAD_SAFE);
        add(LinkedBlockingDeque.class, ALLOW_DUPLICATES, THREAD_SAFE);

        // Deque
        add(Deque.class, INTERFACE);
        add(ArrayDeque.class, ALLOW_DUPLICATES);
        add(BlockingDeque.class, INTERFACE);
    }

    private static void add(Class<?> clazz, CollType... params) {
        String name = clazz.getName();
        if (collections.get(name) != null) throw new RuntimeException("duplicate collection declaration :" + name);
        collections.put(name, SearchParams.newInstance(params));
    }

    public String[] getCollections(SearchParams<CollType> params) {
        ArrayList<String> result = new ArrayList<String>(collections.size());

        for (String key : collections.keySet()) {
            SearchParams collectionParams = collections.get(key);

            if (collectionParams.isAllSet(params)) {
                result.add(key);
            }
        }

        return result.toArray(new String[result.size()]);
    }

}
