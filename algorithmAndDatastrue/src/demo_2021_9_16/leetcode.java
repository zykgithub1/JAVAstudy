package demo_2021_9_16;

public class leetcode {
	class WordDictionary {
	    trie root;

	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        root=new trie();
	    }
	    
	    public void addWord(String word) {
	        trie cur=root;
	        for(int i=0;i<word.length();i++){
	            int curIndex=word.charAt(i)-'a';
	            if(cur.sons[curIndex]==null){
	                cur.sons[curIndex]=new trie();
	            }
	            cur=cur.sons[curIndex];
	        }
	        cur.isEnd=true;
	    }
	    
	    public boolean search(String word) {
	        trie cur=root;
	        return dfs(root,0,word);
	    }

	    public boolean dfs(trie head,int index,String word){
	        if(head==null){
	            return false;
	        }
	        if(index==word.length()){
	            return head.isEnd;
	        }
	        
	        char ch=word.charAt(index);
	        if(ch=='.'){
	            for(int i=0;i<26;i++){
	                if(head.sons[i]!=null){
	                    if(dfs(head.sons[i],index+1,word))return true;
	                }
	            }
	        }else{
	            int t=ch-'a';
	            return head.sons[t]!=null&&dfs(head.sons[t],index+1,word);
	        }
	        return false;
	    }

	   class trie{
	        trie[]sons;
	        boolean isEnd;
	        public trie(){
	            sons=new trie[26];
	        }
	    }
	}

}
