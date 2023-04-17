package flyweight;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import flyweight.FabricaFlyweight.TipoForma;


public class App extends JFrame{

	private static final long serialVersionUID = -1350200437285282550L;
	private final int WIDTH;
	private final int HEIGHT;

	private static final TipoForma formas[] = { TipoForma.LINHA , TipoForma.ELIPTICO_FILL, TipoForma.ELIPTICO_NOFILL };
	private static final Color colors[] = { Color.RED, Color.GREEN, Color.YELLOW };
	
	public App(int largura, int altura){
		this.WIDTH=largura;
		this.HEIGHT=altura;
		Container contentPane = getContentPane();

		JButton startButton = new JButton("Desenhar");
		final JPanel panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(startButton, BorderLayout.SOUTH);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Graphics g = panel.getGraphics();
				for (int i = 0; i < 20; ++i) {
					Forma forma = FabricaFlyweight.getForma(getRandomForma());
					forma.desenhar(g, getRandomX(), getRandomY(), getRandomWidth(),
							getRandomHeight(), getRandomColor());
				}
			}
		});
	}
	
	private TipoForma getRandomForma() {
		return formas[(int) (Math.random() * formas.length)];
	}

	private int getRandomX() {
		return (int) (Math.random() * WIDTH);
	}

	private int getRandomY() {
		return (int) (Math.random() * HEIGHT);
	}

	private int getRandomWidth() {
		return (int) (Math.random() * (WIDTH / 10));
	}

	private int getRandomHeight() {
		return (int) (Math.random() * (HEIGHT / 10));
	}

	private Color getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	public static void main(String[] args) {
		App desenhar = new App(500,600);
	}
}
 