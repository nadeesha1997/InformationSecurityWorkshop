package thread;

public class ThreadHandler extends Thread{
    private int thread_id=0;
    public ThreadHandler(int d){
        this.thread_id=d;
    }
    @Override
    public void run(){
        for (int i=0;i<=5;i++){
            System.out.println(thread_id+" - "+i);
            if (thread_id==2){
                throw new RuntimeException();
            }
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
