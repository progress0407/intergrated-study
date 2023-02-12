package learn.kotlin.lecture.saechawon

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingFoo() }
        one.await()
        val two = async { doSomethingBoo() }

        println("one.await() = ${one}")
        println("two.await() = ${two.await()}")
    }
    println("elapsed time = ${time}")
}

suspend fun doSomethingFoo() {
    println("something is start ! : foo")
    delay(1_000)
    println("something is done ! : foo")
}

suspend fun doSomethingBoo() {
    println("something is start ! : boo")
    delay(1_000)
    println("something is done ! : boo")
}
