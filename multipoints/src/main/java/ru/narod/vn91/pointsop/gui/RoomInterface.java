package ru.narod.vn91.pointsop.gui;

import javax.swing.JPanel;
import ru.narod.vn91.pointsop.server.ServerInterface;


public interface RoomInterface {

	JPanel getMainJPanel();

	RoomPart_Chat getRoomPart_Chat();

	RoomPart_Userlist getRoomPart_UserList();

	RoomPart_GameList getRoomPart_GameList();

	Paper getRoomPart_Paper();

	PrivateChat getPrivateChat();

	ServerInterface getServer();

	String getRoomNameOnServer();

	boolean userAsksClose();
}
