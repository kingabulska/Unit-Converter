package converter

import java.lang.Exception
data class ParseResult(
        val from: Unit,
        val to: Unit,
        val amount: Double
) {

}
 object Parse {
    fun parseToUnit(input: String): ParseResult {
        val inputList = input.toLowerCase().split(" ")
        val amount:Double
        val from: Unit
        val to: Unit

        if (input[0].isDigit() || input[0] == '-') {
            amount = inputList[0].toDouble()
        } else {
            throw ParseError("Parse error")
        }

        if (inputList[1].contains("degree")) {
            from = (inputList[1] + " " + inputList[2]).toUnit()
            if(inputList[4].contains("degree") && inputList.size > 5) {
                to = (inputList[4] + " " + inputList[5]).toUnit()
            } else {
                to = inputList[4].toUnit()
            }

        } else {
            from = inputList[1].toUnit()

            if(inputList[3].contains("degree") && inputList.size > 4) {
                to = (inputList[3] + " " + inputList[4]).toUnit()
            } else {
                to = inputList[3].toUnit()
            }

        }

        if(from is Unit.Invalid && to !is Unit.Invalid) {
            throw ParseError ("Conversion from ??? to ${to.toPrintedPlural()} is impossible")
        } else if (to is Unit.Invalid && from !is Unit.Invalid) {
            throw ParseError ("Conversion from ${from.toPrintedPlural()} to ??? is impossible")
        } else if (from is Unit.Invalid && to is Unit.Invalid) {
            throw ParseError ("Conversion from ??? to ??? is impossible")
        }

        if(from is LengthUnit && to !is LengthUnit) {
            throw ParseError ("Conversion from ${from.toPrintedPlural()} to ${to.toPrintedPlural()} is impossible")
        } else if (from is WeightUnit && to !is WeightUnit) {
            throw ParseError ("Conversion from ${from.toPrintedPlural()} to ${to.toPrintedPlural()} is impossible")
        } else if (from is TemperatureUnit && to !is TemperatureUnit) {
            throw ParseError ("Conversion from ${from.toPrintedPlural()} to ${to.toPrintedPlural()} is impossible")
        }

        if(from is LengthUnit && amount < 0.0){
            throw ParseError("Length shouldn't be negative")
        }

        if(from is WeightUnit && amount < 0.0) {
            throw ParseError("Weight shouldn't be negative")
        }

        return ParseResult(from, to, amount)
    }

}


fun main() {

    val ask = "Enter what you want to convert (or exit): "

    println(ask)
    var input = readLine()!!

    while (input != "exit") {

        val parseResult: ParseResult
        var convert = 0.0
        try {
            parseResult = Parse.parseToUnit(input)
            val (from, to) = parseResult
            val matrix = Matrix.getMatrix(from, to)

           convert =  matrix.convert(from, to, parseResult.amount)

            val fromToPrint = if (parseResult.amount == 1.0) from.toPrintedSingular()
            else from.toPrintedPlural()

            val toToPrint = if (convert == 1.0) to.toPrintedSingular()
            else to.toPrintedPlural()

            println("${parseResult.amount} $fromToPrint is $convert $toToPrint")

        } catch (e: ParseError) {
            println(e.message)
        }

        println(ask)
        input = readLine()!!
    }

}


