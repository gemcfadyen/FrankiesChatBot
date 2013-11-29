package usecases;

import infra.MessageService;

import java.util.ArrayList;
import java.util.List;

import domain.Status;

public class UserPublishesToChatRoom {
	private List<String> roomsList = new ArrayList<String>();
	private MessageService messageService;
	
	public Status invoke(String chatRoom, String message) {
		return isValid(chatRoom) && messageService.isValid(message) 
				? Status.SUCCESS 
				: Status.FAIL;
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
	
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
}
