#include <stdio.h>
main()
{
    int a, b, c;
    a = 5 % 3;
    a--;
    b = (a++) + 3;
    printf("%d, %d\n", a, b);
    c = (++a) + 3;
    printf("%d, %d, %d\n", a, b, c);
}