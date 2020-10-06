package converter

sealed class Unit{
    object Invalid: Unit()
}

sealed class WeightUnit: Unit() {
    object Ounce: WeightUnit()
    object Milligram: WeightUnit()
    object Gram: WeightUnit()
    object Kilogram: WeightUnit()
    object Pound: WeightUnit()
}
sealed class LengthUnit: Unit() {
    object Meter: LengthUnit()
    object Millimeter: LengthUnit()
    object Kilometer: LengthUnit()
    object Centimeter: LengthUnit()
    object Foot: LengthUnit()
    object Inch: LengthUnit()
    object Yard: LengthUnit()
    object Mile: LengthUnit()
}

sealed class TemperatureUnit: Unit() {
    object Celsius: TemperatureUnit()
    object Fahrenheit: TemperatureUnit()
    object Kelvins: TemperatureUnit()
}
