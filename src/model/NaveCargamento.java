package model;

import java.util.ArrayList;
import java.util.Optional;

public class NaveCargamento extends Nave {
	
	private int capCargo;
	private ArrayList<String> listaCargamento;
	
	public NaveCargamento(String pCodigo,
			String pNombre, int pCapCargo) {
		super(pCodigo, pNombre);
		this.capCargo = pCapCargo;
	}

	private boolean existeCargamento(Cargamento cargo) {
		Optional<String> cargamento = listaCargamento.stream()
				.filter(p -> p.equals(cargo.getCodigo()))
				.findFirst();
		return cargamento.isPresent();
	}
	
	private void addTripulante(Tripulante trip) {
		
	}

}
