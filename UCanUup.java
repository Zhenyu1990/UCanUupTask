import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UCanUup {

	public static void main(String[] args) throws IOException {
		// 子字符串个数
		int count = 0;
		String subStr = "UCanUup";
		String strUrl = "http://106.75.28.160/UCloud.txt";
		// 读取文件
		URL url = new URL(strUrl); 
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while((line = br.readLine()) != null) {
			// 统计每一行中子字符串个数并累加
			count = count + stringCounter(line, subStr);
		}
		
		// 关闭资源
		br.close();
		
		// 输出统计结果
		System.out.println("共有 " + count + " 个 \"UCanUup\"");
	}

	/**
	 * 统计字符串中子字符串的个数
	 * @param s1 原始的字符串
	 * @param s2 要统计的子字符串
	 * @return 返回int类型的s1中s2的个数
	 */
	public static int stringCounter(String s1, String s2) {
		int i = s1.length() - s1.replace(s2, "").length();
		return i / s2.length();
	}
	
}