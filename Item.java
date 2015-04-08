public class Item{
ItemType type;
String id;
java.util.List<String>  entries;

public Item(String _type, String _id)
{
	id = _id;
	
	try{
	type = ItemType.valueOf(_type);
	}catch(Exception e){
	type=ItemType.error;
	}

	
	entries = new java.util.ArrayList<String>();
}

public void addEntry(String entry)
{
	entries.add(entry);
}

public void save2HTML()
{
		//todo
}

public void debugPrint()
{
	System.out.println("->" + type.name() + ":");
	if (type==ItemType.error) {System.out.println("ITEM ERROR"); return;}
	for (int i = 0; i<entries.size();i++) System.out.println(entries.get(i));
}

}