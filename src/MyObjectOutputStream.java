
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PMYLS
 */
public class MyObjectOutputStream extends ObjectOutputStream {
    public MyObjectOutputStream() throws IOException {
        super();
    }
    
    public MyObjectOutputStream(OutputStream o) throws IOException {
        super(o);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // Do not write a header
    }
}
