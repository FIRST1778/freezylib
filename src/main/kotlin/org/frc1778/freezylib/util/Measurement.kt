package org.frc1778.freezylib.util

/**
 * An enum representation of some common units and their symbols.
 *
 * @author FRC 1778 Chill Out
 */
class Measurement(val value: Double, private val unit: Base) {

    interface Base {
        val symbol: String
        val coefficient: Double
        val constant: Double
        val baseUnit: Base
    }

    enum class Unitless(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        UNITLESS("ul", 1.0, 0.0);

        override val baseUnit: Base
            get() = UNITLESS
    }

    enum class Acceleration(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        METERS_PER_SECOND_SQUARED("m/s\u00B2", 1.0, 0.0),
        GRAVITY("g", 9.80665, 0.0);

        override val baseUnit: Base
            get() = METERS_PER_SECOND_SQUARED
    }

    enum class Angle(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        DEGREES("\u00B0", 1.0, 0.0),
        ARC_MINUTES("\u02B9", 1.0 / 60, 0.0),
        ARC_SECONDS("\u02BA", 1.0 / 3600, 0.0),
        RADIANS("rad", 180.0 / Math.PI, 0.0),
        GRADIANS("grad", 0.9, 0.0),
        REVOLUTIONS("rev", 360.0, 0.0);

        override val baseUnit: Base
            get() = DEGREES
    }

    enum class Area(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        SQUARE_MEGAMETERS("Mm\u00B2", 1e+12, 0.0),
        SQUARE_KILOMETERS("km\u00B2", 1e+6, 0.0),
        SQUARE_METERS("m\u00B2", 1.0, 0.0),
        SQUARE_CENTIMETER("cm\u00B2", 1e-4, 0.0),
        SQUARE_MILLIMETERS("mm\u00B2", 1e-6, 0.0),
        SQUARE_MICROMETERS("\u00B5m\u00B2", 1e-12, 0.0),
        SQUARE_NANOMETERS("nm\u00B2", 1e-18, 0.0),
        SQUARE_INCHES("in\u00B2", 0.00064516, 0.0),
        SQUARE_FEET("ft\u00B2", 0.09290304, 0.0),
        SQUARE_YARDS("yd\u00B2", 0.83612736, 0.0),
        SQUARE_MILES("mi\u00B2", 2589988.11, 0.0),
        ACRES("ac", 4046.85642, 0.0),
        ARES("a", 100.0, 0.0),
        HECTARES("ha", 10000.0, 0.0);

        override val baseUnit: Base
            get() = SQUARE_METERS
    }

    enum class ConcentrationMass(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        GRAMS_PER_LITER("g/L", 1.0, 0.0),
        MILLIGRAMS_PER_DECILITER("mg/dL", 0.01, 0.0);

        override val baseUnit: Base
            get() = GRAMS_PER_LITER
    }

    enum class Dispersion(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        PARTS_PER_MILLION("ppm", 1.0, 0.0);

        override val baseUnit: Base
            get() = PARTS_PER_MILLION
    }

    enum class Duration(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        MICROSECONDS("\u00B5s", 1e-6, 0.0),
        MILLISECONDS("ms", 1e-3, 0.0),
        SECONDS("s", 1.0, 0.0),
        MINUTES("min", 60.0, 0.0),
        HOURS("hr", 3600.0, 0.0);

        override val baseUnit: Base
            get() = SECONDS
    }

    enum class ElectricCharge(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        COULOMBS("C", 1.0, 0.0),
        MEGAAMPERE_HOURS("MAh", 3.6e+9, 0.0),
        KILOAMPERE_HOURS("kAh", 3.6e+6, 0.0),
        AMPERE_HOURS("Ah", 3.6e+3, 0.0),
        MILLIAMPERE_HOURS("mAh", 3.6, 0.0),
        MICROAMPERE_HOURS("\u00B5Ah", 3.6e-3, 0.0);

        override val baseUnit: Base
            get() = COULOMBS
    }

    enum class ElectricCurrent(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        MEGAAMPERES("MA", 1e+6, 0.0),
        KILOAMPERES("kA", 1e+3, 0.0),
        AMPERES("A", 1.0, 0.0),
        MILLIAMPERES("mA", 1e-3, 0.0),
        MICROAMPERES("\u00B5A", 1e-6, 0.0);

        override val baseUnit: Base
            get() = AMPERES
    }

    enum class ElectricPotentialDifference(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        MEGAVOLTS("MV", 1e+6, 0.0),
        KILOVOLTS("kV", 1e+3, 0.0),
        VOLTS("V", 1.0, 0.0),
        MILLIVOLTS("mV", 1e-3, 0.0),
        MICROVOLTS("\u00B5V", 1e-6, 0.0);

        override val baseUnit: Base
            get() = VOLTS
    }

    enum class ElectricResistance(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        MEGAOHMS("M\u2126", 1e+6, 0.0),
        KILOOHMS("k\u2126", 1e+3, 0.0),
        OHMS("\u2126", 1.0, 0.0),
        MILLIOHMS("m\u2126", 1e-3, 0.0),
        MICROOHMS("\u00B5\u2126", 1e-6, 0.0);

        override val baseUnit: Base
            get() = OHMS
    }

    enum class Energy(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        KILOJOULES("kJ", 1e+3, 0.0),
        JOULES("J", 1.0, 0.0),
        KILOCALORIES("kCal", 4184.0, 0.0),
        CALORIES("cal", 4.184, 0.0),
        KILOWATT_HOURS("kWh", 3.6e+6, 0.0);

        override val baseUnit: Base
            get() = JOULES
    }

    enum class Frequency(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        TERAHERTZ("THz", 1e+12, 0.0),
        GIGAHERTZ("GHz", 1e+9, 0.0),
        MEGAHERTZ("MHz", 1e+6, 0.0),
        KILOHERTZ("kHz", 1e+3, 0.0),
        HERTZ("Hz", 1.0, 0.0),
        MILLIHERTZ("mHz", 1e-3, 0.0),
        MICROHERTZ("\u00B5Hz", 1e-6, 0.0),
        NANOHERTZ("nHz", 1e-9, 0.0);

        override val baseUnit: Base
            get() = HERTZ
    }

    enum class FuelEfficiency(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        LITERS_PER_100_KILOMETERS("L/100km", 1.0, 0.0),
        MILES_PER_GALLON("mpg", 0.00425142851, 0.0),
        MILES_PER_IMPERIAL_GALLON("mpg", 0.0035400531, 0.0);

        override val baseUnit: Base
            get() = LITERS_PER_100_KILOMETERS
    }

    enum class Illuminance(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        LUX("lx", 1.0, 0.0);

        override val baseUnit: Base
            get() = LUX
    }

    enum class Length(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        MEGAMETERS("Mm", 1e+6, 0.0),
        KILOMETERS("kM", 1e+3, 0.0),
        HECTOMETERS("hm", 1e+2, 0.0),
        DECAMETERS("dam", 1e+1, 0.0),
        METERS("m", 1.0, 0.0),
        DECIMETERS("dm", 1e-1, 0.0),
        CENTIMETERS("cm", 1e-2, 0.0),
        MILLIMETERS("mm", 1e-3, 0.0),
        MICROMETERS("\u00B5m", 1e-6, 0.0),
        NANOMETERS("nm", 1e-9, 0.0),
        PICOMETERS("pm", 1e-12, 0.0),
        INCHES("in", 0.0254, 0.0),
        FEET("ft", 0.3048, 0.0),
        YARDS("yd", 0.9144, 0.0),
        MILES("mi", 1609.344, 0.0),
        SCANDINAVIAN_MILES("smi", 1e+4, 0.0),
        LIGHT_YEARS("ly", 9.4607304725808e+15, 0.0),
        NAUTICAL_MILES("NM", 1852.0, 0.0),
        FATHOMS("ftm", 1.8288, 0.0),
        FURLONGS("fur", 201.168, 0.0),
        ASTRONOMICAL_UNITS("ua", 1.495978707e+11, 0.0),
        PARSECS("pc", 3.085677581e+16, 0.0);

        override val baseUnit: Base
            get() = METERS
    }

    enum class Mass(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        KILOGRAMS("kg", 1.0, 0.0),
        GRAMS("g", 1e-3, 0.0),
        DECIGRAMS("dg", 1e-4, 0.0),
        CENTIGRAMS("cg", 1e-5, 0.0),
        MILLIGRAMS("mg", 1e-6, 0.0),
        MICROGRAMS("\u00B5g", 1e-9, 0.0),
        NANOGRAMS("ng", 1e-12, 0.0),
        PICOGRAMS("pg", 1e-15, 0.0),
        OUNCES("oz", 0.0283495232, 0.0),
        POUNDS("lb", 0.453592371, 0.0),
        STONES("st", 6.35029319, 0.0),
        METRIC_TONS("t", 1000.0, 0.0),
        SHORT_TONS("ton", 907.18474, 0.0),
        CARATS("ct", 2e-4, 0.0),
        OUNCES_TROY("oz t", 0.0311034768, 0.0),
        SLUGS("slug", 14.5939, 0.0);

        override val baseUnit: Base
            get() = KILOGRAMS
    }

    enum class Power(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        TERAWATTS("TW", 1e+12, 0.0),
        GIGAWATTS("GW", 1e+9, 0.0),
        MEGAWATTS("MW", 1e+6, 0.0),
        KILOWATTS("kW", 1e+3, 0.0),
        WATTS("W", 1.0, 0.0),
        MILLIWATTS("mW", 1e-3, 0.0),
        MICROWATTS("\u00B5W", 1e-6, 0.0),
        NANOWATTS("nW", 1e-9, 0.0),
        PICOWATTS("pW", 1e-12, 0.0),
        FEMTOWATTS("fW", 1e-15, 0.0),
        HORSEPOWER("hp", 745.699872, 0.0);

        override val baseUnit: Base
            get() = WATTS
    }

    enum class Pressure(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        NEWTONS_PER_METER_SQUARED("N/m\u00B2", 1.0, 0.0),
        GIGAPASCALS("GPa", 1e+9, 0.0),
        MEGAPASCALS("MPa", 1e+6, 0.0),
        KILOPASCALS("kPa", 1e+3, 0.0),
        HECTOPASCALS("hPa", 1e+2, 0.0),
        INCHES_OF_MERCURY("inHg", 3386.39, 0.0),
        BARS("bar", 1e+5, 0.0),
        MILLIBARS("mbar", 1e+2, 0.0),
        MILLIMETERS_OF_MERCURY("mmHg", 133.322441, 0.0),
        POUNDS_PER_SQUARE_INCH("psi", 6894.75729, 0.0);

        override val baseUnit: Base
            get() = NEWTONS_PER_METER_SQUARED
    }

    enum class Speed(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        METERS_PER_SECOND("m/s", 1.0, 0.0),
        KILOMETERS_PER_HOUR("km/h", 5.0 / 18, 0.0),
        MILES_PER_HOUR("mph", 5.0 / 18 * 1.609344, 0.0),
        KNOTS("kn", 5.0 / 18 * 1.852, 0.0);

        override val baseUnit: Base
            get() = METERS_PER_SECOND
    }

    enum class Temperature(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        KELVIN("K", 1.0, 0.0),
        DEGREE_CELSIUS("\u00B0C", 1.0, 273.15),
        DEGREE_FAHRENHEIT("\u00B0F", 5.0 / 9.0, 273.15 - 32 * 5.0 / 9.0);

        override val baseUnit: Base
            get() = KELVIN
    }

    enum class Volume(override val symbol: String, override val coefficient: Double, override val constant: Double) : Base {
        MEGALITERS("ML", 1e+6, 0.0),
        KILOLITERS("kL", 1e+3, 0.0),
        LITERS("L", 1.0, 0.0),
        DECILITERS("dL", 1e-1, 0.0),
        CENTILITERS("cL", 1e-2, 0.0),
        MILLILITERS("mL", 1e-3, 0.0),
        CUBIC_KILOMETERS("km\u00B3", 1e+12, 0.0),
        CUBIC_METERS("m\u00B3", 1e+3, 0.0),
        CUBIC_DECIMETERS("dm\u00B3", 1.0, 0.0),
        CUBIC_MILLIMETERS("mm\u00B3", 1e-6, 0.0),
        CUBIC_INCHES("in\u00B3", 0.016387064, 0.0),
        CUBIC_FEET("ft\u00B3", 28.3168466, 0.0),
        CUBIC_YARDS("yd\u00B3", 764.554858, 0.0),
        CUBIC_MILES("mi\u00B3", 4.16818183e+12, 0.0),
        ACRE_FEET("af", 1.233e+6, 0.0),
        BUSHELS("bsh", 35.2391, 0.0),
        TEASPOONS("tsp", 0.00492892, 0.0),
        TABLESPOONS("tbsp", 0.0147868, 0.0),
        FLUID_OUNCES("fl oz", 0.0295735, 0.0),
        CUPS("cup", 0.24, 0.0),
        PINTS("pt", 0.473176, 0.0),
        QUARTS("qt", 0.946353, 0.0),
        GALLONS("gal", 3.78541, 0.0),
        IMPERIAL_TEASPOONS("tsp", 0.00591939, 0.0),
        IMPERIAL_TABLESPOONS("tbsp", 0.0177582, 0.0),
        IMPERIAL_FLUID_OUNCES("fl oz", 0.0284131, 0.0),
        IMPERIAL_PINTS("pt", 0.568261, 0.0),
        IMPERIAL_QUARTS("qt", 1.13652, 0.0),
        IMPERIAL_GALLONS("gal", 4.54609, 0.0),
        METRIC_CUPS("metric cup", 0.25, 0.0);

        override val baseUnit: Base
            get() = LITERS
    }

    @Throws(IllegalArgumentException::class)
    fun convertTo(other: Base): Measurement {
        return if (unit.baseUnit == other.baseUnit) {
            Measurement(
                    (unit.coefficient * value + unit.constant - other.constant) / other.coefficient,
                    other)
        } else {
            throw IllegalArgumentException()
        }
    }
}
