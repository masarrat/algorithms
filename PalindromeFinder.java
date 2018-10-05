package algo;

public class PalindromeFinder {

	public static void main(String[] args){
		String name="mom";
		int length = name.length();
		boolean palindrome=true;
		for(int i=0; i<length;i++){
			if(!(name.charAt(i)==name.charAt(length-1-i))){
				palindrome=false;
				break;
			}
		}
		System.out.println(name + " is "+(palindrome?"palindrome.":"not palindrome."));
	}
}
