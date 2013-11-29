package usecases;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domain.Status;

public class UserPublishesToChatRoomTest {
	private UserPublishesToChatRoom userPublishesToChatRoom;
	private static final String CHATROOM = "A Room";
	
	@Before
	public void setup() {
		userPublishesToChatRoom = new UserPublishesToChatRoom();
	}
	
	@Test
	public void messageIsSuccessfullyPublishedToChatRoom(){
		userPublishesToChatRoom.addRoom(CHATROOM);
		
		Status status = userPublishesToChatRoom.invoke(CHATROOM);
		
		assertTrue(status.equals(Status.SUCCESS));
	}

	@Test
	public void messageIsNotSuccessfullyPublishedToChatRoomWhenRoomDoesNotExist(){
		Status status = userPublishesToChatRoom.invoke(CHATROOM);
		
		assertTrue(status.equals(Status.FAIL));
	}
}
