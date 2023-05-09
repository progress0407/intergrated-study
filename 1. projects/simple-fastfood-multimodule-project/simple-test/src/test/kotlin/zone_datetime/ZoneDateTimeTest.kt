package zone_datetime

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime

class ZoneDateTimeTest : StringSpec({

    val 한국_타임_존: ZoneId = ZoneId.of("Asia/Seoul")
    val 영국_타임_존: ZoneId = ZoneId.of("Europe/London")

    "한국시와 영국시가 같은 경우" {

        val 한국_일시 = ZonedDateTime.of(LocalDateTime.of(2023, 1, 31, 3, 0), 한국_타임_존)
        val 영국_일시 = ZonedDateTime.of(LocalDateTime.of(2023, 1, 30, 18, 0), 영국_타임_존)

        한국_일시.isEqual(영국_일시) shouldBe true
        한국_일시.equals(영국_일시) shouldBe false // equal은 Zone까지 확인한다
    }

    "한국시가 영국시보다 느린 경우" {

        val 한국_일시 = ZonedDateTime.of(LocalDateTime.of(2023, 1, 31, 3 + 1, 0), 한국_타임_존)
        val 영국_일시 = ZonedDateTime.of(LocalDateTime.of(2023, 1, 30, 18, 0), 영국_타임_존)

        한국_일시.isAfter(영국_일시) shouldBe true
    }

    "한국시가 영국시보다 빠른 경우" {

        val 한국_일시 = ZonedDateTime.of(LocalDateTime.of(2023, 1, 31, 3 - 1, 0), 한국_타임_존)
        val 영국_일시 = ZonedDateTime.of(LocalDateTime.of(2023, 1, 30, 18, 0), 영국_타임_존)

        한국_일시.isBefore(영국_일시) shouldBe true
    }
})
