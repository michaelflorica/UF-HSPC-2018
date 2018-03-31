import java.util.Scanner;
import java.util.TreeSet;

public class KeypadMM {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t -- != 0) {
			int n = in.nextInt();
			String[] codes = new String[n];
			int shortest = 0;
			for (int i = 0; i < n; ++i) {
				codes[i] = in.next();
				if (codes[i].length() < codes[shortest].length()) {
					shortest = i;
				}
			}
			int to = codes[shortest].length() - 3;
			TreeSet<String> answer = new TreeSet<String>();
			for (int i = 0; i < to; ++i) {
				boolean notFound = false;
				String sub = codes[shortest].substring(i, i + 4);
				for (int j = 0; j < n; ++j) {
					if (j == shortest)
						continue;
					if (! codes[j].contains(sub)) {
						notFound = true;
						break;
					}
				}
				if (! notFound) {
					answer.add(sub);
				}
			}
			for (String item : answer) {
				System.out.println(item);
			}
			if (t != 0) {
				System.out.println();
			}
		}
		in.close();
	}
}
