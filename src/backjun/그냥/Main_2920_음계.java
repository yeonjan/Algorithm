package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2920_음계 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int first=Integer.parseInt(input[0]);
		String ans;

		if(first == 1){
			ans="ascending";
			for (int i=1;i<8;i++){
				if (Integer.parseInt(input[i])!=i+1){
					ans="mixed";
					break;
				}
			}
		}else if(first == 8){
			ans="descending";
			for (int i=1;i<8;i++){
				if (Integer.parseInt(input[i])!=8-i){
					ans="mixed";
					break;
				}
			}
		}else ans="mixed";

		System.out.println(ans);

	}

}
