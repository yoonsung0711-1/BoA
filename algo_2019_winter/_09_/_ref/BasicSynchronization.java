public class BasicSynchronization { 
  private String mMessage; 

  public static void main(String[] agrs) { 
    BasicSynchronization temp = new BasicSynchronization(); 

    new Thread(() -> { 
      for (int i = 0; i < 100; i++) { 
        temp.callMe("Thread1"); 
      } 
    }).start(); 

    new Thread(() -> { 
      for (int j = 0; j < 100; j++) { 
        temp.callMe("Thread2"); 
      } 
    }).start(); 

    new Thread(() -> { 
      for (int k = 0; k < 100; k++) { 
        temp.callMe("Thread3"); 
      } 
    }).start(); 
  }

    
  public synchronized void callMe(String whoCallMe) { 
      mMessage = whoCallMe; 

      //try { 
        //long sleep = (long) (Math.random() * 100); 
        //Thread.sleep(sleep); 
      //} catch (InterruptedException e) { 
        //e.printStackTrace(); 
      //} 

      if (mMessage.equals(whoCallMe)) { 
        System.out.println(whoCallMe + " | " + mMessage); 
      } 
    } 
}

