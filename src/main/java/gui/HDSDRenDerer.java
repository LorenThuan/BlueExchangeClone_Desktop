package gui;

import java.awt.BorderLayout;

import java.awt.Component;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import javax.swing.border.EmptyBorder;

import dto.HDSD;


public class HDSDRenDerer extends JPanel implements ListCellRenderer<HDSD> { 
	private JLabel lblHinhAnh = new JLabel();
	private JLabel lblNoiDung = new JLabel();
	private JPanel panel;
	private JPanel panel_1;
	private JPanel contentPane;

	
	public HDSDRenDerer () {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 5, 5));

		contentPane.setLayout(new BorderLayout(5, 5));
		
		lblHinhAnh = new JLabel();
		lblHinhAnh.setSize(100, 1200);
		contentPane.add(lblHinhAnh, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
////		panel.setBorder(new EmptyBorder(0, 30, 0, 0));
//		panel.setBorder(BorderFactory.createEmptyBorder(0, //top
//                2, //left
//                0, //bottom
//                28) //right
//        );
		panel.setLayout(new GridLayout(10, 0, 0, 0));


		
		
		
		lblNoiDung = new JLabel();
		lblNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNoiDung);
		
		add(contentPane);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends HDSD> list, HDSD value, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		if (!(value.getHinhAnh().equals(""))) {
			lblHinhAnh.setIcon(ResizeImage(value.getHinhAnh()));
//			System.out.println(value.getHinhAnh());
		}		
		
		lblNoiDung.setText(value.getNoiDung());

		lblHinhAnh.setOpaque(true);
		lblNoiDung.setOpaque(true);

		if (isSelected) {
			lblHinhAnh.setBackground(list.getSelectionBackground());
			lblNoiDung.setBackground(list.getSelectionBackground());
			contentPane.setBackground(list.getSelectionBackground());
			panel.setBackground(list.getSelectionBackground());
		
			
			setBackground(list.getSelectionBackground());
		} else { // when don't select
			lblHinhAnh.setBackground(list.getBackground());
			lblNoiDung.setBackground(list.getBackground());
			contentPane.setBackground(list.getBackground());
			panel.setBackground(list.getBackground());
			setBackground(list.getBackground());
		}
		return this;
	}
	
	private ImageIcon  ResizeImage (String ImagePath){
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;		 
	 }
}
