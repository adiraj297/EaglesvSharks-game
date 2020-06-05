package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;

import Controller.GameController;
import Controller.GameController2;
import Controller.GameController3;
import Model.Board;
import Model.Board2;
import Model.Board3;

/**
 * 
 * @author Aditya Raj
 * @author Rajesh Choudhari
 *
 */
public class MenuView {

	public static void display() {

		JFrame f = new JFrame("Eagles v Sharks");// creating instance of JFrame
		int y = 0;
		JButton b = new JButton("Play Game with Large board, 12x12, 5 pieces");// creating instance of JButton
		JButton b2 = new JButton("Play Game with Medium board, 11x11, 4 pieces");// creating instance of JButton
		JButton b3 = new JButton("Play Game with Small board, 10x10, 3 pieces ");// creating instance of JButton
		JButton loadGame1 = new JButton("Load Last Save Game for Large board, 12x12");// creating instance of JButton
		JButton loadGame2 = new JButton("Load Last Save Game for Medium board, 11x11");// creating instance of JButton
		JButton loadGame3 = new JButton("Load Last Save Game for Small board, 10x10");// creating instance of JButton
		y = y+50;
		b.setBounds(100, y, 310, 40);// x axis, y axis, width, height
		y = y+50;
		b2.setBounds(100, y, 310, 40);// x axis, y axis, width, height
		y = y+50;
		b3.setBounds(100, y, 310, 40);// x axis, y axis, width, height
		
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

		loadGame1.addActionListener(new ActionListener() {
			
			Board board;
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				
				try {
					FileInputStream fi = new FileInputStream(new File("GameDataLargeboard.txt"));
					ObjectInputStream oi = new ObjectInputStream(fi);

					// Write objects to file
					board = (Board) oi.readObject();
					

					oi.close();
					fi.close();
			}
			 catch (FileNotFoundException | ClassNotFoundException e1) {
				System.out.println("File not found");
			 }
				catch (IOException e1) {
					e1.printStackTrace();
					System.out.println("Error initializing stream");
				}

				
				new GameController(board);
			}
		});
		
		loadGame2.addActionListener(new ActionListener() {
			
			Board2 board2;
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				
				try {
					FileInputStream fi = new FileInputStream(new File("GameDataMediumboard.txt"));
					ObjectInputStream oi = new ObjectInputStream(fi);

					// Write objects to file
					board2 = (Board2) oi.readObject();
					

					oi.close();
					fi.close();
			}
			 catch (FileNotFoundException | ClassNotFoundException e1) {
				System.out.println("File not found");
			 }
				catch (IOException e1) {
					e1.printStackTrace();
					System.out.println("Error initializing stream");
				}

				
				new GameController2(board2);
			}
		});
		
		loadGame3.addActionListener(new ActionListener() {
			
			Board3 board3;
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				
				try {
					FileInputStream fi = new FileInputStream(new File("GameDataSmallboard.txt"));
					ObjectInputStream oi = new ObjectInputStream(fi);

					// Write objects to file
					board3 = (Board3) oi.readObject();
					

					oi.close();
					fi.close();
			}
			 catch (FileNotFoundException | ClassNotFoundException e1) {
				System.out.println("File not found");
			 }
				catch (IOException e1) {
					e1.printStackTrace();
					System.out.println("Error initializing stream");
				}

				
				new GameController3(board3);
			}
		});
		
		f.add(b);// adding button in JFrame
		f.add(b2);// adding button in JFrame
		f.add(b3);// adding button in JFrame
		File file1 = new File("GameDataLargeboard.txt");
		File file2 = new File("GameDataMediumboard.txt");
		File file3 = new File("GameDataSmallboard.txt");
		
		
		if(file1.exists())
		{	
			y = y + 50;
			loadGame1.setBounds(100, y, 310, 40);
			f.add(loadGame1);
		}
		if(file2.exists())
		{	
			y = y + 50;
			loadGame2.setBounds(100, y, 310, 40);
			f.add(loadGame2);
		}
		if(file3.exists())
		{	
			y = y + 50;
			loadGame3.setBounds(100, y, 310, 40);
			f.add(loadGame3);
		}
		y = y + 150;
		f.setSize(500, y);// 500 width and 350 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
		

	}

}
