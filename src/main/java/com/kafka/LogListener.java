package com.kafka;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.apache.commons.io.input.TailerListenerAdapter;

import java.io.File;

public class LogListener {
    private static final String logDirectoryName = "logs";
    private static final String logFileName = "";

    /**
     * TailerListener implementation.
     */
    static public class ShowLinesListener extends TailerListenerAdapter {
        @Override
        public void handle(String line) {
            System.out.println(line);
        }
    }

    public static void main(String args[]) {

        TailerListener listener  = new ShowLinesListener();
        File file = new File(logDirectoryName+"/"+logFileName);

        Tailer tailer = new Tailer(file, listener, 1000);
        tailer.run();

        try {
            Thread.sleep(100000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        tailer.stop();
    }

    private void getLogFileName(){
        /*
        DO IT !
         */
    }
}
