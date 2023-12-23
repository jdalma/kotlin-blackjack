package blackjack.state

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class StayTest {

    @Test
    fun profit() {
        val stay = Stay()
        val actual = stay.profit(1000)

        actual shouldBe 1000
    }
}
