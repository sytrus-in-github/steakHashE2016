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
		this.type = type;
		this.droneId = droneId;
		this.targetId = targetId;
		this.itemType = itemType;
		this.itemNumber = itemNumber;
	}

	public void execute() {
		
	}
	
	@Override
	public String toString() {
		String result = droneId + " ";
		if (type == CommandType.Load) {
			result += "L ";
		} else if (type == CommandType.Unload) {
			result += "U ";
		} else if (type == CommandType.Deliver) {
			result += "D ";
		} else if (type == CommandType.Wait) {
			result += "W ";
		}
		result += targetId + " ";
		if (type != CommandType.Wait) {
			result += itemType + " " + itemNumber;
		}
		return result;
	}
}
