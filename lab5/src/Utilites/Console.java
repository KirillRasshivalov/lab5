package Utilites;

import java.io.InputStream;

/**
 * класс интерфейс
 */
public interface Console {
    void print(Object obj);
    void println(Object obj);
    String readline();
    void go(InputStream input, String[] args) throws Exception;
}
