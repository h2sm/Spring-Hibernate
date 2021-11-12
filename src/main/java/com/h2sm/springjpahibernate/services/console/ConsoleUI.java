package com.h2sm.springjpahibernate.services.console;


import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);

    public String read() {
        System.out.println(">");
        return scanner.nextLine();
    }
    public void say(String s){
        writer.println(s);
        writer.flush();
    }
}
