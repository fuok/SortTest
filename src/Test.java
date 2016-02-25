import java.util.Arrays;

public class Test {

	/**
	 * 四种常用排序
	 */
	public static void main(String[] args) {

		int[] aa = new int[] { 65, 21, 1, 3, 101, 5, 8, 6, 12, 34, 100 };

		charu(aa);
		// maopao(aa);
		// xuanze(aa);
		shell(aa);
		System.out.println(Arrays.toString(aa));

	}

	// 插入法,原理是每次把一个新数据插入已经排好顺序的有序数据中,内层循环遍历的对象是排好序的数据
	public static void charu(int[] data) {
		int temp;
		for (int i = 1; i < data.length; i++) {
			for (int j = i; (j > 0) && (data[j] > data[j - 1]); j--) {//查找方向是朝着已经排序过的一端，也就是每次把一个新数据插入进来。所以内外循环方向是相反的
				temp = data[j];
				data[j] = data[j - 1];//对比相邻两数，把数据逐次推向应在的位置
				data[j - 1] = temp;
			}
		}
	}

	// 冒泡法,区别于插入法,冒泡法的内层循环遍历的对象是未排好序的数据,已经排序的数据保持不动,所以内外循环方向是一致的.
	public static void maopao(int[] data) {
		int temp;
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] < data[j]) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	// 选择法,TODO
	public static void xuanze(int[] data) {
		int temp;
		for (int i = 0; i < data.length; i++) {
			int lowIndex = i;
			for (int j = data.length - 1; j > i; j--) {
				if (data[j] > data[lowIndex]) {
					lowIndex = j;
				}
			}
			temp = data[i];
			data[i] = data[lowIndex];
			data[lowIndex] = temp;
		}
	}

	// shell法
	public static void shell(int[] data) {
		for (int i = data.length / 2; i > 2; i /= 2) {
			for (int j = 0; j < i; j++) {
				insertSort(data, j, i);
			}
		}
		insertSort(data, 0, 1);
	}

	private static void insertSort(int[] data, int start, int inc) {
		int temp;
		for (int i = start + inc; i < data.length; i += inc) {
			for (int j = i; (j >= inc) && (data[j] < data[j - inc]); j -= inc) {
				temp = data[j];
				data[j] = data[j - inc];
				data[j - inc] = temp;
			}
		}
	}
}
