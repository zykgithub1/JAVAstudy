package demo_2021_8_26_;

public class uniqueAndSmallestDIcorder {
	public static void main(String[] args) {
		System.out.println(remove("tdsabdffjdskajkfhsafjkjasd;l;lkklshlasddasasdt"));
	}
	public static String remove(String str) {
		if(str==null||str.length()<2) {
			return str;
		}
		int[]map=new int[256];
		for(int i=0;i<str.length();i++) {
			map[str.charAt(i)]++;
		}
		int minACSIndex=0;
		for(int i=0;i<str.length();i++) {
			if(--map[str.charAt(i)]==0) {
				break;
			}else {
				minACSIndex=str.charAt(minACSIndex)>str.charAt(i)?i:minACSIndex;
			}
		}
		return String.valueOf(str.charAt(minACSIndex))+
				remove(
						 str.substring(minACSIndex+1))
		.replaceAll(String.valueOf(str.charAt(minACSIndex)),"");
	}

}
