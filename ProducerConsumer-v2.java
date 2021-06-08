package com.ayush;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.ayush.Main.EOF;

public class Main {
    public static final String EOF = "EOF";
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer myProducer = new MyProducer(buffer, ThreadColor.ANSI_CYAN, bufferLock);
        MyConsumer myConsumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer myConsumer2 = new MyConsumer(buffer, ThreadColor.ANSI_RED, bufferLock);

        executorService.execute(myProducer);
        executorService.execute(myConsumer1);
        executorService.execute(myConsumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_RED + "I am printed for the callable()");
                return "This is the callable reult";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task is interrupted");
        }

        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    @Override
    public void run() {
        Random random  = new Random();
        String nums[] = {"1", "2", "3", "4", "5"};
        for (String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                }
                finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interupted!");
            }
        }
        System.out.println(color + "EOF and exiting...");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        }
        finally {
            bufferLock.unlock();
        }
    }
    private List<String> buffer;
    private String color;

    private ReentrantLock bufferLock;
    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;


    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }
    @Override
    public void run() {
       int counter = 0;
       while (true) {
           if (bufferLock.tryLock()) {
               try {
                   if (buffer.isEmpty()) {
                       continue;
                   }
                   System.out.println(color + "The counter = " + counter);
                   counter = 0;
                   if (buffer.get(0).equals(EOF)) {
                       System.out.println(color + "EOF reached exiting...");
                       break;
                   } else {
                       System.out.println(color + "Removed" + buffer.remove(0));
                   }
               } finally {
                   bufferLock.unlock();
               }
           } else {
               counter++;
           }
       }
    }
}
