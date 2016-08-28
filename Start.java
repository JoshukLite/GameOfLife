package gol;

import javax.swing.SwingUtilities;

public class Start {
	public static void main(String[] args) {
		System.out.println(args.length);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (args.length < 1) {
					MainFrame game = new MainFrame();
				}	else if (args.length == 2) {
					int width = Integer.parseInt(args[0]);
					int height = Integer.parseInt(args[1]);
					MainFrame game = new MainFrame(width, height);
				}	else if (args.length == 3) {
					int width = Integer.parseInt(args[0]);
					int height = Integer.parseInt(args[1]);
					int cellWidthAndHeight = Integer.parseInt(args[2]);
					MainFrame game = new MainFrame(width, height, cellWidthAndHeight);
				}	else if (args.length == 4) {
					int width = Integer.parseInt(args[0]);
					int height = Integer.parseInt(args[1]);
					int cellWidthAndHeight = Integer.parseInt(args[2]);
					int precision = Integer.parseInt(args[3]);
					MainFrame game = new MainFrame(width, height, cellWidthAndHeight, precision);
				}
			}
		});
	}
}