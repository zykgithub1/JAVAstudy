package cn.zyk.annotation;
@SuppressWarnings("all")
public class AnnoDemo2 {
    @Override
    public String toString() {
        return super.toString();
    }
    @Deprecated
//    @SuppressWarnings("all")
    public void show(){

    }
//    @SuppressWarnings("all")
    public void show1(){

    }
//    @SuppressWarnings("all")
    public void demo(){
        show();
    }
}
