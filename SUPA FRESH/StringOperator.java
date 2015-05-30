public class StringOperator{
java.util.List<String> originals;
java.util.List<String> replacements;

public StringOperator(){

  originals= new java.util.ArrayList<String> ();
  replacements = new java.util.ArrayList<String> ();
}

public void add(String original, String replacement){
  originals.add(original);
  replacements.add(replacement);
}

public void show_warnings()
{
	System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -"); 
	boolean rep=false;
	for(int i = originals.size()-1; i>=0; --i)
			for(int j = i-1; j>=0; --j)
			{
				if(originals.get(i).equals(originals.get(j)) ) {
					System.out.println("Warning: @String <" + originals.get(i) + "> is defined multiple times");
					rep=true;
				}
			}
			if (rep) {
			System.out.println("\nNote: @String replacements use the last @String item \ndeclared before the item that references it"); 
			
			}
}

}
