package converter

import javax.xml.crypto.dom.DOMCryptoContext

fun TemperatureConverter (from: Unit, to: Unit, amount: Double): Double {

    var result: Double = 0.0

    if(from == TemperatureUnit.Kelvins) {
        result = when (to) {
            is TemperatureUnit.Celsius -> kelvinsToCelsius(amount)
            is TemperatureUnit.Kelvins -> amount
            else -> kelvinsToFahr(amount)
        }
    }

    if (from == TemperatureUnit.Celsius) {
        result = when (to) {
            is TemperatureUnit.Kelvins -> celsiusToKelvins(amount)
            is TemperatureUnit.Celsius -> amount
            else -> celsiusToFahr(amount)
        }
    }

    if (from == TemperatureUnit.Fahrenheit) {
        result = when (to) {
            is TemperatureUnit.Kelvins -> fahrToKelvins(amount)
            is TemperatureUnit.Fahrenheit -> amount
            else -> fahrToCelsius(amount)
        }
    }

    return result

}

fun celsiusToFahr (amount: Double): Double {
    return amount * 9 / 5 + 32
}

fun fahrToCelsius(amount: Double): Double {
    return (amount - 32) * 5 / 9
}

fun kelvinsToCelsius(amount: Double): Double {
    return amount - 273.15
}

fun celsiusToKelvins(amount: Double): Double {
    return amount + 273.15
}

fun fahrToKelvins(amount: Double): Double {
    return (amount + 459.67) * 5 / 9
}

fun kelvinsToFahr(amount: Double): Double {
    return amount * 9 / 5 - 459.67
}