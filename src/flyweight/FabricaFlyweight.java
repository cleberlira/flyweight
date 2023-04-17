package flyweight;

import java.util.HashMap;

public class FabricaFlyweight {

	private static final HashMap<TipoForma,Forma> formas = new HashMap<TipoForma,Forma>();

	public static Forma getForma(TipoForma tipo) {
		Forma formaImpl = formas.get(tipo);

		if (formaImpl == null) {
			if (tipo.equals(TipoForma.ELIPTICO_FILL)) {
				formaImpl = new Eliptico(true);
			} else if (tipo.equals(TipoForma.ELIPTICO_NOFILL)) {
				formaImpl = new Eliptico(false);
			} else if (tipo.equals(TipoForma.LINHA)) {
				formaImpl = new Linha();
			}
			formas.put(tipo, formaImpl);
		}
		return formaImpl;
	}
	
	public static enum TipoForma{
		ELIPTICO_FILL,ELIPTICO_NOFILL,LINHA;
	}
}
