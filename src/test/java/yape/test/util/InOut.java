package yape.test.util;

import org.apache.poi.EncryptedDocumentException;

import java.io.IOException;
import java.util.List;

public interface InOut {
    List<List<String>> leerDD(String hoja) throws Exception;

    List<List<String>> leerUltimaFilaDD(String hoja) throws EncryptedDocumentException, IOException;

    void escribirDD(List<String> listaString, String id) throws Exception;

    void escribirDD(String string, int filaAEscribir);

    void escribirDD(String string, String id) throws Exception;

    void escribirNuevoDD(List<String> listaString, int dataDriven) throws Exception;

    void escribirNuevoDD(String string, int dataDriven) throws Exception;

    void escribirDD(List<String> listaString, int filaAEscribir) throws Exception;
}
