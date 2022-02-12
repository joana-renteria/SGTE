package util;

public class YaExisteException extends Exception {
	
	public YaExisteException(String tipo) {
		super();
		System.out.println("Ya existe " + tipo);
	}
	
}
