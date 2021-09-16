package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from  the anonymous class thread");
            }
        }.start();



        // runbale subclass of thread class
        Thread myRunnableThread = new Thread(new MyRunnable() {
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "Hello from the anonymous class's impelemtnation of run()");
                try{
                    anotherThread.join();
                    System.out.println(ThreadColor.ANSI_RED+"anotherThread terminated,or timed out,so i'm running again");
                }catch (InterruptedException e){
                    System.out.println(ThreadColor.ANSI_RED+"I could't wait after all.i was interrupted");
                }

            }
            });

        myRunnableThread.start();
        //anotherThread.interrupt();
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread");

    }
}
