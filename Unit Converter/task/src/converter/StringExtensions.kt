package converter

fun String.toUnit() = when (this) {
    in listOf("kg", "kilogram", "kilograms") -> WeightUnit.Kilogram
    in listOf("g", "gram", "grams") -> WeightUnit.Gram
    in listOf("mg", "milligram", "milligrams") -> WeightUnit.Milligram
    in listOf("lb", "pound", "pounds") -> WeightUnit.Pound
    in listOf("oz", "ounce", "ounces") -> WeightUnit.Ounce
    in listOf("mm", "millimeter", "millimeters") -> LengthUnit.Millimeter
    in listOf("cm", "centimeter", "centimeters") -> LengthUnit.Centimeter
    in listOf("m", "meter", "meters") -> LengthUnit.Meter
    in listOf("km", "kilometer", "kilometers") -> LengthUnit.Kilometer
    in listOf("mi", "mile", "miles") -> LengthUnit.Mile
    in listOf("yd", "yard", "yards") -> LengthUnit.Yard
    in listOf("ft", "foot", "feet") -> LengthUnit.Foot
    in listOf("in", "inch", "inches") -> LengthUnit.Inch
    in listOf("degree celsius", "degrees celsius", "celsius", "dc", "c") -> TemperatureUnit.Celsius
    in listOf("degree fahrenheit", "degrees fahrenheit", "fahrenheit", "df", "f") -> TemperatureUnit.Fahrenheit
    in listOf("kelvin", "kelvins", "k") -> TemperatureUnit.Kelvins
    else -> Unit.Invalid
}

fun Unit.toPrintedSingular() = when (this) {
    WeightUnit.Kilogram -> "kilogram"
    WeightUnit.Gram -> "gram"
    WeightUnit.Milligram -> "milligram"
    WeightUnit.Pound -> "pound"
    WeightUnit.Ounce -> "ounce"
    LengthUnit.Millimeter -> "millimeter"
    LengthUnit.Centimeter -> "centimeter"
    LengthUnit.Meter -> "meter"
    LengthUnit.Kilometer -> "kilometer"
    LengthUnit.Mile -> "mile"
    LengthUnit.Yard -> "yard"
    LengthUnit.Foot -> "foot"
    LengthUnit.Inch -> "inch"
    TemperatureUnit.Celsius-> "degree Celsius"
    TemperatureUnit.Fahrenheit -> "degree Fahrenheit"
    TemperatureUnit.Kelvins -> "kelvin"
    else -> throw ParseError("no found")
}

fun Unit.toPrintedPlural() = when (this) {
    WeightUnit.Kilogram -> "kilograms"
    WeightUnit.Gram -> "grams"
    WeightUnit.Milligram -> "milligrams"
    WeightUnit.Pound -> "pounds"
    WeightUnit.Ounce -> "ounces"
    LengthUnit.Millimeter -> "millimeters"
    LengthUnit.Centimeter -> "centimeters"
    LengthUnit.Meter -> "meters"
    LengthUnit.Kilometer -> "kilometers"
    LengthUnit.Mile -> "miles"
    LengthUnit.Yard -> "yards"
    LengthUnit.Foot -> "feet"
    LengthUnit.Inch -> "inches"
    TemperatureUnit.Celsius-> "degrees Celsius"
    TemperatureUnit.Fahrenheit -> "degrees Fahrenheit"
    TemperatureUnit.Kelvins -> "kelvins"
    else -> throw ParseError("no found")
}