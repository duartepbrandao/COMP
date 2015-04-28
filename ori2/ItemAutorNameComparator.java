import java.util.Comparator;


  public class ItemAutorNameComparator implements Comparator {
    @Override
	public int compare(Object o1, Object o2) {
      if (!(o1 instanceof Item) || !(o2 instanceof Item))
        throw new ClassCastException();

      Item e1 = (Item) o1;
      Item e2 = (Item) o2;
	 
	   return e1.getEntry("author").compareTo(e2.getEntry("author")); 
	   
    }
  }
