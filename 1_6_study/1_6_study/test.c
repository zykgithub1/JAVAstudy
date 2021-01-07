#include <stdio.h>


//int main()
//{
//	int arr[10] = { 0 };
//	int i = 0;
//	for (int i = 0; i < 10; i++){
//		arr[i] = i;
//	}
//	return 0; 
//}
//int main()
//{
//	int i = 0; 
//	int sum = 0;
//	int n = 0;
//	int ret = 1;
//	scanf_s("%d", &n);
//	for (i = 1; i <= n; i++)
//	{
//		int j = 0;
//		ret = 1;
//		for (j = 1; j <= i; j++)
//		{
//			ret *= j;
//		}
//		sum += ret;
//	}
//	printf("%d\n", sum);
//	return 0;
//}
//void my_strcopy(char* dest, char* src)
//{
//	while (*src != '\0')
//	{
//		*dest = *src;
//		src++;
//		dest++;
//	}
//	*dest = *src;
//}
//int main()
//{
//	char arr1[] = "########";
//	char arr2[]= "zyk";
//	my_strcopy(arr1, arr2);
//	printf("%s\n", arr1);
//	return 0;
//}
int my_len(const char *str){
	int count = 0;
	while (*str != '\0'){
		count++;
		str++;
	}
	return count;
}
int main(){
	char arr1[] = "sjdjsajd";
	printf("%d", my_len(arr1));
	return 0;
}
