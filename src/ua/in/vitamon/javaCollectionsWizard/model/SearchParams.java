package ua.in.vitamon.javaCollectionsWizard.model;

import com.googlecode.androidannotations.annotations.Enhanced;

@Enhanced
public class SearchParams {
    private boolean isThreadSafe;
    private boolean isAllowDuplicates;
    private boolean isSorted;
    private boolean isInterface;
    private boolean isNullAllowed;

    public SearchParams() {
        isThreadSafe = false;
        isAllowDuplicates = false;
        isSorted = false;
        isInterface = false;
        isNullAllowed = false;
    }

    @Override
    public boolean equals(Object obj) {
        SearchParams match = (SearchParams) obj;
        return checkEqual(isThreadSafe, match.isThreadSafe()) &&
                checkEqual(isAllowDuplicates, match.isAllowDuplicates()) &&
                checkEqual(isSorted, match.isSorted()) &&
                checkEqual(isInterface, match.isInterface()) &&
                checkEqual(isNullAllowed, match.isNullAllowed())
                ;
    }

    private boolean checkEqual(boolean myValue, boolean checkValue) {
        return myValue == checkValue;
    }

    protected static SearchParams newInstance(CollType[] types) {
        SearchParams result = new SearchParams();
        for (CollType type : types) {
            switch (type) {
                case SORTABLE:
                    result.isSorted = true;
                    break;

                case THREAD_SAFE:
                    result.isThreadSafe = true;
                    break;

                case ALLOW_DUPLICATES:
                    result.isAllowDuplicates = true;
                    break;

                case INTERFACE:
                    result.isInterface = true;
                    break;

                case ALLOW_NULL:
                    result.isNullAllowed = true;
                    break;

                default:
                    throw new RuntimeException("no such collection attribute");
            }
        }
        return result;
    }

    public boolean isInterface() {
        return isInterface;
    }

    public void setInterface(boolean anInterface) {
        isInterface = anInterface;
    }


    public boolean isThreadSafe() {
        return isThreadSafe;
    }

    public void setThreadSafe(boolean threadSafe) {
        isThreadSafe = threadSafe;
    }

    public boolean isAllowDuplicates() {
        return isAllowDuplicates;
    }

    public void setAllowDuplicates(boolean allowDuplicates) {
        this.isAllowDuplicates = allowDuplicates;
    }

    public boolean isSorted() {
        return isSorted;
    }

    public void setSorted(boolean sorted) {
        isSorted = sorted;
    }

    public boolean isNullAllowed() {
        return isNullAllowed;
    }

    public void setNullAllowed(boolean nullAllowed) {
        isNullAllowed = nullAllowed;
    }
}
