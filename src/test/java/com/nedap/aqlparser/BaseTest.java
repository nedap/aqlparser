package com.nedap.aqlparser;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class BaseTest {

    public String readAQLFromFile(String filename) throws Exception {
        try (final InputStream is = new FileInputStream(filename)) {
            Scanner sc = new Scanner(is);
            StringBuffer sb = new StringBuffer();
            while(sc.hasNext()){
                sb.append(sc.nextLine());
            }
            return sb.toString();
        }
    }

}
