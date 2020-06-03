package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Controller.GameController;
import Controller.GameController2;
import Controller.GameController3;

public class MenuView {

	public static void display() {

		JFrame f = new JFrame("Eagles v Sharks");// creating instance of JFrame

		JButton b = new JButton("Play Game with Large board, 12x12, 5 pieces");// creating instance of JButton
		JButton b2 = new JButton("Play Game with Medium board, 11x11, 4 pieces");// creating instance of JButton
		JButton b3 = new JButton("Play Game with Small board, 10x10, 3 pieces ");// creating instance of JButton
		b.setBounds(100, 100, 310, 40);// x axis, y axis, width, height
		b2.setBounds(100, 140, 310, 40);// x axis, y axis, width, height
		b3.setBounds(100, 180, 310, 40);// x axis, y axis, width, height

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				f.dispose();
				new GameController();

			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				f.dispose();
				new GameController2();

			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				f.dispose();
				new GameController3();

			}
		});

		f.add(b);// adding button in JFrame
		f.add(b2);// adding button in JFrame
		f.add(b3);// adding button in JFrame

		f.setSize(500, 350);// 400 width and 350 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible

	}

}
