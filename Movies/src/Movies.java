import javax.swing.JOptionPane;

public class Movies {
	
	public static void main(String[] args) {
		
		Dictionary movies = new Dictionary();
		// TODO Auto-generated method stub
		movies.cargarLista();
		String window = JOptionPane.showInputDialog("Option 1 or Option 2? (a/b)");
		if (window.equalsIgnoreCase("a")) {
			String movie = JOptionPane.showInputDialog("Write the name of two movies separated by |,&,^: " );
			movies.Dictionaries(movie);
		}
		else if(window.equalsIgnoreCase("b")) {
			String actor = JOptionPane.showInputDialog("Write the name of an actor: ");
			movies.optionB(actor);
		}
		
	}

}
