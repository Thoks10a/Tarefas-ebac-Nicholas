package tarefa_wrapper;

public class tarefa {
	
	public static Integer toInteger(int value) {
        return Integer.valueOf(value);
    }

    public static Double toDouble(double value) {
        return Double.valueOf(value);
    }

    public static Float toFloat(float value) {
        return Float.valueOf(value);
    }

    public static Long toLong(long value) {
        return Long.valueOf(value);
    }

    public static Short toShort(short value) {
        return Short.valueOf(value);
    }

    public static Byte toByte(byte value) {
        return Byte.valueOf(value);
    }

    public static Boolean toBoolean(boolean value) {
        return Boolean.valueOf(value);
    }

    public static Character toCharacter(char value) {
        return Character.valueOf(value);
    }

	public static void main(String[] args) {
		
        int intValue = 10;
        Integer intWrapper = toInteger(intValue);
        System.out.println("Tipo Integer: " + intWrapper);

        double doubleValue = 5.5;
        Double doubleWrapper = toDouble(doubleValue);
        System.out.println("Tipo Double: " + doubleWrapper);

        boolean booleanValue = true;
        Boolean booleanWrapper = toBoolean(booleanValue);
        System.out.println("Tipo Boolean: " + booleanWrapper);

        char charValue = 'a';
        Character charWrapper = toCharacter(charValue);
        System.out.println("Tipo Char: " + charWrapper);
	}

}

