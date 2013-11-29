package usecases;

import java.util.ArrayList;
import java.util.List;

import domain.Status;

public class UserPublishesToChatRoom {
	private List<String> roomsList = new ArrayList<String>();
	
	public Status invoke(String chatRoom) {
		if (isValid(chatRoom)) {
			return Status.SUCCESS;
		}
		return Status.FAIL;
	}

	private boolean isValid(String chatRoom) {
		if (roomsList.contains(chatRoom)) {
			return true;
		}
		return false;
	}

	public void addRoom(String chatRoom) {
		roomsList.add(chatRoom);
	}
}
