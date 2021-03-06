package ru.narod.vn91.pointsop.gui;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import javax.swing.JLabel;

import ru.narod.vn91.pointsop.model.GuiController;
import ru.narod.vn91.pointsop.server.ServerPointsxt;
import ru.narod.vn91.pointsop.server.ServerZagram;
import ru.narod.vn91.pointsop.utils.Settings;

public class WelcomePanel extends javax.swing.JPanel {

	public GuiController guiController;
	String nick;

	private void updateNick() {
		nick = jTextField_Username.getText();
		Settings.setUserName(nick);
	}

	private void connectToZagram() {
		updateNick();
		// DISABLED until zagram bugs would be fixed
		if (guiController.zagram_server == null) {
			String password = String.copyValueOf(jPasswordField_Password.getPassword());
			guiController.zagram_server = new ServerZagram(guiController, nick, password, false);
			guiController.zagram_server.connect();
		}
	}

	private void connectToPointsxt() {
		updateNick();
		if (guiController.pointsxt_vn91_server == null) {
			String password = String.copyValueOf(jPasswordField_Password.getPassword());
			guiController.pointsxt_vn91_server = new ServerPointsxt(
						Settings.getIrcAddress(), guiController,
						nick, password,
						"none", "201120", true
					);
			guiController.pointsxt_vn91_server.connect();
		}

		
		// if (guiController.pointsxt_tochkiorg_server == null) {
		// guiController.pointsxt_tochkiorg_server = new ServerPointsxt(
		// "tochki.org", guiController, nick, null, "1ppass1", true);
		// guiController.pointsxt_tochkiorg_server.connect();
		// }

		// if (guiController.pointsxt_ircworldru_server == null) {
		// guiController.pointsxt_ircworldru_server = new ServerPointsxt(
		// "ircworld.ru", guiController, nick, null, "201120", true);
		// guiController.pointsxt_ircworldru_server.connect();
		// }
	}

	/**
	 * Creates new form WelcomePanel
	 */
	public WelcomePanel(GuiController actionDistributor) {
		this.guiController = actionDistributor;
		initComponents();
		jTextField_Username.setText(Settings.getUserName());
		jTextField_Username.select(
				jTextField_Username.getText().length(),
				jTextField_Username.getText().length()
		);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel_Right = new javax.swing.JPanel();
        jLabel_Logo = new javax.swing.JLabel();
        jLabel_IncontactGroup = new LinkedLabel();
        jLabel_Qestions = new LinkedLabel();
        jLabel_GameWishes = new LinkedLabel();
        jLabel_ChatWishes = new LinkedLabel();
        jLabel_Links = new LinkedLabel();
        jScrollPane_ServerOutput = new javax.swing.JScrollPane();
        jTextPane_ServerOutput = new javax.swing.JTextPane();
        jPanel_Left = new javax.swing.JPanel();
        jPanel_Connections = new javax.swing.JPanel();
        jButton_ConnectToZagram = new javax.swing.JButton();
        jButton_ConnectToPointsxt = new javax.swing.JButton();
        jTextField_Username = new javax.swing.JTextField();
        jPasswordField_Password = new javax.swing.JPasswordField();
        jLabel_Password = new javax.swing.JLabel();

        jPanel_Right.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel_Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/narod/vn91/pointsop/gui/pointsOP.png"))); // NOI18N

        jLabel_IncontactGroup.setText("<html>О программе MultiPoints</html>");
        jLabel_IncontactGroup.setToolTipText("http://pointsgame.net/site/pointsop");
        jLabel_IncontactGroup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel_Qestions.setText("<html>Обсуждение MultiPoints</html>");
        jLabel_Qestions.setToolTipText("http://vkontakte.ru/pointsgame");
        jLabel_Qestions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel_GameWishes.setText("<html>Информация про ЯроБот</html>");
        jLabel_GameWishes.setToolTipText("http://vkontakte.ru/topic-13325_25000527");
        jLabel_GameWishes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel_ChatWishes.setText("<html>Сайт о игре Точки</html>");
        jLabel_ChatWishes.setToolTipText("http://pointsgame.net");
        jLabel_ChatWishes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel_Links.setText("<html>Полезные ссылки</html>");
        jLabel_Links.setToolTipText("http://pointsgame.net/site/links");
        jLabel_Links.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTextPane_ServerOutput.setEditable(false);
        jTextPane_ServerOutput.setText("Если  ваш интернет блокирует некоторые порты, то поиск соединения может занять время. В этом случае статус будет обновляться в этом окошке раз в ~~3 минуты. После первого успешного подключения задержек не будет.\n\nCоединение:\n----------------------------------------------------------------------------\n");
        jTextPane_ServerOutput.setDisabledTextColor(new java.awt.Color(254, 254, 254));
        jScrollPane_ServerOutput.setViewportView(jTextPane_ServerOutput);

        javax.swing.GroupLayout jPanel_RightLayout = new javax.swing.GroupLayout(jPanel_Right);
        jPanel_Right.setLayout(jPanel_RightLayout);
        jPanel_RightLayout.setHorizontalGroup(
            jPanel_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_IncontactGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Qestions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_GameWishes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Links, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_ChatWishes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane_ServerOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_RightLayout.setVerticalGroup(
            jPanel_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_IncontactGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Qestions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_GameWishes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_ChatWishes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Links, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane_ServerOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_Left.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel_Connections.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "подключиться к:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        jButton_ConnectToZagram.setText("zagram");
        jButton_ConnectToZagram.setNextFocusableComponent(jTextField_Username);
        jButton_ConnectToZagram.setRequestFocusEnabled(false);
        jButton_ConnectToZagram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConnectToZagramActionPerformed(evt);
            }
        });

        jButton_ConnectToPointsxt.setText("IRC **");
        jButton_ConnectToPointsxt.setNextFocusableComponent(jTextField_Username);
        jButton_ConnectToPointsxt.setRequestFocusEnabled(false);
        jButton_ConnectToPointsxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConnectToPointsxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ConnectionsLayout = new javax.swing.GroupLayout(jPanel_Connections);
        jPanel_Connections.setLayout(jPanel_ConnectionsLayout);
        jPanel_ConnectionsLayout.setHorizontalGroup(
            jPanel_ConnectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton_ConnectToPointsxt, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
            .addComponent(jButton_ConnectToZagram, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        );
        jPanel_ConnectionsLayout.setVerticalGroup(
            jPanel_ConnectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ConnectionsLayout.createSequentialGroup()
                .addComponent(jButton_ConnectToPointsxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_ConnectToZagram)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField_Username.setBorder(javax.swing.BorderFactory.createTitledBorder("введите имя"));
        jTextField_Username.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_UsernameKeyPressed(evt);
            }
        });

        jPasswordField_Password.setBorder(javax.swing.BorderFactory.createTitledBorder("пароль (необяз. *)"));
        jPasswordField_Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField_PasswordKeyPressed(evt);
            }
        });

        jLabel_Password.setFont(jLabel_Password.getFont().deriveFont(jLabel_Password.getFont().getSize()-3f));
        jLabel_Password.setLabelFor(jPasswordField_Password);
        jLabel_Password.setText("<html> * при отсутствии пароля <br>\nбудет осуществлён вход  <br>\nгостем <br>\n <br>\n ** нету режима<br>\nвремени 3мин/5ходов,<br>\nигры на рейтинг.<br>\n</html>");

        javax.swing.GroupLayout jPanel_LeftLayout = new javax.swing.GroupLayout(jPanel_Left);
        jPanel_Left.setLayout(jPanel_LeftLayout);
        jPanel_LeftLayout.setHorizontalGroup(
            jPanel_LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_Connections, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField_Password, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(jTextField_Username, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(jLabel_Password))
                .addContainerGap())
        );
        jPanel_LeftLayout.setVerticalGroup(
            jPanel_LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_Connections, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_Left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel_Left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

	private void jButton_ConnectToPointsxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConnectToPointsxtActionPerformed
		connectToPointsxt();
	}//GEN-LAST:event_jButton_ConnectToPointsxtActionPerformed

	private void jTextField_UsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_UsernameKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			connectToPointsxt();
			connectToZagram();
		}
	}//GEN-LAST:event_jTextField_UsernameKeyPressed

	private void jButton_ConnectToZagramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConnectToZagramActionPerformed
		connectToZagram();
	}//GEN-LAST:event_jButton_ConnectToZagramActionPerformed

	private void jPasswordField_PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField_PasswordKeyPressed
		jTextField_UsernameKeyPressed(evt);
	}//GEN-LAST:event_jPasswordField_PasswordKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton_ConnectToPointsxt;
    private javax.swing.JButton jButton_ConnectToZagram;
    private javax.swing.JLabel jLabel_ChatWishes;
    private javax.swing.JLabel jLabel_GameWishes;
    private javax.swing.JLabel jLabel_IncontactGroup;
    private javax.swing.JLabel jLabel_Links;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_Password;
    private javax.swing.JLabel jLabel_Qestions;
    private javax.swing.JPanel jPanel_Connections;
    private javax.swing.JPanel jPanel_Left;
    private javax.swing.JPanel jPanel_Right;
    private javax.swing.JPasswordField jPasswordField_Password;
    private javax.swing.JScrollPane jScrollPane_ServerOutput;
    javax.swing.JTextField jTextField_Username;
    public javax.swing.JTextPane jTextPane_ServerOutput;
    // End of variables declaration//GEN-END:variables
}

class LinkedLabel extends JLabel {

	public LinkedLabel() {
		super();
	}

	@Override
	public void setToolTipText(final String link) {
		super.setToolTipText(link);
		super.addMouseListener(
				new MouseListener() {

					public void mouseReleased(MouseEvent e) {
					}

					public void mousePressed(MouseEvent e) {
					}

					public void mouseExited(MouseEvent e) {
					}

					public void mouseEntered(MouseEvent e) {
					}

					public void mouseClicked(MouseEvent e) {
						if (e.getButton() == MouseEvent.BUTTON1) {
							try {
								java.awt.Desktop.getDesktop().browse(new URI(link));
							} catch (Exception ignored) {
							}
						}
					}
				}
		);
	}

	@Override
	public void setText(String text) {
		// show as a link
		text = text.replaceAll("<html>|<a href=.*>|</a>|</html>", "");
		super.setText(
				"<html><a href=\"\""
						+ ">"
						+ text + "</a></html>"
		);
	}
}
