import java.util.Comparator;


  public class ItemComparator implements Comparator {
	  
	  String entry;
	  ItemComparator(String s) {entry=s;}
	  
    @Override
	public int compare(Object o1, Object o2) {
      if (!(o1 instanceof Item) || !(o2 instanceof Item))
        throw new ClassCastException();

      Item e1 = (Item) o1;
      Item e2 = (Item) o2;
	 
	   return e1.getEntry(entry).toLowerCase().compareTo(e2.getEntry(entry).toLowerCase()); 
	   
    }
  }
