package org.paradox.util;

public class Converter {
	@SuppressWarnings("unchecked")
	public static <T> T convert(Object from, Class<T> to) {
		if (from == null) return (T)null;
		if (from.getClass() == to) return (T)from;
		if (to == String.class) {
			return (T)from.toString();
		}
		if (from.getClass() == String.class) {
			if (to == int.class || to == Integer.class) return (T)new Integer(Integer.parseInt(from.toString()));
			if (to == long.class || to == Long.class) return (T)new Long(Long.parseLong(from.toString()));
			if (to == double.class || to == Double.class) return (T)new Double(Double.parseDouble(from.toString()));
		}
		if (to == Object.class) {
			return (T)from;
		}
		if (Enum.class.isAssignableFrom(to)) {
			return (T)from.toString();
		}
		throw new RuntimeException("No conversion available of " + from + " of " + from.getClass() + " to " + to);
	}

}
