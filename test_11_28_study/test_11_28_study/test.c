
#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>



//课堂总结：

/*^异或
   ~按位取反
   a&&b&&c&&d  如果a为假后面不进行
   a||b||c||d  如果a为真后面不进行
   &按位与
   |按位或
   整形提升  char a =1;char b=127;char c =a+b; c=-126; char c (!c)还是等于1，不会整型提升但是+-c会。
   指针类型决定了指针进行解引用操作时能访问空间的大小
   int*p 4个字节
   char*p 1个字节
   double*p 8个字节
   野指针1,指针越界2,指针未初始化3,内存释放，函数返回地址（临时变量）。
   指针运算：1，指针+1=arr下一位；2，指针-指针=中间的元素个数；
   &arr ;int* p =arr&arr[0];
*/

//int main()
//{
//	int a = 3;
//	int b = 5;
//	printf("a=%d b=%d\n", a, b);
//	a = a^b;
//	b = a^b;
//	a = a^b;
//	/*a=011                     110           110
//	  b=101 a^b=110=6=a;        101           011
//                                011=3=b       101=5
//	*/
//	printf("a=%d b=%d\n", a, b);
//	return 0;
//}
//int oj(int num)
//{
//	int ret = 0;
//	int count = 0;
//	if (num < 0)
//		num *= -1;
//	if (num > 0)
//	{
//		while (num)
//		{
//			ret = num % 2;
//			{
//				if (ret = 1)
//				{
//					count++;
//				}
//			}
//			num = num / 2;
//		}
//		
//	}
//	return count;
//}//1111
//int main()
//{
//	int num = 0;
//	int count = 0;
//	printf("请输入num：》");
//	scanf("%d", &num);
//	int i;
//	for (i = 1; i <= 32; i++)
//	{
//		if (1 == ((num >> i) & 1))
//			count++;
//	}
//		
//	printf("num中有%d个1",count);
//
//	return 0;
//}
//int main()
//{
//	/*int a = 0;
//	char b = 'c';
//	int arr[10] = { 0 };
//	printf("%d\n", sizeof(a));
//	printf("%d\n", sizeof(int));
//
//	printf("%d\n", sizeof(b));
//
//	printf("%d\n", sizeof(char));
//
//	printf("%d\n", sizeof(arr));*/
//	short s = 0;
//	int a = 10;
//	printf("%d\n", sizeof(s));
//	printf("%d\n", sizeof(s=a+5));
//	printf("%d\n", s);
//	printf("%d\n", s+a);
//
//	return 0;
//}
//int main()
//{
//	int i = 0, a = 1, b = 2, c = 3, d = 4;
//	i = a++||++b||d++;
//	printf("a%d b%d c%d d%d", a, b, c, d);
//	return 0
//struct st
//{
//	char name[10];
//	int age;
//	char id[20];
//};
//int main()
//{
//	struct st s1 = { "zyk", 24, "2015441284" };
//	printf("%s\n", s1.name);
//	printf("%d\n", s1.age);
//	printf("%s\n", s1.id);
//	return 0;
//}
//int main()
//{
//	char a = 3; char b = 127; char c = a + b;
//	int* p = &c;
//	printf("%d\n", c);
//	printf("%u\n", &c);
//	printf("%d\n", &c);
//	printf("%d\n", p);
//	printf("%d\n", c);
//	return 0;
//}
//int mian()
//{
//	int a = 0x11223344;
//	int* pa = &a;
//	*pa = 0;
//	return 0;
//}
//int main()
//{
//	int a = 10;
//	int b = 20;
//	int c = a + b;
//	int* pa = &c;
//	printf("%p", pa);
//}
//int main()
//{
//	int arr[10] = { 0 };
//	printf("%p\n", &arr);
//	printf("%p\n", &arr[0]);
//	printf("%p\n", arr);
//	printf("%d\n", arr);
//	return 0;
//}
//int main()
//{
//	int arr[10] = { 0 };
//	int* p = &arr;
//	int i = 0;
//	for (i = 0; i < 10; i++)
//	{
//		*(p + i) = i;
//		printf("%d ===================%d\n", *(p + i),arr[i]);
//	}
//	//printf("%d ", *(p + i));
//	return 0;
//}
//int main()
//{
//	int a = 10;
//	int * pa = &a;
//	int* * ppa = &pa;
//	int** * pppa = &ppa;
//	printf("%d\n", *pa);
//	printf("%d\n", *pa);
//	printf("%p\n", pa);
//	printf("%d\n", **ppa);
//	printf("%p\n", pa);
//	printf("%p\n", ppa);
//	printf("%p\n", pppa);
//	return 0;
//}
//void Init(int arr[], int sz,int set);
//void Print(int arr);
//void Reverse(int arr);

//void Init(int arr[], int sz,int set)
//{
//	int i = 0;
//	for (i = 0; i < sz; i++)
//	{
//		arr[i] = set;
//	}
//}
//void Print(int arr[],int sz)
//{
//	int i = 0;
//	for (i = 0; i < sz; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//}
//Reverse(int arr[],int sz)
//{
//	int left = 0;
//	int right = sz - 1;
//	while (left < right)
//	{
//			int tmp = 0;
//			tmp = arr[left];
//			arr[left] = arr[right];
//			arr[right] = tmp;
//		left++;
//		right--;
//	}
//}
//int main()
//{
//	int set=0;
//	int arr[10] = {1,2,3,4,5,6,7,8,9,10};
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	//Init(arr,sz,set);
//	Print(arr,sz);
//	Reverse(arr,sz);
//	printf("\n");
//	Print(arr, sz);
//	return 0;
//}
//int main()
//{
//	int arr1[] = { 1, 3,5,7,9};
//	int arr2[] = { 2, 4, 6, 8, 10 };
//	int left = 0;
//	int tmp = 0;
//	while (left < 5)
//	{
//		tmp = arr1[left];
//		arr1[left] = arr2[left];
//		arr2[left] = tmp;
//		//printf("%s ", arr1);
//		//printf("% " , arr2);
//		left++;
//	}
//	
//
//}
int main()
{
	int N = 0;

}