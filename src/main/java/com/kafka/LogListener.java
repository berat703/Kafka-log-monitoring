package com.kafka;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;

import java.io.File;

public class LogListener {
    private static final String logDirectoryName = "logs";
    private static final String logFileName = "";
    private static File file;
    private static TailerListener listener = new LogHandler();
    private static Thread tailerThread;
    private static Tailer tailer;

    public void run() {
        checkFileHasChanged();
        initTailer();
    }

    private static File getLogFile(){
        File dir = new File(System.getProperty("user.dir")+"/"+logDirectoryName);
        File[] files = dir.listFiles((dir1, name) -> name.startsWith("log_") && name.endsWith(".log"));
        System.out.println("Log file added..:"+files[0].getName());
        return files != null ? files[0] : null;
    }


    private static void checkFileHasChanged(){
        // run in a second
        final long timeInterval = 2000;
        Runnable runnable = new Runnable() {

            public void run() {
                while (true) {
                    if(file != null){
                        if(!file.exists()){
                            System.out.println("not exists");
                            tailer.stop();
                            initTailer();
                        }
                        try {
                            Thread.sleep(timeInterval);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void initTailer(){
        file = getLogFile();
        tailer = new Tailer(file, listener, 1000);
        tailerThread = new Thread(tailer);
        tailerThread.start();
    }
}
