package cc.narztiizzer.brief.component

import android.os.AsyncTask
import org.junit.Test

class ComponentTest{
    @Test
    fun example(){

        var different = 1540400400000 - 1511398800000

        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24
        val monthInMilli = daysInMilli * 30
        val yearsInMilli = monthInMilli * 12

        val elapsedYears = different / yearsInMilli
        different %= yearsInMilli

        val elapsedMonth = different / monthInMilli
        different %= monthInMilli

        val elapsedDays = different / daysInMilli
        different %= daysInMilli

        val elapsedHours = different / hoursInMilli
        different %= hoursInMilli

        val elapsedMinutes = different / minutesInMilli
        different %= minutesInMilli

        val elapsedSeconds = different / secondsInMilli

        val res = DateDifferentResult(elapsedYears, elapsedMonth, elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds)

        val (year, months, days, hours, minutes, seconds) = res
        println()

    }
}

data class DateDifferentResult(val year: Long,
                               val months: Long,
                               val days: Long,
                               val hours: Long,
                               val minutes: Long,
                               val seconds: Long)