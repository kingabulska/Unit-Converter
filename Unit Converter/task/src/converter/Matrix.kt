package converter

class Matrix private constructor(
        private val units: Array<out Unit>,
        private val coefficients: Array<DoubleArray>
) {

    companion object {

        fun getMatrix(from: Unit, to: Unit): Matrix {
            if(from is WeightUnit && to is WeightUnit){
                return weightMatrix()
            }

            if(from is LengthUnit && to is LengthUnit){
                return lenghtMatrix()
            }

            if(from is TemperatureUnit && to is TemperatureUnit){
                return temperatureMatric()
            }

            throw Exception("Cant parse $from to $to")
        }

        private fun weightMatrix(): Matrix {
            val units: Array<WeightUnit> = arrayOf(
                    WeightUnit.Ounce,
                    WeightUnit.Milligram,
                    WeightUnit.Gram,
                    WeightUnit.Kilogram,
                    WeightUnit.Pound
            )

            val coefs = arrayOf(
                    doubleArrayOf(1.0, 28349.5, 28.3495, 0.0283495231, 0.0625),
                    doubleArrayOf(3.52739 / 100000, 1.0, 0.001, 1 / 1000000.0, 2.20462 / 1000000 ),
                    doubleArrayOf(0.0352739619, 1000.0, 1.0, 0.001, 0.00220462262),
                    doubleArrayOf(35.2739619, 1000000.0, 1000.0, 1.0, 2.20462262),
                    doubleArrayOf(16.0, 453592.0, 453.59237, 0.45359237, 1.0)
            )

            return Matrix(units, coefs)
        }

        private fun lenghtMatrix(): Matrix {
            val units: Array<LengthUnit> = arrayOf(
                    LengthUnit.Millimeter,
                    LengthUnit.Centimeter,
                    LengthUnit.Meter,
                    LengthUnit.Kilometer,
                    LengthUnit.Mile,
                    LengthUnit.Foot,
                    LengthUnit.Inch,
                    LengthUnit.Yard
            )

            val coefs = arrayOf(
                    doubleArrayOf(1.0, 0.1, 0.001, 0.000001, 0.0000006213711, 0.00328084, 0.03937, 0.0010936),
                    doubleArrayOf(10.0, 1.0, 0.01, 0.00001, 0.00000621371192, 0.0328084, 0.3937, 0.010936),
                    doubleArrayOf(1000.0, 100.0, 1.0, 0.001, 0.000621371192, 3.28084, 39.37, 1.09361),
                    doubleArrayOf(1000000.0, 100000.0, 1000.0, 1.0, 0.621371192, 3280.8399, 39370.0787, 1093.6133),
                    doubleArrayOf(1609344.0, 160934.4, 1609.344, 1.609344, 1.0, 5280.0, 63360.0, 1760.0),
                    doubleArrayOf(304.8, 30.48, 0.3048, 0.0003048, 0.0001893939, 1.0, 12.0, 0.33333333),
                    doubleArrayOf(25.4, 2.54, 0.0254, 0.0000254, 0.000015782, 0.083333333, 1.0, 0.0277777777),
                    doubleArrayOf(914.4, 91.44, 0.9144, 0.0009144, 0.000568181, 3.0, 36.0, 1.0)
            )

            return Matrix(units, coefs)
        }

        private fun temperatureMatric(): Matrix {

            val units = arrayOf(TemperatureUnit.Fahrenheit, TemperatureUnit.Celsius, TemperatureUnit.Kelvins)
            val coefs = arrayOf(doubleArrayOf(0.0, 0.0, 0.0), doubleArrayOf(0.0, 0.0, 0.0), doubleArrayOf(0.0, 0.0, 0.0))

            return Matrix(units, coefs)
        }

    }

    fun convert(from: Unit, to: Unit, amount: Double): Double {
        if (from is WeightUnit){

            val idxFrom = units.indexOf(from)
            val idxTo: Int = units.indexOf(to)
            return coefficients[idxFrom][idxTo] * amount
        } else if (from is LengthUnit){

            val idxFrom = units.indexOf(from)
            val idxTo: Int = units.indexOf(to)
            return coefficients[idxFrom][idxTo] * amount
        } else if (from is TemperatureUnit) {

            return TemperatureConverter(from, to, amount)
        }

        return 0.0
    }
}