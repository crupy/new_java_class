package chapters13;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class user extends JFrame {

	private JPanel mainCard;
	private JTextField idTextField;
	private JPasswordField loginPasswordField;
	private JLabel welcomeMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user frame = new user();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public user() {
		CardLayout card = new CardLayout();						//CardLayout의 card를 생성
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 509);
		mainCard = new JPanel();
		mainCard.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainCard);
		mainCard.setLayout(card);								//card 대입
		
		JPanel loginPanel = new JPanel();
		mainCard.add(loginPanel, "name_9784122318700");			//""가 패널의 키값
		loginPanel.setLayout(null);
		
		idTextField = new JTextField();
		idTextField.setBounds(153, 108, 403, 44);
		loginPanel.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setBounds(153, 83, 57, 15);
		loginPanel.add(idLabel);
		
		JLabel pwdLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwdLabel.setBounds(153, 195, 57, 15);
		loginPanel.add(pwdLabel);
		
		loginPasswordField = new JPasswordField();
		loginPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {		//엔터를 입력했을시
					String id = idTextField.getText();
					String pwd = loginPasswordField.getText();
					UserMgr mgr = new UserMgr();
					int flag = mgr.loginCheck(id, pwd);
					if(flag == 0) {
						JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.", "경고", JOptionPane.PLAIN_MESSAGE);
					}else if(flag == 1) {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "경고", JOptionPane.PLAIN_MESSAGE);
					}else if(flag == 2) {
						welcomeMessage.setText(mgr.welcomeName(id, pwd) + "님 환영합니다.");
						card.show(mainCard,"name_9901008293400");
					}
					
				}
			}
		});
		loginPasswordField.setBounds(153, 220, 403, 44);
		loginPanel.add(loginPasswordField);
		
		JButton loginButton = new JButton("\uB85C\uADF8\uC778");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = idTextField.getText();
				String pwd = loginPasswordField.getText();
				UserMgr mgr = new UserMgr();
				int flag = mgr.loginCheck(id, pwd);
				if(flag == 0) {
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.", "경고", JOptionPane.PLAIN_MESSAGE);
				}else if(flag == 1) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "경고", JOptionPane.PLAIN_MESSAGE);
				}else if(flag == 2) {
					welcomeMessage.setText(mgr.welcomeName(id, pwd) + "님 환영합니다.");
					card.show(mainCard,"name_9901008293400");
				}
			}
		});
		loginButton.setBounds(459, 324, 97, 35);
		loginPanel.add(loginButton);
		
		JPanel homePanel = new JPanel();
		mainCard.add(homePanel, "name_9901008293400");
		homePanel.setLayout(null);
		
		JButton logoutButton = new JButton("\uB85C\uADF8\uC544\uC6C3");
		logoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(mainCard, "name_9784122318700");				//마우스를 클릭하면 mainCard의 loginpanel(키값 = "name_~")로 돌아감
			}
		});
		logoutButton.setBounds(646, 427, 97, 23);
		homePanel.add(logoutButton);
		
		welcomeMessage = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4.");
		welcomeMessage.setHorizontalAlignment(SwingConstants.LEFT);
		welcomeMessage.setBounds(12, 10, 193, 15);
		homePanel.add(welcomeMessage);
		
	}
}
