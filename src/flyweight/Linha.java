package flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class Linha implements Forma {

	
	public Linha(){
		System.out.println("Criando a linha");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void desenhar(Graphics g, int x, int y, int width, int height, Color color) {
		g.setColor(color);
		g.drawLine(x, y, x, y);
		// TODO Auto-generated method stub
		
	}

}
