package ru.narod.vn91.pointsop.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.table.*;

import ru.narod.vn91.pointsop.data.Player;
import ru.narod.vn91.pointsop.data.PlayerChangeListener;
import ru.narod.vn91.pointsop.model.GuiController;
import ru.narod.vn91.pointsop.utils.ObjectKeeper;

@SuppressWarnings("serial")
public class RoomPart_Userlist extends javax.swing.JPanel {

	RoomInterface roomInterface;
	GuiController centralGuiController;
	final static int COLUMN_NAME = 0;
	final static int COLUMN_RATING = 1;
	final static int COLUMN_STATUS = 2;
	ArrayList<Player> playerList = new ArrayList<>();

	synchronized private Player getSelectedUser() {
		int index = jTable_UserList.getSelectedRow();
		if ((index >= 0)
				&& (index < jTable_UserList.getRowCount())) {
			return playerList.get(index);
		} else {
			return null;
		}
	}

	private Object[] constructRow(Player player) {
		Object[] row = { null, null, null };
		row[COLUMN_NAME] = player.guiName;
		row[COLUMN_RATING] = "" + (player.rating == 0 ? "" : "" + player.rating);
		row[COLUMN_STATUS] = player.status;
		return row;
	}


	synchronized void userJoined(Player playerNew, boolean addListener) {
		for (Player player2 : playerList) {
			if (playerNew == player2) {
				return;
			}
		}

		final DefaultTableModel tableModel = ((DefaultTableModel)
				jTable_UserList.getModel());
		int position = 0;
		for (Player player2 : playerList) {
			if (Player.compare(playerNew, player2) <= 0) {
				position += 1;
			} else {
				break;
			}
		}
		playerList.add(position, playerNew);

		Object[] row = constructRow(playerNew);
		tableModel.insertRow(position, row);

		if (jTable_UserList.getRowCount() >= 1) {
			// java seems to be buggy
			jTable_UserList.setRowSelectionInterval(0, 0);
		}
		jTable_UserList.clearSelection(); // java seems to be buggy

		final ObjectKeeper<Integer> playerRatingBeforeChange =
			new ObjectKeeper<>(playerNew.rating);

//		final int playerRatingBeforeChange = playerNew.rating;

		if (addListener) {
			playerNew.addChangeListener(new PlayerChangeListener() {
				@Override
				public void onChange(Player player) {
					if (player.rating != playerRatingBeforeChange.value
//						&& playerRatingBeforeChange.value != 0
						) {
						playerRatingBeforeChange.value = player.rating;
						userLeave(player);
						userJoined(player, false);
					} else {
						int position = 0;
						for (Player player2 : playerList) {
							if (player == player2) {

								Object[] row = constructRow(player);
								int columnNumber = 0;
								for (Object object : row) {
									tableModel.setValueAt(object, position, columnNumber);
									columnNumber += 1;
								}

								break;
							} else {
								position += 1;
							}
						}
					}
				}
			});
		}
	}

	public synchronized void userJoined(Player playerNew) {
		userJoined(playerNew, true);
	}

	public synchronized void userLeave(Player playerLeaving) {
		DefaultTableModel tableModel = ((DefaultTableModel) jTable_UserList.getModel());
		int position=0;
		for (Player player2 : playerList) {
			if (playerLeaving == player2) {
				tableModel.removeRow(position);
				playerList.remove(position);
				break;
			} else {
				position += 1;
			}
		}
	}

	/**
	 * Creates new form RoomPart_Userlist
	 */
	public RoomPart_Userlist() {
		initComponents();
	}

	public void initRoomPart(
			RoomInterface containerRoom,
			GuiController centralGuiController) {
		this.roomInterface = containerRoom;
		this.centralGuiController = centralGuiController;
		{
			FontMetrics tableFontMetrics = jTable_UserList.getFontMetrics(
					jTable_UserList.getFont()
			);

			TableColumn statusColumn = jTable_UserList.getColumnModel().getColumn(
					COLUMN_STATUS
			);
			int statusWidth = tableFontMetrics.stringWidth("XXXXXXXXXX");
			statusColumn.setPreferredWidth(statusWidth);
			statusColumn.setWidth(statusWidth);
			statusColumn.setMaxWidth(statusWidth);
			statusColumn.setMinWidth(statusWidth);
			statusColumn.setResizable(false);
			statusColumn.setHeaderValue("статус");
//			class KeyIconCellRenderer
//					extends DefaultTableCellRenderer {
//				public KeyIconCellRenderer() {
////					super.setText("");
////					super.setIcon(new ImageIcon("/ru/narod/vn91/pointsop/gui/vp.png"));
//				}
//			}
//			jTable_UserList.getColumnModel().getColumn(COLUMN_STATUS).setCellRenderer(
//					new KeyIconCellRenderer()
//			);

			TableColumn ratingColumn = jTable_UserList.getColumnModel().getColumn(
					COLUMN_RATING
			);
//			ratingColumn.set
			int ratingWidth = tableFontMetrics.stringWidth("XXXXXX");
			ratingColumn.setPreferredWidth(ratingWidth);
			ratingColumn.setWidth(ratingWidth);
			ratingColumn.setMaxWidth(ratingWidth);
			ratingColumn.setMinWidth(ratingWidth);
			ratingColumn.setResizable(false);
			ratingColumn.setHeaderValue("рейт");

			jTable_UserList.getColumnModel().getColumn(COLUMN_NAME).
					setHeaderValue("Имя");
		}
	}

	/**
	 * This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane_UserList = new javax.swing.JScrollPane();
        jTable_UserList = new javax.swing.JTable();

        jMenuItem1.setText("Для дополнительных действий щелкните дважды мышкой");
        jPopupMenu1.add(jMenuItem1);

        jTable_UserList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ", " ", " "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_UserList.setToolTipText("Для дополнительных действий щёлкните дважды мышкой");
        jTable_UserList.setComponentPopupMenu(jPopupMenu1);
        jTable_UserList.setFocusable(false);
        jTable_UserList.getTableHeader().setReorderingAllowed(false);
        jTable_UserList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_UserListMouseClicked(evt);
            }
        });
        jScrollPane_UserList.setViewportView(jTable_UserList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_UserList, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_UserList, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

	private void jTable_UserListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_UserListMouseClicked
		if (evt.getClickCount() == 2) {
			Player player = getSelectedUser();
			centralGuiController.createPrivateChatWindow(player);
//					roomInterface.getServer(), player.id, player.guiName
//			);
		} else if (evt.getButton() == MouseEvent.BUTTON1) {
			Point p = evt.getPoint();
			if (jTable_UserList.getCellRect(0, 0, true).contains(p)) {
			}
		}
		if (jTable_UserList.getRowCount() >= 1) {
			// java seems to be buggy
			jTable_UserList.setRowSelectionInterval(0, 0);
		}
		jTable_UserList.clearSelection(); // java seems to be buggy
	}//GEN-LAST:event_jTable_UserListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane_UserList;
    private javax.swing.JTable jTable_UserList;
    // End of variables declaration//GEN-END:variables
}
