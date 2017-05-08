package menjacnica.gui;

import java.awt.EventQueue;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GUIKontroler {
	private static MenjacnicaGUI menjacnica;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnica = new MenjacnicaGUI();
					menjacnica.setVisible(true);
					menjacnica.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							ugasi();
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String izaberiFajl() {
		String f = "";
		try {
			JFileChooser fc = new JFileChooser();
			int odgovor = fc.showOpenDialog(menjacnica);
			if (odgovor == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				f = file.getAbsolutePath();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(menjacnica, ex.getMessage(), "Greska!", JOptionPane.ERROR_MESSAGE);
		}

		return f;

	}

	public static String ucitajFajl() {
		String s = "";
		try {
			JFileChooser jf = new JFileChooser();
			int f = jf.showSaveDialog(menjacnica);
			if (f == JFileChooser.APPROVE_OPTION) {
				File file = jf.getSelectedFile();
				s = file.getAbsolutePath();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(menjacnica, ex.getMessage(), "Greska!", JOptionPane.ERROR_MESSAGE);
		}
		return s;
	}

	public static void ugasi() {
		int a = JOptionPane.showConfirmDialog(menjacnica, "Da li ste sigurni?", "Exit",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (a == JOptionPane.YES_OPTION)
			System.exit(0);

	}

	public static void prikaziInfoOAutoru() {
		JOptionPane.showMessageDialog(menjacnica, "Autor: Tijana Ninkovic\nE-mail: tijana.ninkovic6@gmail.com",
				"O autoru", JOptionPane.INFORMATION_MESSAGE);

	}
}
