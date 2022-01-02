package com.harium.suneidesis.concept;

public class Measurement extends Concept {

    private static final String ATTRIBUTE_ACCURACY = "accuracy";
    private static final String ATTRIBUTE_UNIT = "unit";
    private static final String ATTRIBUTE_VALUE = "value";

    public static final String VALUE_UNKNOWN = "";
    public static final Unit DEFAULT_UNIT = new Unit("unit", "u");
    public static final Measurement ZERO = new Measurement("0", DEFAULT_UNIT);

    public Measurement(Concept unit) {
        super(ConceptType.MEASUREMENT);
        unit(unit);
    }

    /**
     * This constructor uses value instead of name in purpose
     * @param value - the value in unknown units
     */
    public Measurement(String value) {
        super(ConceptType.MEASUREMENT);
        value(value);
    }

    public Measurement(String value, Concept unit) {
        super(ConceptType.MEASUREMENT);
        value(value);
        unit(unit);
    }

    public Measurement(String value, String unit) {
        super(ConceptType.MEASUREMENT);
        value(value);
        unit(unit);
    }

    public Measurement(String value, String unit, String name) {
        super(name, ConceptType.MEASUREMENT);
        value(value);
        unit(unit);
    }

    public Concept getValueConcept() {
        return getAttributes().get(ATTRIBUTE_VALUE);
    }

    public String getValue() {
        Concept value = getAttributes().get(ATTRIBUTE_VALUE);
        if (value.isUnknown()) {
            return VALUE_UNKNOWN;
        }
        return value.getValue();
    }

    public Concept getUnitConcept() {
        return getAttributes().get(ATTRIBUTE_UNIT);
    }

    public String getUnit() {
        return getUnitConcept().getName();
    }

    public Measurement value(String value) {
        getAttributes().save(ATTRIBUTE_VALUE, new Primitive(value));
        return this;
    }

    public Measurement unit(Concept unit) {
        getAttributes().save(ATTRIBUTE_UNIT, unit);
        return this;
    }

    public Measurement unit(String unit) {
        return unit(new Unit(unit));
    }

    public Measurement accuracy(String accuracy) {
        getAttributes().save(ATTRIBUTE_ACCURACY, new Concept(accuracy));
        return this;
    }

    public boolean equals(Measurement q) {
        if (q == null) {
            return false;
        }
        boolean sameValue = q.getValue().equals(getValue());
        boolean sameUnit = q.getUnit().equals(getUnit());

        return sameValue && sameUnit;
    }
}
