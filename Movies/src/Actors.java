import java.util.ArrayList;

public class Actors {
ArrayList<String> act = new ArrayList<String>();

void setActor(String actName) {
	if (act.contains(actName)) {
		return;
	}
	act.add(actName);
	
}


}
