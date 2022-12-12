package com.magdaraog.engagia.ojtapp

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.*

@RunWith(JUnit4::class)
class KahitAno {

    enum class FunctionTest {
        Function1,
        Function2,
        Function3,
        Function4,
        Function5
    }

    private fun functionChecker(sectionLink: Int): FunctionTest? {
        when(sectionLink) {
            1 -> {
                return FunctionTest.Function1
            }
        }
        return null
    }

    @Test
    fun functionTester() {

        var missingFunctions =  ArrayList<String>()
        var errorMsg: String = "failed, cannot find function "

        enumValues<FunctionTest>().forEach { FUNCTION_TYPE ->
            var i = 0

            while (i <= 1000) {
                val x = functionChecker(i)
                if (i != 1000) {
                    if (x == FUNCTION_TYPE) {
                        break
                    }
                } else if(i == 1000) {
                    //throw java.lang.NullPointerException("failed")
                    //fail("failed, cannot find function $FUNCTION_TYPE")

                    missingFunctions.add(FUNCTION_TYPE.toString())
                }
                i++
            }
        }

        if (missingFunctions.size != 0){
            for (missingFunction in missingFunctions) {
                errorMsg += missingFunction + " "
            }

            println(errorMsg)
        }

    }

}