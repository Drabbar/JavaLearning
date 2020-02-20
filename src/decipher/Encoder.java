package decipher;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Encoder {
	public static Window window;
	static String codeA, codeB;
	static String ClassName = "EC";
	static RuntimeCompiler runtimecompiler;
	static boolean stop;

public static void Encode(String Input) {
		
		ClassName = "EC";

		codeB = Input;

		codeA = "\r\n" + 
				"import logic.Inventory.Items;import logic.Player.Blickrichtung; public class EC extends decipher.MethodClass{"
				+ "public static void mainMethod() {"
				+ "new Thread() {"
				+ "	@Override public void run() "
				+ "{" +	codeB  
				+ "	decipher.Window.stop.setBackground(java.awt.Color.white);}"
				+ "	}.start();}}";
		
		runtimecompiler = new RuntimeCompiler();
		
		runtimecompiler.addClass(ClassName, codeA);
		runtimecompiler.compile();

		Class<?> c = runtimecompiler.getCompiledClass(ClassName);
		
		Method methods[] = c.getDeclaredMethods();
        for (Method m : methods)
        {
            if (m.getName().equals("mainMethod") &&
                Modifier.isStatic(m.getModifiers()))
            {
                try {m.invoke(null);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {}
            }
        }	
	}
}