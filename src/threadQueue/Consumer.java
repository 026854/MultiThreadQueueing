package threadQueue;

public class Consumer implements Runnable {
	private ThreadSafeQueue threadSafeQueue;
	private Counter consumedCount;
	private String name;

	Consumer(ThreadSafeQueue threadSafeQueue, Counter counter, String name) {
		this.threadSafeQueue = threadSafeQueue;
		this.consumedCount = counter;
		this.name = name;
	}

	public void run() {
		while (true) {
			synchronized (consumedCount) {
				try {
					Integer dequeueResult = threadSafeQueue.dequeue();

					consumedCount.addCount();
					System.out.println(name + " dequeue :" + dequeueResult + "\t\t\t\t\t" + "consumedCount :" + consumedCount.getCount());
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}
}
