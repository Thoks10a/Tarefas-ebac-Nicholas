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
		System.out.println("---------------------------------------------------");
        int intValue = 10;
        System.out.println("Tipo int: " + intValue);
        Integer intWrapper = toInteger(intValue);
        System.out.println("Tipo Integer Wrapper: " + intWrapper);
        System.out.println("---------------------------------------------------");
        double doubleValue = 5.5;
        System.out.println("Tipo double: " + doubleValue);
        Double doubleWrapper = toDouble(doubleValue);
        System.out.println("Tipo Double Wrapper: " + doubleWrapper);
        System.out.println("---------------------------------------------------");
        boolean booleanValue = true;
        System.out.println("Tipo boolean: " + booleanValue);
        Boolean booleanWrapper = toBoolean(booleanValue);
        System.out.println("Tipo Boolean Wrapper: " + booleanWrapper);
        System.out.println("---------------------------------------------------");
        char charValue = 'a';
        System.out.println("Tipo char: " + charValue);
        Character charWrapper = toCharacter(charValue);
        System.out.println("Tipo Char Wrapper: " + charWrapper);
        System.out.println("---------------------------------------------------");
	}

}

