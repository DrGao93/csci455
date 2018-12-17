/*

  CSCI 455 C String lab

  See lab description for what it should do.  
  C++ tools allowed: cout, call by reference

*/


// for C input functions (e.g., fgets used here)
#include <cstdio>

// C string functions
#include <cstring>

#include <iostream>


using namespace std;

const char NAME_DELIM = ':';
const int AREA_CODE_SIZE = 3;
const int PREFIX_SIZE = 3;
const int LINE_NO_SIZE = 4;
const int MAX_LINE_SIZE = 1024;  // including newline and terminating null char

void readField(char* buffer, int startLoc,int len, char* field){
   int i;
   for(i = startLoc;i< startLoc + len;i++){
      field[i-startLoc] = buffer[i];
   }
   field[i-startLoc] = '\0';
}

int main() {

   char buffer[MAX_LINE_SIZE];


   // fgets reads a line of input and puts it in a C string.  If the line of input
   // is longer than the buffer array only gets enough chars that fit (and ignores the
   // rest); this prevents it from overwriting the end of the array.
   // Unlike Java Scanner nextLine(), fgets also saves the newline in the buffer.
   // So after call, buffer will have 0 or more chars, 
   // then a newline char ('\n'), and then the null char ('\0')
   // note: the sizeof function below does not work with dynamic arrays..
   // fgets returns 0 (false) when it hits EOF


   while (fgets(buffer, sizeof(buffer), stdin)) {
      
      
      char areaCode[4];
      char prefix[4];
      char lineNumber[5];
      readField(buffer,0,3,areaCode);
      readField(buffer,4,3,prefix);
      readField(buffer,8,4,lineNumber);
      cout << "area code: '"  << areaCode << "' " << endl;
       cout << "prefix: '"  << prefix << "' " << endl;
       cout << "line number: '"  << lineNumber << "'" << endl;



   }

  

}
