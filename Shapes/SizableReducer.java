import java.util.ArrayList;

// Interface for anonymous inner class
public interface SizableReducer {
    public Sizable reduce(ArrayList<Sizable> array, SizableSelector selector);
}
