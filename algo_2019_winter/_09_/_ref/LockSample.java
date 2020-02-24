
public class LockSample {
    public static void main(String[] args) {
    }
}

class Data {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    Data(int size) {
        this.buffer = new char[size];
    }
}

class ReadWriteLock {
    private int readingReaders = 0; 
    private int waitingWriters = 0; 
    private int writingWriters= 0; 
    private boolean preferWriter = true;

}
