package threadQueue;

public class Producer implements Runnable {
	private ThreadSafeQueue threadSafeQueue;
	private Counter producedCount;
	private String name;

	Producer(ThreadSafeQueue threadSafeQueue, Counter counter, String name) {
		this.threadSafeQueue = threadSafeQueue;
		this.producedCount = counter;
		this.name = name;
	}

	public void run() {
		while (true) {
			synchronized (producedCount) {
				try {
					if (producedCount.getCount() == 100) {
						break;
					}
					producedCount.addCount();
					System.out.println(name + " enqueue :" + producedCount.getCount() + "\t\t\t\t\t"
						+ "producedCount :"+ producedCount.getCount());
					threadSafeQueue.enqueue(producedCount.getCount());

				} catch (Exception e) {

				}
			}
		}
	}
}
