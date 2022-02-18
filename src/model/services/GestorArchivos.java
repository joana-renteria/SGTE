package model.services;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.function.Function;

public class GestorArchivos<T> extends File{
    Class<T> clazz;

    public GestorArchivos(String path, Class<T> clazz){
        super(path);
        this.clazz = clazz;
    }

    // Devuelve true si ha podido añadirse, false si no.
	public boolean addObject(T obj){

		boolean fichExists = this.exists(); // Comprobamos si existe antes de hacer nada con él.

		try {
			// Se inicializan los Stream como si el archivo existiera para no sobreescribir en caso de que lo hiciera.
			FileOutputStream fos = new FileOutputStream(this, true);
			ObjectOutputStream oos = new ObjectOutputStream(fos){
				protected void writeStreamHeader() throws IOException{
					reset();
				}
			};

			// Si es que no existe se crea.
			if(!fichExists){
				fos = new FileOutputStream(this); 
				oos = new ObjectOutputStream(fos);
			}

			oos.writeObject(obj);

			oos.close();
			fos.close();
			
		} catch (IOException e) {
			System.out.println("Error, no ha podido añadirse el objeto. (ADDOBJECT)");
            System.out.print("El motivo es: " + e);

			return false;
		}

		return true;
	}

    // Recorre los objetos de un archivo y le aplica la función Consumer.
    public boolean foreach(ThrowerConsumer<T> consum){
        try {
            FileInputStream fis = new FileInputStream(this);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {
                for(;;) consum.accept(this.clazz.cast(ois.readObject())); // Casteamos el objeto a tipo T.
            } catch (EOFException e) {
                // Se han leído todos los objetos del archivo.
            }

            ois.close();
            fis.close();

        } catch (EOFException e){
            System.out.println("El archivo " + this.getPath() + " está vacío...");

            return false;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("(FOREACH) - Error, no han podido leerse objetos en " + this.getPath() + ".");
            System.out.print("El motivo es: " + e);

            return false;
        }

        return true;
    }

    // Recorre un archivo e implementa los cambios en uno nuevo.
    public boolean fileManipulation(Function<T, Boolean> func, ThrowerBiConsumer<ObjectOutputStream, T> consum){

		File auxFich = new File("." + this.getPath() + ".sgteman");

		try {
			FileOutputStream fos = new FileOutputStream(auxFich);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

            this.foreach((obj) -> {
                if (func.apply(obj)) consum.accept(oos, obj);
                else oos.writeObject(obj);
            });

			oos.close();
			fos.close();

		} catch (IOException e) {
			System.out.println("Error, no se ha podido modificar el archivo. (FILEMANIPULATION)");
            System.out.print("El motivo es: " + e);

            return false;
		}

        // Eliminar el anterior
        // Renombrar este

        return true;
	}

    private T match(Function<T, Boolean> func, boolean first){
        T t = null;

        try {
            FileInputStream fis = new FileInputStream(this);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {
                T obj; 

                for(;;) {
                    obj = this.clazz.cast(ois.readObject());
                    if (func.apply(obj)){
                        t = obj;
                        if (first) break;
                    }       
                }
            } catch (EOFException e) {
                // Se han leído todos los objetos del archivo.
            }

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error, no han podido leerse objetos. (MATCH)");
            System.out.print("El motivo es: " + e);

            return null;
        }

        return t;
    }

    // Devuelve el primer objeto que coincida con el predicado.
    public T firstMatch(Function<T, Boolean> func){
        return this.match(func, true);
    }

    // Devuelve el último objeto que coincida con el predicado.
    public T lastMatch(Function<T, Boolean> func){
        return this.match(func, false); // False porque no queremos que nos devuelva la primera coincidencia sino la última.
    }

	// Devuelve true si ha podido realizar reemplazar el objeto.
	public boolean replaceObject(Function<T, Boolean> func, Object newObj){
		return fileManipulation(func, (oos, obj) -> {
            oos.writeObject(newObj); // Añadimos el nuevo objeto pero no el anterior.
        });
	}

	// Devuelve true si ha podido eliminarlo, false si no.
	public boolean deleteObject(Function<T, Boolean> func){
		return fileManipulation(func, (oos, obj) -> {}); // No se realiza ninguna acción de inserción.
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
