package blackjack.state

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BlackjackTest {

    @Test
    fun profit() {
        val blackjack = Blackjack()
        val actual = blackjack.profit(1000)

        actual shouldBe 1500
    }
}
