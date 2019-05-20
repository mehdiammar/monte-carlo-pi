import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class Grapher extends JFrame {
	Random r = new Random();
	int x, y, s = 800, ds = 3;
	static double n = 0;
	static double k = 0;

	Grapher() {
		setVisible(true);
		setBounds(s, 200, s, s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void paint(Graphics g) {
		g.drawOval(3, 26, 793, 770);
		g.fillOval(x, y, ds, ds);
		run();
		repaint();
	}

	public boolean isContained() {
		return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= s);
	}

	public void run() {
		x = r.nextInt(s) + 1;
		y = r.nextInt(s) + 1;
		n++;
		if (isContained()) {
			k++;
		}
		this.setTitle(k / n * 4 + "");
	}

	public static void main(String[] args) {
		new Grapher();
	}
}
