package learn.kotlin.temp

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Eq {

    @Test
    fun helloEq() {
        val name = "SW.Cho"
        val introduce = """
            hello, my name is ${name}
        """.trimIndent()

        println("introduceMent = ${introduce}")


        Assertions.assertThat(2).isSameAs(1)
    }
}
