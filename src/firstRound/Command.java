package firstRound;


public class Command {

	public enum CommandType {
		Load,
		Unload,
		Deliver,
		Wait
	}
	public CommandType type;
	public int droneId;
	public int targetId;
	public int itemType;
	public int itemNumber;
	
	public Command(CommandType type, int droneId, int targetId, int itemType, int itemNumber) {
		
	}

	public void execute() {
		
	}
}
