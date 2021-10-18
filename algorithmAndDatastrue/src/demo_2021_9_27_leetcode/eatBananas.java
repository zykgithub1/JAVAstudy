package demo_2021_9_27_leetcode;

public class eatBananas {
	public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed=0;
        for(int i:piles){
            maxSpeed=Math.max(i,maxSpeed);
        }
        int l=1;
        int r=maxSpeed;
        while(l<r){
            int mid=l+(r-l)/2;
            if(check(piles,h,mid)>h){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }

    public int check(int[]piles,int h,int speed){
        int times=0;
        for(int pile:piles){
            times+=(pile-1+speed)/speed;
        }
        return times;
    }
}
