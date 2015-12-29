import strings.KMP;
import structures.KMPArray;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by azee on 22.12.14.
 */
public class Main {
    Set<String> blackList = new HashSet<String>(Arrays.asList("abstract", "assert", "boolean", "break",
            "byte", "case", "catch", "char", "class", "const", "continue",
            "default", "do", "double", "else", "enum", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while"));

    void addAllowed(String word, int lineNumber) {
        if (!blackList.contains(word)){
            add(word, lineNumber);
        }
    }

    void add(String word, int lineNumber){
        //ToDo: code to add word to database
    }


    public static void main(String... args) throws IOException {

        String val = "I have $USD in pocket $USD";
        System.out.println(val.replaceAll("\\$"+"USD", "EURO"));



    }








}
