package org.frc1778.freezylib.util;

/**
 * An enum representation of some common units and their symbols.
 *
 * @author FRC 1778 Chill Out
 */
public class Measurement {

  public interface UnitBase {
    public String getSymbol();

    public double getCoefficient();

    public double getConstant();

    public UnitBase getBaseUnit();
  }

  public enum UnitAcceleration implements UnitBase {
    METERS_PER_SECOND_SQUARED("m/s²", 1.0, 0.0),
    GRAVITY("g", 9.81, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitAcceleration(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return METERS_PER_SECOND_SQUARED;
    }
  }

  public enum UnitAngle implements UnitBase {
    DEGREES("°", 1.0, 0),
    ARC_MINUTES("ʹ", 0.016667, 0),
    ARC_SECONDS("ʺ", 0.00027778, 0),
    RADIANS("rad", 57.2958, 0),
    GRADIANS("grad", 0.9, 0),
    REVOLUTIONS("rev", 360, 0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitAngle(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return DEGREES;
    }
  }

  public enum UnitArea implements UnitBase {
    SQUARE_MEGAMETERS("Mm²", 1e12, 0.0),
    SQUARE_KILOMETERS("km²", 1000000.0, 0.0),
    SQUARE_METERS("m²", 1.0, 0.0),
    SQUARE_CENTIMETER("cm²", 0.0001, 0.0),
    SQUARE_MILLIMETERS("mm²", 0.000001, 0.0),
    SQUARE_MICROMETERS("µm²", 1e-12, 0.0),
    SQUARE_NANOMETERS("nm²", 1e-18, 0.0),
    SQUARE_INCHES("in²", 0.00064516, 0.0),
    SQUARE_FEET("ft²", 0.092903, 0.0),
    SQUARE_YARDS("yd²", 0.836127, 0.0),
    SQUARE_MILES("mi²", 2.59e+6, 0.0),
    ACRES("ac", 4046.86, 0.0),
    ARES("a", 100, 0.0),
    HECTARES("ha", 10000, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitArea(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return SQUARE_METERS;
    }
  }

  public enum UnitConcentrationMass implements UnitBase {
    GRAMS_PER_LITER("g/L", 1.0, 0.0),
    MILLIGRAMS_PER_DECILITER("mg/dL", 0.01, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitConcentrationMass(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return GRAMS_PER_LITER;
    }
  }

  public enum UnitDispersion implements UnitBase {
    PARTS_PER_MILLION("ppm", 1.0, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitDispersion(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return PARTS_PER_MILLION;
    }
  }

  public enum UnitDuration implements UnitBase {
    SECONDS("sec", 1.0, 0.0),
    MINUTES("min", 60, 0.0),
    HOURS("hr", 3600, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitDuration(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return SECONDS;
    }
  }

  public enum UnitElectricCharge implements UnitBase {
    COULOMBS("C", 1.0, 0.0),
    MEGAAMPERE_HOURS("MAh", 3.6e9, 0.0),
    KILOAMPERE_HOURS("kAh", 3600000.0, 0.0),
    AMPERE_HOURS("Ah", 3600.0, 0.0),
    MILLIAMPERE_HOURS("mAh", 3.6, 0.0),
    MICROAMPERE_HOURS("µAh", 0.0036, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitElectricCharge(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return COULOMBS;
    }
  }

  public enum UnitElectricCurrent implements UnitBase {
    MEGAAMPERES("MA", 1000000.0, 0.0),
    KILOAMPERES("kA", 1000.0, 0.0),
    AMPERES("A", 1.0, 0.0),
    MILLIAMPERES("mA", 0.001, 0.0),
    MICROAMPERES("µA", 0.000001, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitElectricCurrent(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return AMPERES;
    }
  }

  public enum UnitElectricPotentialDifference implements UnitBase {
    MEGAVOLTS("MV", 1000000.0, 0.0),
    KILOVOLTS("kV", 1000.0, 0.0),
    VOLTS("V", 1.0, 0.0),
    MILLIVOLTS("mV", 0.001, 0.0),
    MICROVOLTS("µV", 0.000001, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitElectricPotentialDifference(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return VOLTS;
    }
  }

  public enum UnitElectricResistance implements UnitBase {
    MEGAOHMS("MΩ", 1000000.0, 0.0),
    KILOOHMS("kΩ", 1000.0, 0.0),
    OHMS("Ω", 1.0, 0.0),
    MILLIOHMS("mΩ", 0.001, 0.0),
    MICROOHMS("µΩ", 0.000001, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitElectricResistance(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return OHMS;
    }
  }

  public enum UnitEnergy implements UnitBase {
    KILOJOULES("kJ", 1000.0, 0.0),
    JOULES("J", 1.0, 0.0),
    KILOCALORIES("kCal", 4184.0, 0.0),
    CALORIES("cal", 4.184, 0.0),
    KILOWATT_HOURS("kWh", 3600000.0, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitEnergy(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return JOULES;
    }
  }

  public enum UnitFrequency implements UnitBase {
    TERAHERTZ("THz", 1e12, 0.0),
    GIGAHERTZ("GHz", 1e9, 0.0),
    MEGAHERTZ("MHz", 1000000.0, 0.0),
    KILOHERTZ("kHz", 1000.0, 0.0),
    HERTZ("Hz", 1.0, 0.0),
    MILLIHERTZ("mHz", 0.001, 0.0),
    MICROHERTZ("µHz", 0.000001, 0.0),
    NANOHERTZ("nHz", 1e-9, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitFrequency(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return HERTZ;
    }
  }

  public enum UnitFuelEfficiency implements UnitBase {
    LITERS_PER_100_KILOMETERS("L/100km", 1.0, 0.0),
    MILES_PER_GALLON("mpg", 0.00425142851, 0.0),
    MILES_PER_IMPERIAL_GALLON("mpg", 0.0035400531, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitFuelEfficiency(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return LITERS_PER_100_KILOMETERS;
    }
  }

  public enum UnitIlluminance implements UnitBase {
    LUX("lx", 1.0, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitIlluminance(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return LUX;
    }
  }

  public enum UnitLength implements UnitBase {
    MEGAMETERS("Mm", 1000000.0, 0.0),
    KILOMETERS("kM", 1000.0, 0.0),
    HECTOMETERS("hm", 100.0, 0.0),
    DECAMETERS("dam", 10.0, 0.0),
    METERS("m", 1.0, 0.0),
    DECIMETERS("dm", 0.1, 0.0),
    CENTIMETERS("cm", 0.01, 0.0),
    MILLIMETERS("mm", 0.001, 0.0),
    MICROMETERS("µm", 0.000001, 0.0),
    NANOMETERS("nm", 1e-9, 0.0),
    PICOMETERS("pm", 1e-12, 0.0),
    INCHES("in", 0.0254, 0.0),
    FEET("ft", 0.3048, 0.0),
    YARDS("yd", 0.9144, 0.0),
    MILES("mi", 1609.34, 0.0),
    SCANDINAVIAN_MILES("smi", 10000, 0.0),
    LIGHT_YEARS("ly", 9.461e+15, 0.0),
    NAUTICAL_MILES("NM", 1852, 0.0),
    FATHOMS("ftm", 1.8288, 0.0),
    FURLONGS("fur", 201.168, 0.0),
    ASTRONOMICAL_UNITS("ua", 1.496e+11, 0.0),
    PARSECS("pc", 3.086e+16, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitLength(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return METERS;
    }
  }

  public enum UnitMass implements UnitBase {
    KILOGRAMS("kg", 1.0, 0.0),
    GRAMS("g", 0.001, 0.0),
    DECIGRAMS("dg", 0.0001, 0.0),
    CENTIGRAMS("cg", 0.00001, 0.0),
    MILLIGRAMS("mg", 0.000001, 0.0),
    MICROGRAMS("µg", 1e9, 0.0),
    NANOGRAMS("ng", 1e-12, 0.0),
    PICOGRAMS("pg", 1e-15, 0.0),
    OUNCES("oz", 0.0283495, 0.0),
    POUNDS("lb", 0.453592, 0.0),
    STONES("st", 0.157473, 0.0),
    METRIC_TONS("t", 1000, 0.0),
    SHORT_TONS("ton", 907.185, 0.0),
    CARATS("ct", 0.0002, 0.0),
    OUNCES_TROY("oz t", 0.03110348, 0.0),
    SLUGS("slug", 14.5939, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitMass(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return KILOGRAMS;
    }
  }

  public enum UnitPower implements UnitBase {
    TERAWATTS("TW", 1e12, 0.0),
    GIGAWATTS("GW", 1e9, 0.0),
    MEGAWATTS("MW", 1000000.0, 0.0),
    KILOWATTS("kW", 1000.0, 0.0),
    WATTS("W", 1.0, 0.0),
    MILLIWATTS("mW", 0.001, 0.0),
    MICROWATTS("µW", 0.000001, 0.0),
    NANOWATTS("nW", 1e-9, 0.0),
    PICOWATTS("pW", 1e-12, 0.0),
    FEMTOWATTS("fW", 1e-15, 0.0),
    HORSEPOWER("hp", 745.7, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitPower(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return WATTS;
    }
  }

  public enum UnitPressure implements UnitBase {
    NEWTONS_PER_METER_SQUARED("N/m²", 1.0, 0.0),
    GIGAPASCALS("GPa", 1e9, 0.0),
    MEGAPASCALS("MPa", 1000000.0, 0.0),
    KILOPASCALS("kPa", 1000.0, 0.0),
    HECTOPASCALS("hPa", 100.0, 0.0),
    INCHES_OF_MERCURY("inHg", 3386.39, 0.0),
    BARS("bar", 100000, 0.0),
    MILLIBARS("mbar", 100, 0.0),
    MILLIMETERS_OF_MERCURY("mmHg", 133.322, 0.0),
    POUNDS_PER_SQUARE_INCH("psi", 6894.76, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitPressure(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return NEWTONS_PER_METER_SQUARED;
    }
  }

  public enum UnitSpeed implements UnitBase {
    METERS_PER_SECOND("m/s", 1.0, 0.0),
    KILOMETERS_PER_HOUR("km/h", 0.277778, 0.0),
    MILES_PER_HOUR("mph", 0.44704, 0.0),
    KNOTS("kn", 0.514444, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitSpeed(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return METERS_PER_SECOND;
    }
  }

  public enum UnitTemperature implements UnitBase {
    KELVIN("K", 1.0, 0),
    DEGREE_CELSIUS("°C", 1.0, 273.15),
    DEGREE_FAHRENHEIT("°F", 5.0 / 9.0, 273.15 - 32 * 5.0 / 9.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitTemperature(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return KELVIN;
    }
  }

  public enum UnitVolume implements UnitBase {
    MEGALITERS("ML", 1000000.0, 0.0),
    KILOLITERS("kL", 1000.0, 0.0),
    LITERS("L", 1.0, 0.0),
    DECILITERS("dL", 0.1, 0.0),
    CENTILITERS("cL", 0.01, 0.0),
    MILLILITERS("mL", 0.001, 0.0),
    CUBIC_KILOMETERS("km³", 1e12, 0.0),
    CUBIC_METERS("m³", 1000.0, 0.0),
    CUBIC_DECIMETERS("dm³", 1.0, 0.0),
    CUBIC_MILLIMETERS("mm³", 0.000001, 0.0),
    CUBIC_INCHES("in³", 0.0163871, 0.0),
    CUBIC_FEET("ft³", 28.3168, 0.0),
    CUBIC_YARDS("yd³", 764.555, 0.0),
    CUBIC_MILES("mi³", 4.168e+12, 0.0),
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

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private UnitVolume(String symbol, double coefficient, double constant) {
      this.symbol = symbol;
      this.coefficient = coefficient;
      this.constant = constant;
    }

    @Override
    public String getSymbol() {
      return symbol;
    }

    @Override
    public double getCoefficient() {
      return coefficient;
    }

    @Override
    public double getConstant() {
      return constant;
    }

    @Override
    public UnitBase getBaseUnit() {
      return MEGALITERS;
    }
  }
}
