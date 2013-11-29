package usecases;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import infra.MessageService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import domain.Status;

@RunWith(MockitoJUnitRunner.class)
public class UserPublishesToChatRoomTest {
	private static final String CHATROOM = "A Room";
	private static final String VALID_MESSAGE = "VALID MESSAGE";
	private static final String INVALID_MESSAGE = "INVALID MESSAGE";

	@Mock private MessageService messageService;
	@InjectMocks private UserPublishesToChatRoom userPublishesToChatRoom = new UserPublishesToChatRoom();
	
	@Test
	public void messageIsSuccessfullyPublishedToChatRoom(){
		userPublishesToChatRoom.addRoom(CHATROOM);
		when(messageService.isValid(VALID_MESSAGE)).thenReturn(true);
		
		Status status = userPublishesToChatRoom.invoke(CHATROOM, VALID_MESSAGE);
		
		assertTrue(status.equals(Status.SUCCESS));
	}

	@Test
	public void messageIsNotSuccessfullyPublishedToChatRoomWhenRoomDoesNotExist(){
		Status status = userPublishesToChatRoom.invoke(CHATROOM, VALID_MESSAGE);
		
		assertTrue(status.equals(Status.FAIL));
	}
	
	@Test
	public void messageIsNotSuccessfullyPublishedToChatRoomWhenMessageIsInvalid(){
		userPublishesToChatRoom.addRoom(CHATROOM);
		when(messageService.isValid(INVALID_MESSAGE)).thenReturn(false);
		
		Status status = userPublishesToChatRoom.invoke(CHATROOM, INVALID_MESSAGE);
		
		assertTrue(status.equals(Status.FAIL));
	}
}