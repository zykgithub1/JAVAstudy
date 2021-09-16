package demo_2021_9_16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class dicTree {
	class Solution {
	    int[][]direction={{0,1},{1,0},{-1,0},{0,-1}};
	    public List<String> findWords(char[][] board, String[] words) {
	        trie head=new trie();
	        for(String str:words){
	            head.insert(str);
	        }
	        Set<String>ans=new HashSet();
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[0].length;j++){
	                dfs(board,i,j,head,ans);
	            }
	        }
	        return new ArrayList(ans);
	    }
	    public void dfs(char[][]board,int i,int j,trie head,Set<String>ans){
	        if(!head.sons.containsKey(board[i][j])){
	            return;
	        }
	        char ch=board[i][j];
	        head=head.sons.get(ch);
	        if(!"".equals(head.word)){
	            ans.add(head.word);
	        }
	        board[i][j]='#';
	        for(int[]dir:direction){
	            int iNext=i+dir[0];
	            int jNext=j+dir[1];
	            if(iNext>=0&&iNext<board.length&&jNext>=0&&jNext<board[0].length){
	                dfs(board,iNext,jNext,head,ans);
	            }
	        }
	        board[i][j]=ch;

	    }
	    class trie{
	        public String word;
	        public HashMap<Character,trie> sons;
	        boolean isWord;
	        public trie(){
	            word="";
	            sons=new HashMap();
	        }

	        public void insert(String word){
	            trie cur=this;
	            for(int i=0;i<word.length();i++){
	                char ch=word.charAt(i);
	                if(!cur.sons.containsKey(ch)){
	                    cur.sons.put(ch,new trie());
	                }
	                cur=cur.sons.get(ch);
	            }
	            cur.word=word;
	        }
	    }
	}
}
