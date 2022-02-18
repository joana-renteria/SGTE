package model.services;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.function.Function;

public class GestorArchivos {
    // Devuelve true si ha podido añadirse, false si no.
	public static boolean addObject(File fich, Object obj){

		boolean fichExists = fich.exists(); // Comprobamos si existe antes de hacer nada con él.

		try {
			// Se inicializan los Stream como si el archivo existiera para no sobreescribir en caso de que lo hiciera.
			FileOutputStream fos = new FileOutputStream(fich, true);
			ObjectOutputStream oos = new ObjectOutputStream(fos){
				protected void writeStreamHeader() throws IOException{
					reset();
				}
			};

			// Si es que no existe se crea.
			if(!fichExists){
				fos = new FileOutputStream(fich); 
				oos = new ObjectOutputStream(fos);
			}

			oos.writeObject(obj);

			oos.close();
			fos.close();
			
		} catch (IOException e) {
			System.out.println("Error, no ha podido añadirse el objeto.");
			return false;
		}

		return true;
	}

    // Recorre los objetos de un archivo y le aplica la función Consumer.
    public static boolean fileIteratior(File fich, ThrowerConsumer<Object> consum){
        try {
            FileInputStream fis = new FileInputStream(fich);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {
                for(;;) consum.accept(ois.readObject());
            } catch (EOFException e) {
                // Se han leído todos los objetos del archivo.
                ois.close();
                fis.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error, no han podido leerse objetos.");
            return false;
        }

        return true;
    }

    // Recorre un archivo e implementa los cambios en uno nuevo.
    public static boolean fileManipulation(File fich, Function<Object, Boolean> func, ThrowerBiConsumer<ObjectOutputStream, Object> consum){

		File auxFich = new File("." + fich.getPath() + ".sgteman");

		try {
			FileOutputStream fos = new FileOutputStream(auxFich);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

            fileIteratior(fich, (obj) -> {
                if (func.apply(obj)) consum.accept(oos, obj);
                else oos.writeObject(obj);
            });

			oos.close();
			fos.close();

		} catch (IOException e) {
			System.out.println("Error, no se ha podido modificar el archivo.");
            return false;
		}

        return true;
	}

    // Devuelve el primer objeto que coincida con el predicado.
    public static Object firstMatch(File fich, Function<Object, Boolean> func){
        Object obj = null;

        try {
            FileInputStream fis = new FileInputStream(fich);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {
                for(;;) {
                    obj = ois.readObject();
                    if (func.apply(obj)) break;       
                }
            } catch (EOFException e) {
                // Se han leído todos los objetos del archivo.
                ois.close();
                fis.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error, no han podido leerse objetos.");
            return null;
        }

        return obj;
    }

	// Devuelve true si ha podido realizar reemplazar el objeto.
	public static boolean replaceObject(File fich, Function<Object, Boolean> func, Object newObj){
		return fileManipulation(fich, func, (oos, obj) -> {
            oos.writeObject(newObj); // Añadimos el nuevo objeto pero no el anterior.
        });
	}

	// Devuelve true si ha podido eliminarlo, false si no.
	public static boolean deleteObject(File fich, Function<Object, Boolean> func){
		return fileManipulation(fich, func, (oos, obj) -> {}); // No se realiza ninguna acción de inserción.
	}

    /* INTERFACES PERSONALIZADAS */

	// Creamos una interfaz igual que BiConsumer pero que lance las excepciones que vamos a utilizar.
    public interface ThrowerBiConsumer<T, U> {
        void accept(T t, U u) throws ClassNotFoundException, IOException, EOFException;
    }

    // Creamos una interfaz igual que Consumer pero que lance las excepciones que vamos a utilizar.
    public interface ThrowerConsumer<T> {
        void accept(T t) throws ClassNotFoundException, IOException, EOFException;
    }
}
