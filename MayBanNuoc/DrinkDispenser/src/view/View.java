package view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import controller.ControllerInter;
import model.Candy;

import model.ModelInter;
import model.Drinks;
import model.MoneyObserver;

import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.util.List;

import java.awt.event.ActionEvent;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import javax.swing.JFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Dimension;

import java.awt.Cursor;

import java.awt.TextArea;

public class View extends JFrame implements ActionListener, MoneyObserver {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ModelInter model;
	ControllerInter controller;
	private JLabel JlaelSoTien;
	private TextArea textArea;
	private JButton buttonSPDUCool1, buttonSPDUHot2, btn20;

	/**
	 * Create the frame.
	 */
	public View(ModelInter model, ControllerInter controller) {
		this.model = model;
		this.controller = controller;
		model.registerObserver((MoneyObserver) this);

		Drinks p = new Drinks();
		List<Drinks> listP = controller.displayDrinks();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 575);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);

		JMenu mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// ========================= Panel do uong =============================
		JPanel JPanelDU = new JPanel();
		JPanelDU.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblTitel1 = new JLabel("Đồ Uống ");
		lblTitel1.setBounds(153, 11, 65, 17);
		lblTitel1.setForeground(Color.RED);
		lblTitel1.setFont(new Font("Tahoma", Font.BOLD, 14));
		JPanelDU.add(lblTitel1);
		// =========================== DO UONG 1 ====================
		JPanel JPanelSPDU1 = new JPanel();
		JPanelSPDU1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPanelSPDU1.setBounds(10, 47, 111, 232);
		JPanelDU.add(JPanelSPDU1);

		JPanel JPanelHASPDU1 = new JPanel();
		JPanelHASPDU1.setBorder(null);

		JPanel panelSPDU1 = new JPanel();
		panelSPDU1.setLayout(null);

		GroupLayout gl_JPanelSPDU1 = new GroupLayout(JPanelSPDU1);
		gl_JPanelSPDU1.setHorizontalGroup(gl_JPanelSPDU1.createParallelGroup(Alignment.LEADING)
				.addComponent(panelSPDU1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
				.addComponent(JPanelHASPDU1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE));
		gl_JPanelSPDU1.setVerticalGroup(
				gl_JPanelSPDU1.createParallelGroup(Alignment.TRAILING).addGroup(gl_JPanelSPDU1.createSequentialGroup()

						.addComponent(JPanelHASPDU1, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)

						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelSPDU1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)));

		JLabel img1 = new JLabel("New label");
		JPanelHASPDU1.add(img1);

		JLabel labelTenSP1 = new JLabel("Tên :");
		labelTenSP1.setForeground(new Color(153, 51, 153));
		labelTenSP1.setBounds(10, 11, 32, 14);
		panelSPDU1.add(labelTenSP1);

		JLabel labelGiaSP1 = new JLabel("Giá :");
		labelGiaSP1.setForeground(new Color(51, 102, 51));
		labelGiaSP1.setBounds(10, 27, 32, 14);
		panelSPDU1.add(labelGiaSP1);

		JLabel JlaelTenSPDU1 = new JLabel("New label");
		JlaelTenSPDU1.setForeground(new Color(153, 51, 153));
		JlaelTenSPDU1.setBounds(40, 11, 57, 14);
		panelSPDU1.add(JlaelTenSPDU1);

		JLabel JlaelGiaSPDU1 = new JLabel("New label");
		JlaelGiaSPDU1.setForeground(new Color(51, 102, 51));
		JlaelGiaSPDU1.setBounds(40, 27, 57, 14);
		panelSPDU1.add(JlaelGiaSPDU1);
		JPanelSPDU1.setLayout(gl_JPanelSPDU1);
		p = listP.get(0);
		JlaelTenSPDU1.setText(p.getNameP());
		JlaelGiaSPDU1.setText(p.getPrice() + "");

		JButton buttonSPDUHot1 = new JButton("Nóng");
		buttonSPDUHot1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonSPDUHot1.setForeground(new Color(255, 0, 0));
		buttonSPDUHot1.setBounds(5, 52, 97, 23);
		buttonSPDUHot1.setActionCommand(JlaelTenSPDU1.getText());
		buttonSPDUHot1.addActionListener(new actionBuyProductHot());
		panelSPDU1.add(buttonSPDUHot1);

		buttonSPDUCool1 = new JButton("Lạnh");
		buttonSPDUCool1.setForeground(new Color(0, 0, 204));
		buttonSPDUCool1.setBounds(5, 80, 97, 23);
		buttonSPDUCool1.setActionCommand(JlaelTenSPDU1.getText());
		buttonSPDUCool1.addActionListener(new actionBuyProductCool());
		panelSPDU1.add(buttonSPDUCool1);

		if (p.isHot()) {
			buttonSPDUHot1.setVisible(true);
		} else {
			buttonSPDUHot1.setVisible(false);
		}
		// =========================== DO UONG 2 ====================
		JPanel JPanelSPDU2 = new JPanel();
		JPanelSPDU2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPanelSPDU2.setBounds(131, 47, 111, 232);
		JPanelDU.add(JPanelSPDU2);

		JPanel JPanelHASPDU2 = new JPanel();
		JPanelHASPDU2.setBorder(null);

		JPanel panelSPDU2 = new JPanel();
		panelSPDU2.setLayout(null);

		GroupLayout gl_JPanelSPDU2 = new GroupLayout(JPanelSPDU2);
		gl_JPanelSPDU2.setHorizontalGroup(
				gl_JPanelSPDU2.createParallelGroup(Alignment.LEADING).addGap(0, 111, Short.MAX_VALUE)
						.addComponent(JPanelHASPDU2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(panelSPDU2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE));
		gl_JPanelSPDU2
				.setVerticalGroup(gl_JPanelSPDU2.createParallelGroup(Alignment.TRAILING).addGap(0, 232, Short.MAX_VALUE)
						.addGroup(gl_JPanelSPDU2.createSequentialGroup()
								.addComponent(JPanelHASPDU2, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(panelSPDU2,
										GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)));
		JLabel img2 = new JLabel("New label");
		JPanelHASPDU2.add(img2);
		JPanelSPDU2.setLayout(gl_JPanelSPDU2);

		JLabel labelTenSP2 = new JLabel("Tên :");
		labelTenSP2.setForeground(new Color(153, 51, 153));
		labelTenSP2.setBounds(10, 11, 32, 14);
		panelSPDU2.add(labelTenSP2);

		JLabel labelGiaSP2 = new JLabel("Giá :");
		labelGiaSP2.setForeground(new Color(51, 102, 51));
		labelGiaSP2.setBounds(10, 27, 32, 14);
		panelSPDU2.add(labelGiaSP2);

		JLabel JlaelTenSPDU2 = new JLabel("New label");
		JlaelTenSPDU2.setForeground(new Color(153, 51, 153));
		JlaelTenSPDU2.setBounds(40, 11, 57, 14);
		panelSPDU2.add(JlaelTenSPDU2);

		JLabel JlaelGiaSPDU2 = new JLabel("New label");
		JlaelGiaSPDU2.setForeground(new Color(51, 102, 51));
		JlaelGiaSPDU2.setBounds(40, 27, 57, 14);
		panelSPDU2.add(JlaelGiaSPDU2);

		p = listP.get(1);
		JlaelTenSPDU2.setText(p.getNameP());
		JlaelGiaSPDU2.setText(p.getPrice() + "");

		buttonSPDUHot2 = new JButton("Nóng");
		buttonSPDUHot2.setForeground(Color.RED);
		buttonSPDUHot2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonSPDUHot2.setBounds(5, 52, 97, 23);
		buttonSPDUHot2.setActionCommand(JlaelTenSPDU2.getText());
		buttonSPDUHot2.addActionListener(new actionBuyProductHot());
		panelSPDU2.add(buttonSPDUHot2);

		JButton buttonSPDUCool2 = new JButton("Lạnh");
		buttonSPDUCool2.setForeground(new Color(0, 0, 204));
		buttonSPDUCool2.setBounds(5, 80, 97, 23);
		buttonSPDUCool2.setActionCommand(JlaelTenSPDU2.getText());
		buttonSPDUCool2.addActionListener(new actionBuyProductCool());
		panelSPDU2.add(buttonSPDUCool2);

		if (p.isHot()) {
			buttonSPDUHot2.setVisible(true);
		} else {
			buttonSPDUHot2.setVisible(false);
		}
		// =========================== DO UONG 3 ====================
		JPanel JPanelSPDU3 = new JPanel();
		JPanelSPDU3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPanelSPDU3.setBounds(252, 47, 111, 232);
		JPanelDU.add(JPanelSPDU3);

		JPanel JPanelHASPDU3 = new JPanel();
		JPanelHASPDU3.setBorder(null);

		JPanel panelSPDU3 = new JPanel();
		panelSPDU3.setLayout(null);

		GroupLayout gl_JPanelSPDU3 = new GroupLayout(JPanelSPDU3);
		gl_JPanelSPDU3.setHorizontalGroup(
				gl_JPanelSPDU3.createParallelGroup(Alignment.LEADING).addGap(0, 111, Short.MAX_VALUE)
						.addComponent(JPanelHASPDU3, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(panelSPDU3, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE));
		gl_JPanelSPDU3
				.setVerticalGroup(gl_JPanelSPDU3.createParallelGroup(Alignment.TRAILING).addGap(0, 232, Short.MAX_VALUE)
						.addGroup(gl_JPanelSPDU3.createSequentialGroup()
								.addComponent(JPanelHASPDU3, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(panelSPDU3,
										GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)));

		JLabel labelTenSP3 = new JLabel("Tên :");
		labelTenSP3.setForeground(new Color(153, 51, 153));
		labelTenSP3.setBounds(10, 11, 32, 14);
		panelSPDU3.add(labelTenSP3);

		JLabel labelGiaSP3 = new JLabel("Giá :");
		labelGiaSP3.setForeground(new Color(51, 102, 51));
		labelGiaSP3.setBounds(10, 27, 32, 14);
		panelSPDU3.add(labelGiaSP3);

		JLabel JlaelTenSPDU3 = new JLabel("New label");
		JlaelTenSPDU3.setForeground(new Color(153, 51, 153));
		JlaelTenSPDU3.setBounds(40, 11, 57, 14);
		panelSPDU3.add(JlaelTenSPDU3);

		JLabel JlaelGiaSPDU3 = new JLabel("New label");
		JlaelGiaSPDU3.setForeground(new Color(51, 102, 51));
		JlaelGiaSPDU3.setBounds(40, 27, 57, 14);
		panelSPDU3.add(JlaelGiaSPDU3);

		p = listP.get(2);
		JlaelTenSPDU3.setText(p.getNameP());
		JlaelGiaSPDU3.setText(p.getPrice() + "");

		JButton buttonSPDUHot3 = new JButton("Nóng");
		buttonSPDUHot3.setForeground(Color.RED);
		buttonSPDUHot3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonSPDUHot3.setBounds(5, 52, 97, 23);
		buttonSPDUHot3.setActionCommand(JlaelTenSPDU3.getText());
		buttonSPDUHot3.addActionListener(new actionBuyProductHot());
		panelSPDU3.add(buttonSPDUHot3);

		JButton buttonSPDUCool3 = new JButton("Lạnh");
		buttonSPDUCool3.setForeground(new Color(0, 0, 204));
		buttonSPDUCool3.setBounds(5, 80, 97, 23);
		buttonSPDUCool3.setActionCommand(JlaelTenSPDU3.getText());
		buttonSPDUCool3.addActionListener(new actionBuyProductCool());
		panelSPDU3.add(buttonSPDUCool3);

		JLabel img3 = new JLabel("New label");
		JPanelHASPDU3.add(img3);
		JPanelSPDU3.setLayout(gl_JPanelSPDU3);

		if (p.isHot()) {
			buttonSPDUHot3.setVisible(true);
		} else {
			buttonSPDUHot3.setVisible(false);
		}
		// =========================== Panel banh keo ====================
		JPanel JPanelBK = new JPanel();
		JPanelBK.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPanelBK.setLayout(null);

		Candy c = new Candy();
		List<Candy> listC = controller.displayCandy();
		c = (Candy) listC.get(0);

		JLabel lblBanhKeo = new JLabel("Bánh Kẹo");
		lblBanhKeo.setForeground(Color.RED);
		lblBanhKeo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBanhKeo.setBounds(142, 11, 89, 17);
		JPanelBK.add(lblBanhKeo);
		// =========================== Panel banh keo 1 ====================
		JPanel JPanelSPBK1 = new JPanel();
		JPanelSPBK1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPanelSPBK1.setBounds(10, 47, 111, 232);
		JPanelBK.add(JPanelSPBK1);

		JPanel JPanelHASPBK1 = new JPanel();
		JPanelHASPBK1.setBorder(null);

		JPanel panelSPK1 = new JPanel();
		panelSPK1.setLayout(null);

		JLabel img4 = new JLabel("New label");
		JPanelHASPBK1.add(img4);

		JLabel labelTenBK1 = new JLabel("Tên :");
		labelTenBK1.setForeground(new Color(153, 51, 153));
		labelTenBK1.setBounds(10, 11, 32, 14);
		panelSPK1.add(labelTenBK1);

		JLabel labelGiaK1 = new JLabel("Giá :");
		labelGiaK1.setForeground(new Color(51, 102, 51));
		labelGiaK1.setBounds(10, 27, 32, 14);
		panelSPK1.add(labelGiaK1);

		JLabel JlaelTenSPBK1 = new JLabel("New label");
		JlaelTenSPBK1.setForeground(new Color(153, 51, 153));
		JlaelTenSPBK1.setBounds(40, 11, 57, 14);
		panelSPK1.add(JlaelTenSPBK1);

		JLabel JlaelGiaSPBK1 = new JLabel("New label");
		JlaelGiaSPBK1.setForeground(new Color(51, 102, 51));
		JlaelGiaSPBK1.setBounds(40, 27, 57, 14);
		panelSPK1.add(JlaelGiaSPBK1);

		JlaelTenSPBK1.setText(c.getNameP());
		JlaelGiaSPBK1.setText(c.getPrice() + "");
		c = (Candy) listC.get(1);

		JButton btnMua1 = new JButton("Mua");
		btnMua1.setForeground(Color.RED);
		btnMua1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMua1.setBounds(5, 52, 97, 23);
		btnMua1.setActionCommand(JlaelTenSPBK1.getText());
		btnMua1.addActionListener(new actionBuyProductCandy());
		panelSPK1.add(btnMua1);

		GroupLayout gl_JPanelSPBK1 = new GroupLayout(JPanelSPBK1);
		gl_JPanelSPBK1.setHorizontalGroup(
				gl_JPanelSPBK1.createParallelGroup(Alignment.LEADING).addGap(0, 111, Short.MAX_VALUE)
						.addComponent(JPanelHASPBK1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(panelSPK1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE));
		gl_JPanelSPBK1
				.setVerticalGroup(gl_JPanelSPBK1.createParallelGroup(Alignment.TRAILING).addGap(0, 232, Short.MAX_VALUE)
						.addGroup(gl_JPanelSPBK1.createSequentialGroup()
								.addComponent(JPanelHASPBK1, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelSPK1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)));
		JPanelSPBK1.setLayout(gl_JPanelSPBK1);

		// =========================== Panel banh keo 2 ====================

		JPanel JPanelSPBK2 = new JPanel();
		JPanelSPBK2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPanelSPBK2.setBounds(131, 47, 111, 232);
		JPanelBK.add(JPanelSPBK2);

		JPanel JPanelHASPBK2 = new JPanel();
		JPanelHASPBK2.setBorder(null);

		JPanel panelBK2 = new JPanel();
		panelBK2.setLayout(null);

		JLabel img5 = new JLabel("New label");
		JPanelHASPBK2.add(img5);

		JLabel labelTenBK2 = new JLabel("Tên :");
		labelTenBK2.setForeground(new Color(153, 51, 153));
		labelTenBK2.setBounds(10, 11, 32, 14);
		panelBK2.add(labelTenBK2);

		JLabel labelGiaBK2 = new JLabel("Giá :");
		labelGiaBK2.setForeground(new Color(51, 102, 51));
		labelGiaBK2.setBounds(10, 27, 32, 14);
		panelBK2.add(labelGiaBK2);

		JLabel JlaelTenSPBK2 = new JLabel("New label");
		JlaelTenSPBK2.setForeground(new Color(153, 51, 153));
		JlaelTenSPBK2.setBounds(40, 11, 57, 14);
		panelBK2.add(JlaelTenSPBK2);

		JLabel JlaelGiaSPBK2 = new JLabel("New label");
		JlaelGiaSPBK2.setForeground(new Color(51, 102, 51));
		JlaelGiaSPBK2.setBounds(40, 27, 57, 14);
		panelBK2.add(JlaelGiaSPBK2);

		JlaelTenSPBK2.setText(c.getNameP());
		JlaelGiaSPBK2.setText(c.getPrice() + "");
		c = (Candy) listC.get(2);

		JButton btnMua2 = new JButton("Mua");
		btnMua2.setForeground(Color.RED);
		btnMua2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMua2.setBounds(5, 52, 97, 23);
		btnMua2.setActionCommand(JlaelTenSPBK2.getText());
		btnMua2.addActionListener(new actionBuyProductCandy());
		panelBK2.add(btnMua2);

		GroupLayout gl_JPanelSPBK2 = new GroupLayout(JPanelSPBK2);
		gl_JPanelSPBK2.setHorizontalGroup(gl_JPanelSPBK2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 111, Short.MAX_VALUE).addGap(0, 111, Short.MAX_VALUE)
				.addComponent(JPanelHASPBK2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
				.addComponent(panelBK2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE));
		gl_JPanelSPBK2.setVerticalGroup(gl_JPanelSPBK2.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 232, Short.MAX_VALUE).addGap(0, 232, Short.MAX_VALUE)
				.addGroup(gl_JPanelSPBK2.createSequentialGroup()
						.addComponent(JPanelHASPBK2, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelBK2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)));

		JPanelSPBK2.setLayout(gl_JPanelSPBK2);

		// =========================== Panel banh keo 3 ====================

		JPanel JPanelSPBK3 = new JPanel();
		JPanelSPBK3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPanelSPBK3.setBounds(252, 47, 111, 232);
		JPanelBK.add(JPanelSPBK3);

		JPanel JPanelHASPBK3 = new JPanel();
		JPanelHASPBK3.setBorder(null);

		JPanel panelBK3 = new JPanel();
		panelBK3.setLayout(null);

		JLabel img6 = new JLabel("New label");
		JPanelHASPBK3.add(img6);

		JLabel labelTenBK3 = new JLabel("Tên :");
		labelTenBK3.setForeground(new Color(153, 51, 153));
		labelTenBK3.setBounds(10, 11, 32, 14);
		panelBK3.add(labelTenBK3);

		JLabel labelGiaK3 = new JLabel("Giá :");
		labelGiaK3.setForeground(new Color(51, 102, 51));
		labelGiaK3.setBounds(10, 27, 32, 14);
		panelBK3.add(labelGiaK3);

		JLabel JlaelTenSPBK3 = new JLabel("New label");
		JlaelTenSPBK3.setForeground(new Color(153, 51, 153));
		JlaelTenSPBK3.setBounds(40, 11, 57, 14);
		panelBK3.add(JlaelTenSPBK3);

		JLabel JlaelGiaSPBK3 = new JLabel("New label");
		JlaelGiaSPBK3.setForeground(new Color(51, 102, 51));
		JlaelGiaSPBK3.setBounds(40, 27, 57, 14);
		panelBK3.add(JlaelGiaSPBK3);

		JlaelTenSPBK3.setText(c.getNameP());
		JlaelGiaSPBK3.setText(c.getPrice() + "");

		JButton btnMua3 = new JButton("Mua");
		btnMua3.setForeground(Color.RED);
		btnMua3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMua3.setBounds(5, 52, 97, 23);
		btnMua3.setActionCommand(JlaelGiaSPBK3.getText());
		btnMua3.addActionListener(new actionBuyProductCandy());
		panelBK3.add(btnMua3);

		GroupLayout gl_JPanelSPBK3 = new GroupLayout(JPanelSPBK3);
		gl_JPanelSPBK3.setHorizontalGroup(gl_JPanelSPBK3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 111, Short.MAX_VALUE).addGap(0, 111, Short.MAX_VALUE)
				.addComponent(JPanelHASPBK3, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
				.addComponent(panelBK3, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE));
		gl_JPanelSPBK3.setVerticalGroup(gl_JPanelSPBK3.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 232, Short.MAX_VALUE).addGap(0, 232, Short.MAX_VALUE)
				.addGroup(gl_JPanelSPBK3.createSequentialGroup()
						.addComponent(JPanelHASPBK3, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelBK3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)));

		JPanelSPBK3.setLayout(gl_JPanelSPBK3);

		// Panel Tien thanh toan
		// =======================================================================================================================
		JPanel JPanelTien = new JPanel();
		JPanelTien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblSTien = new JLabel("Số tiền : ");
		lblSTien.setForeground(new Color(51, 0, 255));
		lblSTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSTien.setBounds(10, 11, 88, 33);
		JPanelTien.add(lblSTien);

		JlaelSoTien = new JLabel("0");
		JlaelSoTien.setForeground(new Color(51, 0, 255));
		JlaelSoTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JlaelSoTien.setBounds(108, 11, 155, 33);
		JPanelTien.add(JlaelSoTien);

		JButton btnHoanTat = new JButton("Hoàn Tất");
		btnHoanTat.setForeground(new Color(0, 153, 153));
		btnHoanTat.setBounds(107, 55, 89, 23);
		btnHoanTat.setActionCommand("0");
		btnHoanTat.addActionListener(new resetMoney());
		JPanelTien.add(btnHoanTat);
		JPanelDU.setLayout(null);

		// Panel nhap tien
		// =======================================================================================================================
		JPanel JPanelSoTien = new JPanel();
		JPanelSoTien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JButton btn10 = new JButton("10,000");
		btn10.setForeground(new Color(0, 153, 153));
		btn10.setBounds(10, 29, 75, 23);
		btn10.setActionCommand("10000");
		btn10.addActionListener(new actionAddMoney());
		JPanelSoTien.add(btn10);

		btn20 = new JButton("20,000");
		btn20.setForeground(new Color(0, 153, 153));
		btn20.setBounds(95, 29, 75, 23);
		btn20.setActionCommand("20000");
		btn20.addActionListener(new actionAddMoney());
		JPanelSoTien.add(btn20);

		JButton btn50 = new JButton("50,000");
		btn50.setForeground(new Color(0, 153, 153));
		btn50.setBounds(180, 29, 75, 23);
		btn50.setActionCommand("50000");
		btn50.addActionListener(new actionAddMoney());
		JPanelSoTien.add(btn50);

		JButton btn100 = new JButton("100,000");
		btn100.setForeground(new Color(0, 153, 153));
		btn100.setBounds(265, 29, 90, 23);
		btn100.setActionCommand("100000");
		btn100.addActionListener(new actionAddMoney());
		JPanelSoTien.add(btn100);
		JPanelTien.setLayout(null);

		// Panel hien thi console
		// =======================================================================================================================
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		panel.setVerifyInputWhenFocusTarget(false);
		panel.setRequestFocusEnabled(false);
		panel.setOpaque(false);
		panel.setFocusable(false);
		panel.setFocusTraversalKeysEnabled(false);
		panel.setDoubleBuffered(false);
		panel.setEnabled(false);
		panel.setMaximumSize(new Dimension(50, 50));
		panel.setToolTipText("ac");
		panel.setName("Console");
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblLu = new JLabel("Lưu ý:");
		lblLu.setForeground(Color.RED);
		lblLu.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblCcSnPhm = new JLabel("Các sản phẩm nóng sẽ được tính giá tăng 20%");
		lblCcSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblMyChNhn = new JLabel("Máy chỉ nhận tiền giấy không nhận tiền xu và không trả tiền lẻ ");
		lblMyChNhn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(JPanelTien, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
						.addComponent(JPanelDU, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
						.addComponent(JPanelSoTien, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
								.addComponent(JPanelBK, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMyChNhn, GroupLayout.PREFERRED_SIZE, 373, Short.MAX_VALUE)
								.addComponent(lblLu)
								.addComponent(lblCcSnPhm))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(JPanelDU, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
						.addComponent(JPanelBK, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(JPanelTien, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(JPanelSoTien, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLu)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCcSnPhm)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblMyChNhn, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addGap(13))
		);
		panel.setLayout(null);
		contentPane.setLayout(gl_contentPane);

		textArea = new TextArea();
		textArea.setFocusable(false);
		textArea.setFocusTraversalKeysEnabled(false);
		textArea.setBackground(Color.WHITE);
		textArea.setSize(new Dimension(20, 50));
		textArea.setColumns(5);
		textArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textArea.setForeground(Color.RED);
		textArea.setEditable(false);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea.setName("Hiển thị thông báo console");
		textArea.setBounds(0, 0, 373, 98);
		panel.add(textArea);

		ImageIcon imgThisImg1 = new ImageIcon("img/coca.jpg");
		img1.setIcon(imgThisImg1);
		ImageIcon imgThisImg2 = new ImageIcon("img/tra.jpg");
		img2.setIcon(imgThisImg2);
		ImageIcon imgThisImg3 = new ImageIcon("img/cafe.jpg");
		img3.setIcon(imgThisImg3);
		ImageIcon imgThisImg4 = new ImageIcon("img/oishi.jpg");
		img4.setIcon(imgThisImg4);
		ImageIcon imgThisImg5 = new ImageIcon("img/snack.jpg");
		img5.setIcon(imgThisImg5);
		ImageIcon imgThisImg6 = new ImageIcon("img/bimbim.jpg");
		img6.setIcon(imgThisImg6);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void updateMoney(double money) {
		JlaelSoTien.setText(money + "");
	}

	@Override
	public void resetMoney(double money) {
		JlaelSoTien.setText(money + "");

	}

	@Override
	public void updateBuy(boolean buyOk, double priceBuy) {
		if (buyOk) {
			textArea.setText("Bạn đã mua thành công 1 sản phẩm.\nTài khoản cua bạn bị trừ " + priceBuy + " đ\n");
		} else {
			textArea.setText(
					"Mua không thành công.\nSản phẩm bạn mua đã hết \nhoặc tài khoản của bạn không đủ tiền.\nVui lòng nạp thêm tiền vào tài khoản. Cảm ơn!");
		}
	}

	class actionAddMoney implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// controller.clickAddMoney(Integer.parseInt(e.getActionCommand()));
			controller.clickAddMoney(Integer.parseInt(e.getActionCommand()));

			if (e.getActionCommand() == "10000") {
				textArea.setText("Bạn vừa thêm 10,000.đ vào tài khoản.\n");
			}
			if (e.getActionCommand() == "20000") {
				textArea.setText("Bạn vừa thêm 20,000.đ vào tài khoản.\n");
			}
			if (e.getActionCommand() == "50000") {
				textArea.setText("Bạn vừa thêm 50,000.đ vào tài khoản.\n");
			}
			if (e.getActionCommand() == "100000") {
				textArea.setText("Bạn vừa thêm 100,000.đ vào tài khoản.\n");
			}

		}

	}

	class actionBuyProductHot implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.clickBuyProductHot(e.getActionCommand());

		}

	}

	class actionBuyProductCool implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.clickBuyProductCool(e.getActionCommand());
		}

	}

	class actionBuyProductCandy implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.clickBuyProductCandy(e.getActionCommand());
		}

	}

	class resetMoney implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,
					"Bạn vừa hoàn tất quá trình mua hàng \n Hệ thống sẽ trả lại bạn: " + JlaelSoTien.getText() + "đồng",
					"Thông Báo", JOptionPane.INFORMATION_MESSAGE);

			controller.clickResetMoney();
			textArea.setText("Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi.\n");

		}

	}
}
