package blackjack.state

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BustTest {

    @Test
    fun profit() {
        val bust = Bust()
        val actual = bust.profit(1000)

        actual shouldBe 0
    }
}
