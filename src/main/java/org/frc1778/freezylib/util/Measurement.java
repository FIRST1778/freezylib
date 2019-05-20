package org.frc1778.freezylib.util;

/**
 * An enum representation of some common units and their symbols.
 *
 * @author FRC 1778 Chill Out
 */
public class Measurement {

  public interface Base {
    public String getSymbol();

    public double getCoefficient();

    public double getConstant();

    public Base getBaseUnit();
  }

  public enum Acceleration implements Base {
    METERS_PER_SECOND_SQUARED("m/s²", 1.0, 0.0),
    GRAVITY("g", 9.80665, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Acceleration(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return METERS_PER_SECOND_SQUARED;
    }
  }

  public enum Angle implements Base {
    DEGREES("°", 1.0, 0),
    ARC_MINUTES("ʹ", 1.0 / 60, 0),
    ARC_SECONDS("ʺ", 1.0 / 3600, 0),
    RADIANS("rad", 180.0 / Math.PI, 0),
    GRADIANS("grad", 0.9, 0),
    REVOLUTIONS("rev", 360, 0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Angle(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return DEGREES;
    }
  }

  public enum Area implements Base {
    SQUARE_MEGAMETERS("Mm²", 1e+12, 0.0),
    SQUARE_KILOMETERS("km²", 1e+6, 0.0),
    SQUARE_METERS("m²", 1.0, 0.0),
    SQUARE_CENTIMETER("cm²", 1e-4, 0.0),
    SQUARE_MILLIMETERS("mm²", 1e-6, 0.0),
    SQUARE_MICROMETERS("µm²", 1e-12, 0.0),
    SQUARE_NANOMETERS("nm²", 1e-18, 0.0),
    SQUARE_INCHES("in²", 0.00064516, 0.0),
    SQUARE_FEET("ft²", 0.09290304, 0.0),
    SQUARE_YARDS("yd²", 0.83612736, 0.0),
    SQUARE_MILES("mi²", 2589988.11, 0.0),
    ACRES("ac", 4046.85642, 0.0),
    ARES("a", 100, 0.0),
    HECTARES("ha", 10000, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Area(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return SQUARE_METERS;
    }
  }

  public enum ConcentrationMass implements Base {
    GRAMS_PER_LITER("g/L", 1.0, 0.0),
    MILLIGRAMS_PER_DECILITER("mg/dL", 0.01, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private ConcentrationMass(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return GRAMS_PER_LITER;
    }
  }

  public enum Dispersion implements Base {
    PARTS_PER_MILLION("ppm", 1.0, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Dispersion(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return PARTS_PER_MILLION;
    }
  }

  public enum Duration implements Base {
    MICROSECONDS("µs", 1e-6, 0.0),
    MILLISECONDS("ms", 1e-3, 0.0),
    SECONDS("s", 1, 0.0),
    MINUTES("min", 60, 0.0),
    HOURS("hr", 3600, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Duration(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return SECONDS;
    }
  }

  public enum ElectricCharge implements Base {
    COULOMBS("C", 1.0, 0.0),
    MEGAAMPERE_HOURS("MAh", 3.6e+9, 0.0),
    KILOAMPERE_HOURS("kAh", 3.6e+6, 0.0),
    AMPERE_HOURS("Ah", 3.6e+3, 0.0),
    MILLIAMPERE_HOURS("mAh", 3.6, 0.0),
    MICROAMPERE_HOURS("µAh", 3.6e-3, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private ElectricCharge(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return COULOMBS;
    }
  }

  public enum ElectricCurrent implements Base {
    MEGAAMPERES("MA", 1e+6, 0.0),
    KILOAMPERES("kA", 1e+3, 0.0),
    AMPERES("A", 1.0, 0.0),
    MILLIAMPERES("mA", 1e-3, 0.0),
    MICROAMPERES("µA", 1e-6, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private ElectricCurrent(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return AMPERES;
    }
  }

  public enum ElectricPotentialDifference implements Base {
    MEGAVOLTS("MV", 1e+6, 0.0),
    KILOVOLTS("kV", 1e+3, 0.0),
    VOLTS("V", 1.0, 0.0),
    MILLIVOLTS("mV", 1e-3, 0.0),
    MICROVOLTS("µV", 1e-6, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private ElectricPotentialDifference(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return VOLTS;
    }
  }

  public enum ElectricResistance implements Base {
    MEGAOHMS("MΩ", 1e+6, 0.0),
    KILOOHMS("kΩ", 1e+3, 0.0),
    OHMS("Ω", 1.0, 0.0),
    MILLIOHMS("mΩ", 1e-3, 0.0),
    MICROOHMS("µΩ", 1e-6, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private ElectricResistance(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return OHMS;
    }
  }

  public enum Energy implements Base {
    KILOJOULES("kJ", 1e+3, 0.0),
    JOULES("J", 1.0, 0.0),
    KILOCALORIES("kCal", 4184, 0.0),
    CALORIES("cal", 4.184, 0.0),
    KILOWATT_HOURS("kWh", 3.6e+6, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Energy(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return JOULES;
    }
  }

  public enum Frequency implements Base {
    TERAHERTZ("THz", 1e+12, 0.0),
    GIGAHERTZ("GHz", 1e+9, 0.0),
    MEGAHERTZ("MHz", 1e+6, 0.0),
    KILOHERTZ("kHz", 1e+3, 0.0),
    HERTZ("Hz", 1.0, 0.0),
    MILLIHERTZ("mHz", 1e-3, 0.0),
    MICROHERTZ("µHz", 1e-6, 0.0),
    NANOHERTZ("nHz", 1e-9, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Frequency(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return HERTZ;
    }
  }

  public enum FuelEfficiency implements Base {
    LITERS_PER_100_KILOMETERS("L/100km", 1.0, 0.0),
    MILES_PER_GALLON("mpg", 0.00425142851, 0.0),
    MILES_PER_IMPERIAL_GALLON("mpg", 0.0035400531, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private FuelEfficiency(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return LITERS_PER_100_KILOMETERS;
    }
  }

  public enum Illuminance implements Base {
    LUX("lx", 1.0, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Illuminance(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return LUX;
    }
  }

  public enum Length implements Base {
    MEGAMETERS("Mm", 1e+6, 0.0),
    KILOMETERS("kM", 1e+3, 0.0),
    HECTOMETERS("hm", 1e+2, 0.0),
    DECAMETERS("dam", 1e+1, 0.0),
    METERS("m", 1.0, 0.0),
    DECIMETERS("dm", 1e-1, 0.0),
    CENTIMETERS("cm", 1e-2, 0.0),
    MILLIMETERS("mm", 1e-3, 0.0),
    MICROMETERS("µm", 1e-6, 0.0),
    NANOMETERS("nm", 1e-9, 0.0),
    PICOMETERS("pm", 1e-12, 0.0),
    INCHES("in", 0.0254, 0.0),
    FEET("ft", 0.3048, 0.0),
    YARDS("yd", 0.9144, 0.0),
    MILES("mi", 1609.344, 0.0),
    SCANDINAVIAN_MILES("smi", 1e+4, 0.0),
    LIGHT_YEARS("ly", 9.4607304725808e+15, 0.0),
    NAUTICAL_MILES("NM", 1852, 0.0),
    FATHOMS("ftm", 1.8288, 0.0),
    FURLONGS("fur", 201.168, 0.0),
    ASTRONOMICAL_UNITS("ua", 1.495978707e+11, 0.0),
    PARSECS("pc", 3.085677581e+16, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Length(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return METERS;
    }
  }

  public enum Mass implements Base {
    KILOGRAMS("kg", 1.0, 0.0),
    GRAMS("g", 1e-3, 0.0),
    DECIGRAMS("dg", 1e-4, 0.0),
    CENTIGRAMS("cg", 1e-5, 0.0),
    MILLIGRAMS("mg", 1e-6, 0.0),
    MICROGRAMS("µg", 1e-9, 0.0),
    NANOGRAMS("ng", 1e-12, 0.0),
    PICOGRAMS("pg", 1e-15, 0.0),
    OUNCES("oz", 0.0283495232, 0.0),
    POUNDS("lb", 0.453592371, 0.0),
    STONES("st", 6.35029319, 0.0),
    METRIC_TONS("t", 1000, 0.0),
    SHORT_TONS("ton", 907.18474, 0.0),
    CARATS("ct", 2e-4, 0.0),
    OUNCES_TROY("oz t", 0.0311034768, 0.0),
    SLUGS("slug", 14.5939, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Mass(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return KILOGRAMS;
    }
  }

  public enum Power implements Base {
    TERAWATTS("TW", 1e+12, 0.0),
    GIGAWATTS("GW", 1e+9, 0.0),
    MEGAWATTS("MW", 1e+6, 0.0),
    KILOWATTS("kW", 1e+3, 0.0),
    WATTS("W", 1.0, 0.0),
    MILLIWATTS("mW", 1e-3, 0.0),
    MICROWATTS("µW", 1e-6, 0.0),
    NANOWATTS("nW", 1e-9, 0.0),
    PICOWATTS("pW", 1e-12, 0.0),
    FEMTOWATTS("fW", 1e-15, 0.0),
    HORSEPOWER("hp", 745.699872, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Power(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return WATTS;
    }
  }

  public enum Pressure implements Base {
    NEWTONS_PER_METER_SQUARED("N/m²", 1.0, 0.0),
    GIGAPASCALS("GPa", 1e+9, 0.0),
    MEGAPASCALS("MPa", 1e+6, 0.0),
    KILOPASCALS("kPa", 1e+3, 0.0),
    HECTOPASCALS("hPa", 1e+2, 0.0),
    INCHES_OF_MERCURY("inHg", 3386.39, 0.0),
    BARS("bar", 1e+5, 0.0),
    MILLIBARS("mbar", 1e+2, 0.0),
    MILLIMETERS_OF_MERCURY("mmHg", 133.322441, 0.0),
    POUNDS_PER_SQUARE_INCH("psi", 6894.75729, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Pressure(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return NEWTONS_PER_METER_SQUARED;
    }
  }

  public enum Speed implements Base {
    METERS_PER_SECOND("m/s", 1.0, 0.0),
    KILOMETERS_PER_HOUR("km/h", 5.0 / 18, 0.0),
    MILES_PER_HOUR("mph", 5.0 / 18 * 1.609344, 0.0),
    KNOTS("kn", 5.0 / 18 * 1.852, 0.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Speed(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return METERS_PER_SECOND;
    }
  }

  public enum Temperature implements Base {
    KELVIN("K", 1.0, 0),
    DEGREE_CELSIUS("°C", 1.0, 273.15),
    DEGREE_FAHRENHEIT("°F", 5.0 / 9.0, 273.15 - 32 * 5.0 / 9.0);

    private final String symbol;
    private final double coefficient;
    private final double constant;

    private Temperature(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return KELVIN;
    }
  }

  public enum Volume implements Base {
    MEGALITERS("ML", 1e+6, 0.0),
    KILOLITERS("kL", 1e+3, 0.0),
    LITERS("L", 1.0, 0.0),
    DECILITERS("dL", 1e-1, 0.0),
    CENTILITERS("cL", 1e-2, 0.0),
    MILLILITERS("mL", 1e-3, 0.0),
    CUBIC_KILOMETERS("km³", 1e+12, 0.0),
    CUBIC_METERS("m³", 1e+3, 0.0),
    CUBIC_DECIMETERS("dm³", 1.0, 0.0),
    CUBIC_MILLIMETERS("mm³", 1e-6, 0.0),
    CUBIC_INCHES("in³", 0.016387064, 0.0),
    CUBIC_FEET("ft³", 28.3168466, 0.0),
    CUBIC_YARDS("yd³", 764.554858, 0.0),
    CUBIC_MILES("mi³", 4.16818183e+12, 0.0),
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

    private Volume(String symbol, double coefficient, double constant) {
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
    public Base getBaseUnit() {
      return MEGALITERS;
    }
  }

  private double value;
  private Base unit;

  public Measurement(double value, Base unit) {
    this.value = value;
    this.unit = unit;
  }

  public double getValue() {
    return value;
  }

  public Base getUnit() {
    return unit;
  }

  public Measurement convertTo(Base other) throws IllegalArgumentException {
    if (unit.getBaseUnit().equals(other.getBaseUnit())) {
      return new Measurement(
          ((unit.getCoefficient() * value + unit.getConstant()) - other.getConstant())
              / other.getCoefficient(),
          other);
    } else {
      throw new IllegalArgumentException();
    }
  }
}
