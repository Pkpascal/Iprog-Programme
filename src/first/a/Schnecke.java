package first.a;

import second.MyIO;

/**
 * Dieses Programm lässt den Nutzer seinen Namen eingeben, um diesen wiederholt
 * und gewunden wie eine Schnecke in einer n x n Matrix auszugeben.
 *
 * @version 1.0, 25 Nov 2020
 * @author Marvin Voss, Pascal Brostean, Pacal Knie, Robin Eberle
 */

public class Schnecke {
	public int count = 0;

	public static void main(String[] args) {
		// wird der Name eingelesen
		String name = MyIO.promptAndRead("Bitte geben Sie Ihren Namen ein:");
		String s1 = name;
		char[] zeichen1 = new char[s1.length()];

		for (int i = 0; i < zeichen1.length; i++) {
			zeichen1[i] = s1.charAt(i);
		}

		for (int i = 0; i < zeichen1.length; i++) {
			System.out.print(zeichen1[i]);
		}
		// Formt die Schnecke
		Schnecke schnecke = new Schnecke();
		int  x, y, x_min = 0, x_min2 = 0, y_min = 0, left = 0, down = 0;

		while (true) {
			x = MyIO.readInt(", bitte geben Sie die gewünschte Matrixgröße ein:");

			if (x >= 0 && x <= 49) {
				break;
			} else {
				System.out.println("Error... zahl auserhalb von n");
			}
		}
		y = x;
		int co = 0;
		String[][] Schnecke = new String[y + 1][x + 1];
		for (int i = 0; i <= x; i++) {
			for (int z = 0; z <= x; z++) {
				Schnecke[i][z] = " ";
			}
		}

		for (int i = 0; i <= x; i++) {
			Schnecke = schnecke.right(y, x_min, x, Schnecke, zeichen1);
			y--;
			x_min++;
			Schnecke = schnecke.up(y, y_min, x, Schnecke, zeichen1);
			y_min++;
			x--;

			Schnecke = schnecke.left(down, x_min2, x, Schnecke, zeichen1);
			down += 2;
			y--;
			Schnecke = schnecke.down(y, y_min, left, Schnecke, zeichen1);
			left += 2;
			x--;
			y_min++;
			co++;
			if (co >= 2) {
				x_min++;
			}
			x_min2 += 2;
		}

		int m = Schnecke.length;
		System.out.println();
		for (int i = 0; i < m; i++) {
			System.out.print("  ");
			int n = Schnecke[i].length;
			for (int j = 0; j < n; j++) {
				System.out.print(Schnecke[i][j] + " ");
			}
			System.out.println("  ");
		}
	}

	public String[][] right(int y, int x_min, int x, String Schnecke[][], char zeichen1[]) {
		for (int z = x_min; z <= x; z++) {
			Schnecke[y][z] = String.valueOf(zeichen1[count]);
			count++;
			if (count == zeichen1.length) {
				count = 0;
			}
		}
		return Schnecke;
	}

	public String[][] left(int y, int x_min, int x, String Schnecke[][], char zeichen1[]) {
		for (int z = x; z >= x_min; z--) {

			Schnecke[y][z] = String.valueOf(zeichen1[count]);
			count++;
			if (count == zeichen1.length) {
				count = 0;
			}
		}
		return Schnecke;
	}

	public String[][] up(int y, int y_min, int x, String Schnecke[][], char zeichen1[]) {
		for (int z = y; z >= y_min; z--) {
			Schnecke[z][x] = String.valueOf(zeichen1[count]);
			count++;
			if (count == zeichen1.length) {
				count = 0;
			}
		}
		return Schnecke;
	}

	public String[][] down(int y, int y_min, int x, String Schnecke[][], char zeichen1[]) {
		for (int z = y_min; z <= y; z++) {
			Schnecke[z][x] = String.valueOf(zeichen1[count]);
			count++;
			if (count == zeichen1.length) {
				count = 0;
			}
		}
		return Schnecke;
	}
}