import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Dictionary {
HashMap<String, Actors> name = new HashMap<String, Actors>();

void Dictionaries(String values){
	if (values.contains("|")) {
		int place = values.indexOf("|");
		String movie1 = values.substring(0 , place);
		String movie2 = values.substring(place+1);
	findActors(movie1, movie2);	
	}
	else if (values.contains("&")) {
		int place = values.indexOf("&");
		String movie1 = values.substring(0 , place);
		String movie2 = values.substring(place+1);
		andActors(movie1, movie2);
	}
	else if (values.contains("^")) {
		int place = values.indexOf("^");
		String movie1 = values.substring(0 , place);
		String movie2 = values.substring(place+1);
		xorActors(movie1, movie2);
	}
}

void findActors(String mov1, String mov2) {
	Actors a = name.get(mov1);
	for(int i = 0; i < a.act.size(); i++) {
		// imprimir
		System.out.println(a.act.get(i) + " ");
	}
	a = name.get(mov2);
	for(int i = 0; i < a.act.size(); i++) {
		//imprimir pelicula 2
		System.out.println(a.act.get(i) + " ");
	}
}

void andActors(String mov1, String mov2) {
	Actors a = name.get(mov1), b = name.get(mov2);
	for(int i = 0; i < a.act.size(); i++) {
		String A1 = a.act.get(i);
		for (int j = 0; j < b.act.size(); j++) {
			String A2 = b.act.get(j);
			if(A1.equals(A2)){
				System.out.println(A1 + " ");
			}
		}
	}
}

void xorActors(String mov1, String mov2) {
	Actors a = name.get(mov1), b = name.get(mov2);
	for (int i = 0; i < a.act.size(); i++) {
		if(!b.act.contains(a.act.get(i))){
			System.out.println(a.act.get(i));
		}
	}
}

void optionB(String actorName){
	Set<String> keys = name.keySet();
	Iterator<String> i1 = keys.iterator();
	while(i1.hasNext()){
		Actors a = name.get(i1.next()); 
		if(a.act.contains(actorName)) {
			for(int i = 0; i < a.act.size(); i++) {
				if(!a.act.get(i).equals(actorName)){
				System.out.println(a.act.get(i) + " ");
			}
		}
		}
		}
}

void cargarLista() {
	String almacenamiento = "";
	try {
	FileReader fileReader = new FileReader("C:/Users/ricky/workspace/Movies/bin/Movies.txt");
	BufferedReader bufferedReader = new BufferedReader(fileReader);
	while((almacenamiento = bufferedReader.readLine()) != null){
		String [] movies = almacenamiento.split(", ");
		for (int i = 1; i < movies.length; i++) {
			if (!name.containsKey(movies[i])) {
				name.put(movies[i], new Actors());
			}
			name.get(movies[i]).setActor(movies[0]);
		}
		
	}
	bufferedReader.close();
	} catch(Exception e) {
		System.out.println("El archivo no existe.");
	}
}
}
