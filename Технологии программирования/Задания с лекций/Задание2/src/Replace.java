import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 55135
 */
public class Replace {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String fileName = "log.log";
        String NewfileName = "logNEW.log";
        String search = "  0 ";
        String replace = "null";
        Path path = Paths.get(fileName);
        Path path2 = Paths.get(NewfileName);
        Charset charset = StandardCharsets.UTF_8;
        String NewStr = new String(Files.readAllBytes(path), charset).replace(search, replace);
        Files.write(path2, NewStr.getBytes(charset));
    }
    
}
