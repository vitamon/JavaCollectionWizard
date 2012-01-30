package ua.in.vitamon.javaCollectionsWizard.model;

import com.googlecode.androidannotations.annotations.Enhanced;

import java.util.Set;
import java.util.TreeSet;

@Enhanced
public class SearchParams<T extends Enum> {

    private Set<T> searchKeys;

    public SearchParams() {
        reset();
    }
    
    public Set<T> getSearchKeys() {
        return searchKeys;
    }

    public void setSearchParam(T type, boolean addParam) {
        if (addParam) {
            searchKeys.add(type);
        } else {
            if (isSet(type)) searchKeys.remove(type);
        }
    }

    public boolean isSet(T type) {
        return searchKeys.contains(type);
    }

    public static <T extends Enum> SearchParams newInstance(T[] types) {
        SearchParams result = new SearchParams();
        for (T type : types) {
            result.setSearchParam(type, true);
        }
        return result;
    }

    public boolean isSetAnyOf(SearchParams<T> params) {
        for (T type : searchKeys) {
            if (params.isSet(type)) return true;
        }
        return false;
    }

    public void reset() {
        searchKeys = new TreeSet<T>();
    }

    public boolean isAllSet(SearchParams<T> params) {
        return searchKeys.containsAll(params.getSearchKeys());
    }
}
