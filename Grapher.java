import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class Grapher extends JFrame {
	Random r = new Random();
	int x, y, s = 800, ds = 6;
	static double n = 0;
	static double k = 0;
	static boolean stp = false;

	Grapher() {
		setVisible(true);
		setBounds(s, 200, s, s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (stp == false)
					stp = true;
				else {
					stp = false;
					repaint();
				}
			}
		});
	}

	public void paint(Graphics g) {
		if (!stp) {
			if (isContained())
				g.setColor(Color.BLUE);
			else
				g.setColor(Color.RED);
			g.fillOval(x, y, ds, ds);
			run();
			repaint();
		}
	}

	public boolean isContained() {
		return (Math.sqrt(Math.pow(x - s / 2, 2) + Math.pow(-1 * y + s / 2, 2)) <= s / 2);
	}

	public void run() {
		Double v = k / n * 4;
		v = Double.parseDouble(String.format("%.9f", v));
		Double p = 100 * Math.abs(((k / n * 4) - Math.PI) / Math.PI);
		p = Double.parseDouble(String.format("%.4f", 100 * Math.abs(((k / n * 4) - Math.PI) / Math.PI)));
		x = r.nextInt(s) + 1;
		y = r.nextInt(s) + 1;
		n++;
		if (isContained()) {
			k++;
		}
		this.setTitle((int) k + " contained out of " + (int) n + ", estimating Pi as " + v + " (" + p + "%)");
	}

	public static void main(String[] args) {
		new Grapher();
	}
}
