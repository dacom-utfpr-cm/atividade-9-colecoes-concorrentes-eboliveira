//Autor: Eduardo Barbosa de Oliveira        Data: 15/11/2019
import java.util.*
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

fun main() {
    for(i in 0 until 10) {
        println("Time in millis ArrayBlockingQueue: " + runTest(ArrayBlockingQueue<Int>(1000000)))
        println("Time in millis LinkedBlockingQueue: " + runTest(LinkedBlockingQueue<Int>(100000)))
        Thread.sleep(1000)
    }
}

fun runTest(queue: BlockingQueue<Int>): Long{
    val time = Calendar.getInstance().timeInMillis
    val t1 = Thread(Producer(queue))
    val t2 = Thread(Consumer(queue))
    t1.start()
    t2.start()
    t1.join()
    t2.join()
    val finishTime = Calendar.getInstance().timeInMillis
    return (finishTime - time)
}