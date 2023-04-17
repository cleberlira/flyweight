package flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class Eliptico implements Forma {

	private boolean preenche;

	public Eliptico(boolean preenche){
		this.preenche=preenche;
		System.out.println("criando eliptico="+ preenche);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void desenhar(Graphics g, int x, int y, int width, int height, Color color) {
		g.setColor(color);
		g.drawOval(x, y, width, height);
		
		if(preenche){
			g.fillOval(x, y, width, height);
		}
		
		// TODO Auto-generated method stub
		
	}

}
