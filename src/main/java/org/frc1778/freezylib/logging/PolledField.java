package org.frc1778.freezylib.logging;

import java.util.function.Supplier;
import org.frc1778.freezylib.util.Measurement;

public class PolledField extends Field {

  private Supplier<String> supplier;
  private String value;

  public <T> PolledField(String name, String unit, Supplier<T> supplier) {
    setName(name);
    setUnit(unit);
    setType(supplier.get().getClass());
    this.supplier = () -> String.valueOf(supplier.get());
  }

  public <T> PolledField(String name, Measurement.Base unit, Supplier<T> supplier) {
    this(name, unit.getSymbol(), supplier);
  }

  public void pollSupplier() {
    value = supplier.get();
  }

  @Override
  public String getValue() {
    return value;
  }
}
