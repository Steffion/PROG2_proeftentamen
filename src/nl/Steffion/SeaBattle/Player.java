package nl.Steffion.SeaBattle;

public class Player {
	private Field	field;
	private String	name;
					
	public Player() {
		field = new Field();
	}
	
	public Field getField() {
		return field;
	}

	public String getName() {
		return name;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public void setName(String name) {
		this.name = name;
	}
}
