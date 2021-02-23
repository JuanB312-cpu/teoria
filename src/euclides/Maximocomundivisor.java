
package euclides;

import java.util.ArrayList;

public class Maximocomundivisor {

	static int numero1;
	static int numero2;
	static int numero3 = -1;
	static int numero4 = -1;
	static int temp;
	static int mcd1 = 1;
	static int temp1 = 1;
	static int temp2 = 1;
	static int c1 = 1;
	static int c2 = 0;
	static int d1 = 0;
	static int d2 = 1;
	static int q;
	static int r1 = 1;
	static int r2 = 1;
	static int lineal1 = 1;
	static int lineal2 = 1;
	static int indicador = 2;
	static int residuo2 = 0;
	static int residuo1 = 0;
	static int contador = 1;
	static String texto = "\n\t";
	static int entrada;

	static ArrayList<Integer> cocientes = new ArrayList();
	static ArrayList<Integer> resultados = new ArrayList();
	static ArrayList<Integer> lineales = new ArrayList();
	static ArrayList<Integer> numeros = new ArrayList();

	public static void mcd(int contador) {

		while (numero2 != 0) {

			texto = texto + "\n\t"
					+ ("\n\t" + numero1 + " = " + numero1 / numero2 + " x " + numero2 + " + " + numero1 % numero2);

			if ((numero1 % numero2) != 0) {

				cocientes.add(numero2);
				resultados.add(numero1);
				temp2 = numero1;
				temp1 = numero2;
				residuo1 = numero1 / numero2;
			}

			q = numero1 / numero2;

			if (numero1 % numero2 == 0) {
				mcd1 = numero1 / (numero1 / numero2);

				lineal1 = d2;
				lineal2 = c2;

			}

			if (numero2 != 0) {
				temp = numero1 % numero2;
				numero1 = numero2;
				numero2 = temp;
			}

			r1 = d1 - q * d2;
			d1 = d2;
			d2 = r1;

			r2 = c1 - q * c2;
			c1 = c2;
			c2 = r2;

		}

	}

	public static void coeficientes(int posicion, int contador, ArrayList numero, int mcd) {

		numeros = numero;
		entrada = mcd;

		if (contador == 0) {

			numero1 = numeros.get(0);
			numero2 = numeros.get(1);
		}

		if (contador == 1) {

			if (numeros.get(posicion) > entrada || numeros.get(posicion) == entrada) {
				numero1 = numeros.get(posicion);
				numero2 = entrada;
			}

			if (numeros.get(posicion) < entrada) {
				numero2 = numeros.get(posicion);
				numero1 = entrada;
			}
		}

		d1 = 1;
		d2 = 0;
		c1 = 0;
		c2 = 1;

		while (numero2 != 0) {
			int q = numero1 / numero2;
			if (numero1 % numero2 == 0) {
				mcd1 = numero1 / (numero1 / numero2);
				if (contador == 0) {

					lineales.add(d2);
					lineales.add(c2);

				}
				if (contador == 1) {

					lineales.add(d2);
					for (int j = 0; j < (lineales.size() - 1); j++) {

						lineales.set(j, (lineales.get(j) * c2));
					}

				}

			}
			int temp2 = numero1 % numero2;
			numero1 = numero2;
			numero2 = temp2;
			r1 = d1 - q * d2;
			d1 = d2;
			d2 = r1;
			r2 = c1 - q * c2;
			c1 = c2;
			c2 = r2;
		}
		
		limpiar();

	}

	public static void combinacion() {

		if (resultados.size() != 1) {

			while ((resultados.size() - indicador) > -1) {

				if ((resultados.size() - indicador) > -1) {

					numero3 = resultados.get(resultados.size() - indicador);
					numero4 = cocientes.get(cocientes.size() - indicador);
				}

				texto = texto + "\n\t"
						+ ("\n\t" + mcd1 + " = " + residuo2 + " x " + (numero2) + " - " + residuo1 + " x " + numero1);

				texto = texto + "\n\t" + ("\n\t" + mcd1 + " = " + residuo2 + " x " + (numero2) + " - " + residuo1 + " x"
						+ "(" + numero3 + " - " + numero3 / numero4 + " x " + numero4 + ")");

				residuo2 = (residuo1 * (numero3 / numero4)) + residuo2;
				indicador = indicador + 1;

				texto = texto + "\n\t"
						+ ("\n\t" + mcd1 + " = " + residuo2 + " x " + (numero2) + " - " + residuo1 + " x " + numero3);

				if ((resultados.size() - indicador) > -1) {

					numero3 = resultados.get(resultados.size() - indicador);
					numero4 = cocientes.get(cocientes.size() - indicador);
				}
				texto = texto + "\n\t" + ("\n\t" + mcd1 + " = " + residuo2 + " x" + "(" + numero3 + " - "
						+ numero3 / numero4 + " x " + numero4 + ")" + " - " + residuo1 + " x " + numero4);
				indicador = indicador + 1;

				numero2 = numero3;
				numero1 = numero4;

				residuo1 = (residuo2 * (numero3 / numero4)) + residuo1;

			}
		}

	}

	public static void limpiar() {

		numero3 = -1;
		numero4 = -1;
		temp = 0;
		mcd1 = 1;
		temp1 = 1;
		temp2 = 1;
		c1 = 1;
		c2 = 0;
		d1 = 0;
		d2 = 1;
		q = 0;
		r1 = 1;
		r2 = 1;
		lineal1 = 1;
		lineal2 = 1;
		indicador = 2;
		residuo2 = 0;
		residuo1 = 0;
		contador = 1;
		texto = "";
		resultados.clear();
		cocientes.clear();
	}
	
	public static void limpiarfinal() {
		
		lineales.clear();
	}

	public static Guardar imprimir(int posicion, int contador, ArrayList numero, int mcd) {

		int limite = 1;

		limite = posicion + 1;

		numeros = numero;
		entrada = mcd;

		if (contador == 0) {

			numero1 = numeros.get(0);
			numero2 = numeros.get(1);
		}

		if (contador == 1) {

			if (numeros.get(posicion) > entrada || numeros.get(posicion) == entrada) {
				numero1 = numeros.get(posicion);
				numero2 = entrada;
			}

			if (numeros.get(posicion) < entrada) {
				numero2 = numeros.get(posicion);
				numero1 = entrada;
			}
		}

		

		if (numero1 % numero2 != 0) {
			
			mcd(contador);

			residuo2 = 1;
			numero1 = temp1;
			numero2 = temp2;

			texto = texto + "\n\t" + ("\n\tDespejamos el M.C.D.:");

			texto = texto + "\n\t"
					+ ("\n\t" + mcd1 + " = " + residuo1 + " x " + (numero2) + " - " + residuo2 + " x " + numero1);
			
			if (resultados.size()!=1) {

			texto = texto + "\n\t" + ("\n\tEmpezamos a devolvernos");

			combinacion();

			texto = texto + "\n\t" + ("\n\tFactorizamos y la combinación lineal obtenida es:");}

			texto = texto + "\n\t"
					+ ("\n\t" + mcd1 + " = " + numero1 + "(" + lineal1 + ") " + " + " + numero2 + "(" + lineal2 + ") ");

			if (contador == 1) {

				texto = texto + "\n\t"
						+ ("\n\tMultiplicamos " + lineal1 + " por la combinación lineal anterior y obtenemos:");

				texto = texto + "\n\t" + ("\n\t" + mcd1 + " = ");

				for (int j = 0; j < limite - 1; j++) {

					texto = texto + (numeros.get(j) + "(" + lineales.get(j) + ") " + "+ ");
				}

				texto = texto + (numero2 + "(" + lineal2 + ")");
			}

			texto = texto + "\n\t" + ("\n\tEl M.C.D de (");

			for (int j = 0; j < limite - 1; j++) {

				texto = texto + (numeros.get(j) + ",");

			}

			texto = texto + numeros.get(limite - 1) + ") es: " + mcd1;

		}

		if ((numeros.get(posicion) % entrada == 0) && contador == 1) {

			texto = texto + "\n\t" + ("\n\tCon el número " + numeros.get(posicion)
					+ " se produce residuo 0 al ser divido por el mcd obtenido: " + entrada);
			texto = texto + "\n\t"
					+ ("\n\tPor lo tanto este no entra en la combinación lineal, ya que su coeficiente es 0");

			texto = texto + "\n\t";

			texto = texto + "\n\t" + ("\n\tEl M.C.D de (");

			for (int j = 0; j < limite - 1; j++) {

				texto = texto + (numeros.get(j) + ",");

			}

			texto = texto + numeros.get(limite - 1) + ") es: " + entrada;

			mcd1 = entrada;

			lineales.set(posicion, 0);

		}

		if ((numeros.get(0) % numeros.get(1) == 0) && contador == 0) {

			texto = texto + "\n\t"
					+ ("\n\tComo se produjo residuo cero uno de los dos números se cancelara, en la combinación lineal");

			mcd(contador);

			texto = texto + "\n\t" + ("\n\tDando como resultado: ");

			texto = texto + "\n\t" + ("\n\t" + mcd1 + " = " + numero1 + "(" + lineal1 + ") " + " + " + numeros.get(0)
					+ "(" + lineal2 + ") ");

		}

		Guardar datos = new Guardar(mcd1, texto);
		limpiar();

		return datos;

	}

}
