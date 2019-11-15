import java.util.concurrent.BlockingQueue
import kotlin.random.Random

class Consumer(val queue: BlockingQueue<Int>) : Runnable{
    override fun run() {
        for(i in 0 until 1000000) {
            queue.take()
        }
    }
}