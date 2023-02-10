#include <stdio.h>
#include <stdbool.h>
#include <string.h>

/*
 * The isnumber() function examines the character given as its first
 * argument and returns true if and only if the character represents
 * an number.  This helper function should be relatively short.
 *
 * Returns true if the given character represents an number, false
 * otherwise.
 */
bool isnumber(char c);
int decode(char *str);



/*
 * The decode() function takes a run-length encoded string as its
 * argument, parses every integer n preceding every character in
 * the string, and prints each character n times.  For example, if
 * the string passed to decode() is "1a3b", decode() will print
 * "abbb".  It returns an integer that represents the summed value
 * of the amount of characters printed; in this example, decode()
 * would return the integer 4.
 *
 * This function must also handle malformed run-length encoded strings.
 * A malformed string is any string which does not adhere to the RLE
 * implementation described in the handout. If a malformed string is
 * encountered, it should cease printing the decoded string, print an
 * error message, and return -1.
 *
 * Returns the integer value of the total amount of characters printed,
 * or -1 if the run-length encoded string is malformed.
 */



/*
 * The main function is where C programs begin.
 *
 * This function parses its arguments and returns the value they
 * represent.  In this assignment, the only valid argument is a
 * run-length encoded string.  Any extra arguments in excess of
 * this single valid argument make the invocation of your program
 * invalid.
 *
 * Remember that the argument in argv[0] is the name of the program, so
 * a program passed exactly one argument on the command line will
 * receive _two_ arguments: its name in argv[0] and the provided
 * argument in argv[1].
 *
 * Arguments:
 * argc - The number of arguments received
 * argv - The arguments received as an array of C strings
 *
 * Returns 0 if the argument is well-formed and the string could
 * be decoded, non-zero otherwise.
 */
int main(int argc, char *argv[]) {
    /* Your main program logic should go here, with helper logic in the
     * functions isnumber() and decode(), which you can place below
     * the closing brace of main() */

    if(argc != 2) {
        printf("error: invalid string");
        return -1;
    }

    if (decode(argv[1]) == -1) {
        return -1;
    }
    else {
        return 0;
    }
}

/* You should implement isnumber() and decode() here */


bool isnumber(char c) {
    if (c >= '0' && c <= '9') 
        return true;
    return false;
}



int decode(char *str) {
    int charSum, len;
    int i, j, k;
    charSum = i = j = k = 0;
    len = strlen(str);
    if(len < 2) {
        printf("Error: invalid string.\n");
        return -1;
    }
    if(!isnumber(str[0])) { //starting = char
        printf("Error: invalid string\n");
        return -1;
    }
    while(i < len) {
        if (i > 0) {
            if (!isnumber(str[i]) && !isnumber(str[i-1])) { // char char
                printf("Error: invalid string\n");
                return -1;
            }
        }
        if(isnumber(str[i]) && len == i + 1) { //last char = number
            printf("error: invalid string\n");
            return -1;
        }

        int currTimes, newIndex;
        currTimes = 0;
        newIndex = i;
        char currChar;

        for(j = i; isnumber(str[j]); ++j) { 
            ++newIndex;
            currTimes = 10 * currTimes + (str[j] - '0');
        }
        if(currTimes == 0) { //0a
            printf("error");
            return -1;
        }
        if(newIndex == len) {
            printf("error");
            return -1;
        }
        currChar = str[newIndex];
        i = newIndex + 1;
        

        for(k = 0; k < currTimes; ++k) { 
            putchar(currChar);
        }
        charSum = charSum + currTimes;
    }
    printf("\n");
    return charSum;
}
