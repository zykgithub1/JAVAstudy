package PTA2021_5_30;

public class test {

}
class Solution {
    public boolean isNumber(String s) {
        //�ȴ������������������֪���ô���
        //if(s==null||s.length()==0) return false;
        //���ַ�����e��EΪ���޷ֳ�������
        int index = s.indexOf('e');
        if (index == -1) index = s.indexOf('E');
        //�ж�e��E֮���Ƿ�Ϊ����
        if (index != -1) {
            if (!isInteger(s.substring(index + 1)))
                return false;
            else {//���ж�e��E֮ǰ�Ĳ���
                s = s.substring(0, index);
            }
        }
        //�ж�e��E֮ǰ�Ĳ��֣�index=-1ʱ����Ϊe��E����ĩβ�����Ǻϲ�����
        int dot = s.indexOf('.');
        if (dot == -1) {//û��С����ʱֱ���ж��Ƿ�Ϊ����
            if (!isInteger(s))
                return false;
            else
                return true;
        } else {//��С����ʱ�ֱ��ж�ǰ��������
            String front = s.substring(0, dot);
            String tail = s.substring(dot + 1);
            //��������ӦΪ��������Ϊ�ջ���ֻ�з���
            //��������Ϊ����ʱ
            if (isInteger(front)) {
                //С�����ֿ���Ϊ��
                if (tail.length() == 0)
                    return true;
                //С�����ֿ���Ϊ�����������ܰ�������
                if (isInteger(tail) && Character.isDigit(tail.charAt(0)))
                    return true;
            }
            //��������Ϊ�ջ�ֻ��+��-ʱ��С�����ֲ���Ϊ��
            if (front.length() == 0 || (front.length() == 1 && (front.charAt(0) == '+' || front.charAt(0) == '-'))) {
                //С�����ֿ���Ϊ�����������ܰ�������
                if (isInteger(tail) && Character.isDigit(tail.charAt(0)))
                    return true;
            }
            return false;
        }
    }

    //�������԰��������ţ����ಿ��ӦΪ����
    public boolean isInteger(String s) {
        //ȷ���ǿ�
        if (s == null || s.length() == 0) return false;
        //���жϿ�ͷ�ǲ���������
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            //����ֻ��������
            if (s.length() == 1)
                return false;
            //ȡ�������ⲿ��
            s = s.substring(1);
        }
        //����λ���ⲿ��ӦΪ����
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}
