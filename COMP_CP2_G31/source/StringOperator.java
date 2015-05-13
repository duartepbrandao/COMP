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

}
