package Structural.Decorator;

import Structural.Decorator.IODecorators.LowerCaseInputStream;
import Structural.Decorator.IODecorators.UpperCaseInputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecoratorIOMain {
    private static void io(InputStream in) throws IOException {
        int c;
        while ((c = in.read()) >= 0) {
            System.out.print((char) c);
        }
    }

    // use data/test.txt
    public static void main(String[] args) {
        try {
            String path = "src/Structural/Decorator/data/test.txt";
            io(new BufferedInputStream(new FileInputStream(path)));
            io(new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(path))));
            io(new UpperCaseInputStream(new BufferedInputStream(new FileInputStream(path))));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
